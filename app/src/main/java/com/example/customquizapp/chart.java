package com.example.customquizapp;

import android.content.Intent;
import android.graphics.Point;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.Query;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.jjoe64.graphview.DefaultLabelFormatter;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.text.SimpleDateFormat;
import java.util.Date;

public class chart extends AppCompatActivity {

    EditText yValue;
    Button btn_insert, btn_remove;
    ImageView back, home;

    FirebaseDatabase database;
    DatabaseReference reference;

    SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
    GraphView graphView;
    LineGraphSeries series;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chart);
        getSupportActionBar().hide();

        yValue = (EditText) findViewById(R.id.y_value);
        btn_insert = (Button) findViewById(R.id.btn_insert);
        btn_remove = (Button) findViewById(R.id.btn_remove);
        graphView = (GraphView) findViewById(R.id.graph);
        back = findViewById(R.id.back);
        home = findViewById(R.id.home);

        series = new LineGraphSeries();
        graphView.addSeries(series);

        database = FirebaseDatabase.getInstance();


        FirebaseAuth auth = FirebaseAuth.getInstance();
        String uid = auth.getUid();
        reference = database.getReference(uid + "/BMIchart");


        setListeners();

        graphView.getGridLabelRenderer().setNumHorizontalLabels(5);

        graphView.getViewport().setScalable(true);
        graphView.getViewport().setScalableY(true);

        graphView.getViewport().setScrollable(true);
        graphView.getViewport().setScrollable(true);

        graphView.getViewport().setXAxisBoundsManual(true);
        graphView.getGridLabelRenderer().setLabelFormatter(new DefaultLabelFormatter() {
            @Override
            public String formatLabel(double value, boolean isValueX) {


                if(isValueX) {
                    return sdf.format(new Date((long) value));
                } else {
                    return super.formatLabel(value, isValueX);
                }
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(chart.this, BMIactivity.class);
                startActivity(intent);
            }
        });

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(chart.this, HomePage.class);
                startActivity(intent);
            }
        });

    }

    private void setListeners() {
        btn_insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Insert new data into the database
                String id = reference.push().getKey();
                long x = new Date().getTime();
                int y = Integer.parseInt(yValue.getText().toString());

                PointValue pointValue = new PointValue(x, y);

                reference.child(id).setValue(pointValue);
            }
        });

        btn_remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Query lastQuery = reference.limitToLast(1);
                lastQuery.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {

                        for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                            snapshot.getRef().removeValue();
                        }
                    }
                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }
        });
    }


    @Override
    protected void onStart() {
        super.onStart();

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                DataPoint[] dp = new DataPoint[(int) dataSnapshot.getChildrenCount()];
                int index = 0;

                for(DataSnapshot myDataSnapShot : dataSnapshot.getChildren()) {
                    PointValue pointValue = myDataSnapShot.getValue(PointValue.class);

                    dp[index] = new DataPoint(pointValue.getxValue(), pointValue.getyValue());
                    index++;
                }

                series.resetData(dp);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}
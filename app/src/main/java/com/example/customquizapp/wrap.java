package com.example.customquizapp;

        import androidx.appcompat.app.AppCompatActivity;

        import android.content.Intent;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.ImageView;

public class wrap extends AppCompatActivity {

    ImageView ingredients, back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wrap);
        getSupportActionBar().hide();

        //https://www.bbcgoodfood.com/recipes/spicy-chicken-avocado-wraps reference

        ingredients = findViewById(R.id.ingredients);
        back = findViewById(R.id.back);

        ingredients.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ingr = new Intent(wrap.this, wrapIng.class);
                startActivity(ingr);
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(wrap.this, foodTip.class);  // home screen
                startActivity(intent);
            }
        });
    }
}
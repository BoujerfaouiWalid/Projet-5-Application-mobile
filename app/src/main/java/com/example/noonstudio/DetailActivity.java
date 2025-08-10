package com.example.noonstudio;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        // View references
        ImageView posterDetail = findViewById(R.id.posterDetail);
        TextView titleDetail = findViewById(R.id.titleDetail);
        Button buttonRent = findViewById(R.id.buttonRent);

        // Retrieve data from Intent
        String title = getIntent().getStringExtra("title");
        String posterName = getIntent().getStringExtra("poster");

        if (title != null) {
            titleDetail.setText(title);
        } else {
            titleDetail.setText(R.string.unknown_film_title); // fallback text
        }

        // Load poster safely
        @DrawableRes int resId = getResources().getIdentifier(
                posterName != null ? posterName : "",
                "drawable",
                getPackageName()
        );

        if (resId != 0) {
            posterDetail.setImageResource(resId);
        } else {
            posterDetail.setImageResource(R.drawable.placeholder_poster); // fallback image
        }

        // Button action
        buttonRent.setOnClickListener(v -> {
            String filmTitle = title != null ? title : getString(R.string.unknown_film_title);
            Toast.makeText(this, "Film loué : " + filmTitle, Toast.LENGTH_SHORT).show();
            // TODO: Add rental saving logic here
        });
    }
}

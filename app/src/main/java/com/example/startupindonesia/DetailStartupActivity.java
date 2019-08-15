package com.example.startupindonesia;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailStartupActivity extends AppCompatActivity {

    ImageView imageView;
    TextView name, category, description;
    String startupName, startupCategory, startupDescription, imageUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.startup_detail);

        name = findViewById(R.id.tv_detail_name);
        category = findViewById(R.id.tv_detail_category);
        description = findViewById(R.id.tv_detail_description);
        imageView = findViewById(R.id.detail_img);

        startupName = getIntent().getStringExtra("name");
        startupCategory = getIntent().getStringExtra("category");
        startupDescription = getIntent().getStringExtra("description");
        imageUrl = getIntent().getStringExtra("image");

        getSupportActionBar().setTitle(startupName);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(0xff3b5998));

        name.setText(startupName);
        category.setText("Category: " + startupCategory);
        description.setText("\t\t\t\t\t" + startupDescription);
        Glide.with(this)
                .asBitmap()
                .load(imageUrl)
                .into(imageView);
    }
}

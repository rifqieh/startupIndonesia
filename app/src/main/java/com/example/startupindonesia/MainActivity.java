package com.example.startupindonesia;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvStartups;
    private ArrayList<Startup> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        getSupportActionBar().setTitle("Startup di Indonesia");
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(0xff3b5998));


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvStartups = findViewById(R.id.rv_startup);
        rvStartups.setHasFixedSize(true);

        list.addAll(StartupsData.getListData());
        showRecyclerList();
    }

    private void showRecyclerList() {
        rvStartups.setLayoutManager(new LinearLayoutManager(this));
        ListStartupAdapter listStartupAdapter = new ListStartupAdapter(this, list);
        rvStartups.setAdapter(listStartupAdapter);
    }
}

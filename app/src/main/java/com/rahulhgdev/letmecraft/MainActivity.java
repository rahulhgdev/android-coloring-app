package com.rahulhgdev.letmecraft;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ResourceCursorAdapter;
//import android.widget.Toolbar;


import com.rahulhgdev.letmecraft.Adapters.ImageAdapters;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ImageAdapters imageAdapters;
   Button openPainting;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initToolbar();

        initView();
    }

    private void initView() {
        recyclerView = findViewById(R.id.recycler_view_images);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        imageAdapters = new ImageAdapters(this);
        recyclerView.setAdapter(imageAdapters);
    }

    private void initToolbar() {

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        int toolbar_item_color  = ResourcesCompat.getColor(getResources(),R.color.blue,null);
        toolbar.setTitleTextColor(toolbar_item_color);
        toolbar.setSubtitleTextColor(toolbar_item_color);
        getSupportActionBar().setTitle("Select Picture");
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.close);
        
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if(id == android.R.id.home){
            finish();

        }

        return super.onOptionsItemSelected(item);
    }

    public void openPainting(View view) {

        openPainting = findViewById(R.id.button);
        openPainting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPaintingActivity();
            }
        });
    }

    private void openPaintingActivity() {

        Intent intent = new Intent(this, PaintingActivity.class);
        startActivity(intent);
    }
}
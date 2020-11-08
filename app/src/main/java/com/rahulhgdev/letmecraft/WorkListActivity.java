package com.rahulhgdev.letmecraft;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.view.MenuItem;

import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.rahulhgdev.letmecraft.Adapters.WorkAdapters;
import com.rahulhgdev.letmecraft.common.Common;

import java.io.File;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class WorkListActivity extends AppCompatActivity {

    List<File> listImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work_list);

        initToolbar();
        initView();
    }

    private void initView() {

        RecyclerView recyclerView = findViewById(R.id.recycler_view_worklist);
        recyclerView.setHasFixedSize(true);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,3);
        recyclerView.setLayoutManager(gridLayoutManager);

        listImage = getFiles();
        WorkAdapters adapter = new WorkAdapters(this, listImage);
        recyclerView.setAdapter(adapter);
    }

    private List<File> getFiles(){

        ArrayList<File> result = new ArrayList<>();
        File folder;

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q){
            folder = new File(getExternalFilesDir(Environment.DIRECTORY_PICTURES) +
                    File.separator + "Let Me Craft !!");
        }else {
            folder = new File(Environment.getExternalStorageDirectory() + File.separator + File.separator + getString(R.string.app_name));
        }

        File subFolder = new File(folder, Common.ITEM_SELECTED);
        File[] files = subFolder.listFiles();
        if(files != null){
            for(File file: files){
                 if(file.getName().endsWith(".png")){
                     result.add(file);
                 }
            }
        }
      return result;
    }


    private void initToolbar() {

        Toolbar toolbar = findViewById(R.id.appbar3);
        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle("Work List");
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.previous);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if(item.getItemId() == android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        if (item.getTitle().equals(Common.DELETE)) {
            deleteFile(item.getOrder());
            initView();

        }
        return true;
    }

    private void deleteFile(int order) {

        listImage.get(order).delete();
        listImage.remove(order);
    }

}
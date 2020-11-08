package com.rahulhgdev.letmecraft.Adapters;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.rahulhgdev.letmecraft.Intreface.ImageOnClick;
import com.rahulhgdev.letmecraft.R;
import com.rahulhgdev.letmecraft.ViewFileActivity;
import com.rahulhgdev.letmecraft.ViewHolder.WorkViewHolder;
import com.rahulhgdev.letmecraft.WorkListActivity;

import java.io.File;
import java.util.List;

public class WorkAdapters extends RecyclerView.Adapter<WorkViewHolder> {

    private Context wContext;   //w -work
    private List<File> fileList ;

    public WorkAdapters(Context wContext, List<File> fileList) {
        this.wContext = wContext;
        this.fileList = fileList;
    }



    @NonNull
    @Override
    public WorkViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(wContext).inflate(R.layout.item_work,parent,false);
        return new WorkViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WorkViewHolder holder, int position) {
        holder.imageView.setImageURI(Uri.fromFile(fileList.get(position)));
        holder.setImageOnClick(new ImageOnClick() {
            @Override
            public void onClick(int pos) {
                Intent intent = new Intent(wContext, ViewFileActivity.class);
                intent.setData(Uri.fromFile(fileList.get(pos)));
                wContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
         return fileList.size();
        //return 0;
    }
}

package com.rahulhgdev.letmecraft.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.rahulhgdev.letmecraft.Intreface.ImageOnClick;
import com.rahulhgdev.letmecraft.PaintActivity;
import com.rahulhgdev.letmecraft.R;
import com.rahulhgdev.letmecraft.ViewHolder.ImageViewHolder;
import com.rahulhgdev.letmecraft.WorkListActivity;
import com.rahulhgdev.letmecraft.common.Common;

import java.util.ArrayList;
import java.util.List;

public class ImageAdapters extends RecyclerView.Adapter<ImageViewHolder> {

    private Context mContext;
    private List<Integer> listImage;

    public ImageAdapters(Context mContext){
        this.mContext = mContext;
        this.listImage = getImages();

    }

    private List<Integer> getImages() {

        List<Integer> results = new ArrayList<>();

        results.add(R.drawable.image1);
        results.add(R.drawable.image2);
        results.add(R.drawable.image3);
        results.add(R.drawable.image4);
        results.add(R.drawable.image5);
        results.add(R.drawable.image6);
        results.add(R.drawable.image7);
        results.add(R.drawable.image8);
        results.add(R.drawable.image9);
        results.add(R.drawable.image10);
        results.add(R.drawable.image11);
        results.add(R.drawable.image12);
        results.add(R.drawable.image13);
        results.add(R.drawable.image14);
        results.add(R.drawable.image15);

        return results;
    }

    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_images,parent,false);
        return new ImageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageViewHolder holder, int position) {
            holder.imageView.setImageResource(listImage.get(position));
            holder.setImageOnClick(new ImageOnClick() {
                @Override
                public void onClick(int pos) {
                    Common.ITEM_SELECTED = " "+position;
                    Common.PICTURE_SELECTED = listImage.get(pos);
                    mContext.startActivity(new Intent(mContext, PaintActivity.class));
                }
            });

            holder.imageButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Common.ITEM_SELECTED = " "+position;
                    mContext.startActivity(new Intent(mContext, WorkListActivity.class));
                }
            });
    }

    @Override
    public int getItemCount() {
        return listImage.size();
    }
}

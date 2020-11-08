package com.rahulhgdev.letmecraft.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

import com.rahulhgdev.letmecraft.common.Common;
import com.rahulhgdev.letmecraft.utility.FloodFill;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class PaintView extends View {

    Bitmap bitmap;
    public PaintView(Context context) {
        super(context);
    }

    public PaintView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        if(bitmap == null) {
            Bitmap srcBitmap = BitmapFactory.decodeResource(getResources(), Common.PICTURE_SELECTED);
            bitmap = Bitmap.createScaledBitmap(srcBitmap, w, h, false);

            for(int i=0; i<bitmap.getWidth();i++){

                for (int j=0;j<bitmap.getHeight();j++){
                    int alpha = 255 - brightness(bitmap.getPixel(i,j));

                    if(alpha  < 200){
                        bitmap.setPixel(i,j, Color.WHITE);
                    }else {
                        bitmap.setPixel(i,j, Color.BLACK);
                    }
                }
            }
            if (defaultBitmap == null)
                defaultBitmap = Bitmap.createBitmap(bitmap);

        }
    }

    private int brightness(int color) {

        return (color >> 16) & 0xff;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawBitmap(bitmap,0,0,null);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        paint((int) event.getX(),(int) event.getY());
        return super.onTouchEvent(event);
    }

    private void paint(int x, int y) {

        int targetColor = bitmap.getPixel(x,y);
        if(targetColor != Color.BLACK) {
            FloodFill.floodFill(bitmap, new Point(x, y), targetColor, Common.COLOR_SELECTED);

            addLastAction(Bitmap.createBitmap(getBitmap()));

            invalidate();
        }
    }

    public Bitmap getBitmap() {
        return bitmap;
    }


    private List<Bitmap> bitmapList = new ArrayList<>();
    private Bitmap defaultBitmap = null;
    public void undoLastAction() {

        if(bitmapList.size() > 0){

            bitmapList.remove(bitmapList.size() - 1);
                if(bitmapList.size() > 0){
                    bitmap = bitmapList.get(bitmapList.size() - 1);
                }else {
                    bitmap = Bitmap.createBitmap(defaultBitmap);
            }
                invalidate();
        }
    }

    private void addLastAction(Bitmap b){
        bitmapList.add(b);
    }
}

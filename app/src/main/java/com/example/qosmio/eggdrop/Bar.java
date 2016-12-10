package com.example.qosmio.eggdrop;


import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;

/**
 * Created by Qosmio on 11/26/2016.
 */

public class Bar extends GameObject {

    Bitmap barImage;
    Rect bar;
    Paint p = new Paint();
    int score = 1;
    public Bar(Bitmap bm, int width,int height){
        barImage = bm;
        //this.setX(GamePanel.WIDTH/2);
        this.setY(GamePanel.HEIGHT - 150);
        this.setWidth(width);
        this.setHeight(height);



    }

    public void update(){

    }

    public int getScore(){
        return score;
    }



    public void draw(Canvas canvas){

        //bar = new Rect(this.x,this.y,x+ this.width,y+ this.height);
        canvas.drawBitmap(barImage,this.x-30,this.y, null);

        p.setColor(Color.RED);

        //canvas.drawRect(bar, p);

        p.setColor(Color.BLACK);
        p.setTextSize(30);
        canvas.drawText("Score: " + score,30, 50, p);
        //RectF rf = new RectF(this.x+50,this.y-50,x+ this.width,y+ this.height);

        //canvas.drawOval(rf,p);

    }

}

package com.example.qosmio.eggdrop;


import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;

/**
 * Created by Qosmio on 11/26/2016.
 */

public class Eggs extends GameObject {

    Bitmap eggBitmap;
    public Eggs(Bitmap b){
        this.eggBitmap = b;

    }

    public void update(){
        this.y += this.velocityY*2;
        if(this.y>GamePanel.HEIGHT){
            this.y = 0;
        }
    }

    public void draw(Canvas canvas){
        // Paint p = new Paint();
        //p.setColor(Color.YELLOW);

        //RectF rf = new RectF(this.x,this.y,this.x+width,this.y+height);
        //canvas.drawOval(rf, p);
        canvas.drawBitmap(this.eggBitmap,this.x,this.y,null);
    }



}

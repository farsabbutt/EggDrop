package com.example.qosmio.eggdrop;


import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.util.DisplayMetrics;

/**
 * Created by Qosmio on 11/26/2016.
 */

public class Background {

    Bitmap backgroundImage;
    int x,y,velocityX;

    public Background(Bitmap img){
        this.backgroundImage = img;
    }


    public void update(){

        x += this.velocityX;
        if(x<-GamePanel.WIDTH){
            x = 0;
        }
    }

    public void draw(Canvas canvas){

        backgroundImage = Bitmap.createScaledBitmap(backgroundImage, GamePanel.deviceWidth,GamePanel.deviceHeight/2,true);
        canvas.drawBitmap(backgroundImage,x,y,null);

        //canvas.drawBitmap(backgroundImage,x+GamePanel.WIDTH,y,null);
    }

    public void setVelocityX(int vx){
        this.velocityX = vx;
    }


}

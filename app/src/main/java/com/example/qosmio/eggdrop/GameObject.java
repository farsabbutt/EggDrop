package com.example.qosmio.eggdrop;


import android.graphics.Rect;

/**
 * Created by Qosmio on 11/26/2016.
 */

public abstract class GameObject {

    protected int x,y,velocityX,velocityY,width,height;

    public void setX(int x){this.x = x;}
    public void setY(int y){this.y = y;}
    public void setVelocityX(int vx){this.velocityX = vx;}
    public void setVelocityY(int vy){this.velocityY = vy;}
    public void setWidth(int w){this.width = w;}
    public void setHeight(int h){this.height = h;}

    public int getX(){ return this.x;}
    public int getY(){ return this.y;}
    public int getVelocityX(){ return this.velocityX;}
    public int getVelocityY(){ return this.velocityY; }
    public int getWidth(){return this.width;}
    public int getHeight(){return this.height;}

    public Rect getRectangle(){

        return (new Rect(x,y,x+width,y+height));
    }




}

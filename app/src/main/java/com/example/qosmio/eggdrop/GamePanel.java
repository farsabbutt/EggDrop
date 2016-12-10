package com.example.qosmio.eggdrop;


import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Qosmio on 11/26/2016.
 */

public class GamePanel extends SurfaceView implements SurfaceHolder.Callback {

    public static final int WIDTH = 856 ,HEIGHT = 480;
    private Background bg;
    private MainThread mainThread;
    private Bar bar;
    private ArrayList<Eggs> EggsList = new ArrayList<Eggs>();
    private long eggStartTime;
    private Random random;
    DisplayMetrics displayMetrics;
    static int deviceWidth;
    static int deviceHeight;
    public GamePanel(Context context){
        super(context);
        displayMetrics = context.getResources().getDisplayMetrics();
        deviceWidth = displayMetrics.widthPixels;
        deviceHeight = displayMetrics.heightPixels;
        // add callback to surface holder
        getHolder().addCallback(this);

        // instantiate thread.
        mainThread = new MainThread(getHolder(), this);


        setFocusable(true);
    }


    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        bg = new Background(BitmapFactory.decodeResource(getResources(), R.drawable.gamebg));
        bar = new Bar(BitmapFactory.decodeResource(getResources(),R.drawable.basket), 100,15);
        random = new Random();
        // random.nextInt();


        eggStartTime = System.nanoTime();
        mainThread.start();
        mainThread.setRunning(true);
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        boolean retry = true;
        while(retry){

            try {
                mainThread.setRunning(false);
                mainThread.join();
            }catch (InterruptedException ex){
                System.out.println(ex.getStackTrace());
            }

        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event){
        System.out.println(event.toString());
        if(event.getAction()==MotionEvent.ACTION_DOWN) {

            bar.setX((int) event.getAxisValue(MotionEvent.AXIS_X) / 2);

        }
        return super.onTouchEvent(event);
    }



    public void update() {
        bar.update();
        long eggElapsed = (System.nanoTime()-eggStartTime)/1000000;

        //if(eggElapsed >(2000 - bar.getScore()/4)) {
        // creating eggs
        //for(int x=0; x<random.nextInt(6 - 1 + 1) + 1;x++){
        Eggs egg = new Eggs(BitmapFactory.decodeResource(getResources(), R.drawable.egg));
        egg.setX(random.nextInt(1000));
        egg.setY(0);
        egg.setWidth(50);
        egg.setHeight(50);
        egg.setVelocityY(random.nextInt(5 - 1 + 1) + 1);
        if(EggsList.size() < 3){
            EggsList.add(egg);
        }
        //}
        // }

        for (Eggs e :
                EggsList) {
            e.update();
            if(e.getY() > GamePanel.HEIGHT){
                EggsList.remove(e);
            }

            if(collision(bar,e)){
                bar.score++;
                EggsList.remove(e);
            }
        }
    }

    private boolean collision(GameObject a, GameObject b) {

        if(Rect.intersects(a.getRectangle(),b.getRectangle())){
            return true;
        }
        return false;
    }

    public void draw(Canvas canvas) {
        final float scaleFactorX = getWidth()/WIDTH;
        final float scaleFactorY = getHeight()/HEIGHT;

        if(canvas != null){
            final int savedState = canvas.save();
            canvas.scale(scaleFactorX,scaleFactorY);
            // draw objects here
            bg.draw(canvas);
            bar.draw(canvas);

            for (Eggs e:EggsList) {
                e.draw(canvas);
            }
            canvas.restoreToCount(savedState);
        }
    }


}

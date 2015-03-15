package com.xten.thread.monitor;


/**
 * Created by xten on 15/3/14.
 */
public class Monitor {



    public static void main(String args[]) {
        MutablePoint mutablePoint=new MutablePoint();
        mutablePoint.y=1;
        System.out.println(mutablePoint.y);

        Point point=new Point(1,2);
        System.out.println(point.x);


    }


}

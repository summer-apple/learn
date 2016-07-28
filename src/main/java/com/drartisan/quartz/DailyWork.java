package com.drartisan.quartz;

import java.util.Date;
/**
 * Created by summer on 16/3/29.
 */
public class DailyWork {
    int i = 20;

    public void work() throws InterruptedException{

        int time = i * 1000;
        System.out.println(time);
        Thread.sleep(time);

        System.out.println(new Date() + " Quartz working... "+ --i );


    }
}

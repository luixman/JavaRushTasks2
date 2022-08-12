package com.javarush.task.pro.task08.task0810;

import java.util.concurrent.TimeUnit;

/* 
Таймер
*/

public class Solution {

    public static void setTimer(int days, int hours, int minutes, int seconds, int millis) throws InterruptedException {
        System.out.println("Таймер запущен!");
        //напишите тут ваш код
        TimeUnit.HOURS.sleep(hours);
        TimeUnit.SECONDS.sleep(seconds);
        TimeUnit.DAYS.sleep(days);
        TimeUnit.MINUTES.sleep(minutes);
        TimeUnit.MILLISECONDS.sleep(millis);
        boolean a=true;
        boolean b=false;
        if(a & b){

        }

        System.out.println("♬ ♪ ♬♬♬♬ ♪♪♪♪");
    }
}

package com.javarush.task.task25.task2512;

import java.util.ArrayList;
import java.util.List;

/* 
Живем своим умом
*/

public class Solution implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        t.interrupt();
        List<Throwable> listExc = new ArrayList<>();
        while(e!=null){
            listExc.add(0,e);
            e = e.getCause();
        }
        listExc.forEach(System.out::println);
    }

    public static void main(String[] args) {
        new Solution().uncaughtException(new Thread(),new Exception("ABC", new RuntimeException("DEF", new IllegalAccessException("GHI"))));
    }
}

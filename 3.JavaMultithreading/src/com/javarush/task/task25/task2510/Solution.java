package com.javarush.task.task25.task2510;

/* 
Поживем - увидим
*/

public class Solution extends Thread {

    private static final UncaughtExceptionHandler exceptionHandler =new Thread.UncaughtExceptionHandler(){
        @Override
                public void uncaughtException(Thread t, Throwable e){
            if(e instanceof Error)
                System.out.println("Нельзя дальше работать");
            else if(e instanceof Exception)
                System.out.println( "Надо обработать");
            else System.out.println( "Поживем - увидим");


        }
    };


    public Solution() throws Exception {
    this.setUncaughtExceptionHandler(exceptionHandler);
    this.start();


    }

    @Override
    public void run()  {
        super.run();
        int i= 1/0;


    }

    public static void main(String[] args) throws Exception {
        for (int i = 0; i < 100; i++) {


            Thread thread = new Solution();
        }

    }
}

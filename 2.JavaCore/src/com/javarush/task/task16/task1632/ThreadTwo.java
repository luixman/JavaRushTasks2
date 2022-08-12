package com.javarush.task.task16.task1632;

public class ThreadTwo implements Runnable{
    @Override
    public void run() {
        try{
            while (true){
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println("InterruptedException");
        }
    }
}

package com.javarush.task.task16.task1632;

public class threadOne implements Runnable{
    @Override
    public void run() {
        while(true){
            try{
                Thread.sleep(1000);
            }catch(InterruptedException ie){

            }
        }
    }
}

package com.javarush.task.task16.task1632;

public class ThreadFour implements Message {
    @Override
    public void run() {
        try {
            while (true) {
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {

        }
    }

    @Override
    public void showWarning() {
        Thread.currentThread().interrupt();
    }
}

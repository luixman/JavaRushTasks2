package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Клубок
*/

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);

    static {
        threads.add(new Thread(new threadOne()));
        threads.add(new Thread(new ThreadTwo()));
        threads.add(new Thread(new ThreadThree()));
        threads.add(new Thread4());
        threads.add(new Thread(new ThreadFive()));
    }

    public static void main(String[] args) throws InterruptedException {
        //  threads.forEach(Thread::start);
       // threads.get(3).start();
       // Thread.sleep(5000);
       // threads.get(3).isAlive();






    }

    public static class Thread4 extends Thread implements Message {
        public void run() {
            while (!isInterrupted()) {
            }
        }

        public void showWarning() {
            this.interrupt();
        }
    }
}





import java.util.HashMap;
import java.util.regex.Pattern;

/* 
Двоично-шестнадцатеричный конвертер
*/

public class Solution {
    private static ThreadLocal<String> threadLocal = new ThreadLocal<>();

    public static void main(String[] args) throws InterruptedException {
        class MyRunnable implements Runnable {

            @Override
            public void run() {
                String name = Thread.currentThread().getName();
                System.out.println(name + " first threadLocal: "
                        + threadLocal.get());
                threadLocal.set(name + " thread value");
                System.out.println(name + " end threadLocal: "
                        + threadLocal.get());
            }
        };

        threadLocal.set("From main thread");
        Thread thread1 = new Thread(new MyRunnable(), "first_thread");
        thread1.start();
        Thread thread2 = new Thread(new MyRunnable(), "second_thread");
        thread2.start();
        thread1.join();
        thread2.join();

        System.out.println("fromMainThread: " + threadLocal.get());
    }
}
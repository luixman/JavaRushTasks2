package com.javarush.task.pro.task08.task0808;

/* 
Обратный отсчет
*/

public class Solution {

    public static void main(String[] args) throws InterruptedException {
        countDown();
    }
    public static void countDown() throws InterruptedException {
        System.out.println("3");
        sleepOneSecond();
        System.out.println("2");
        sleepOneSecond();
        System.out.println("1");
        sleepOneSecond();
        System.out.println("Старт!");
    }

    public static void sleepOneSecond() throws InterruptedException{
        Thread.sleep(1000);
    }
}

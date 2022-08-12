package com.javarush.task.pro.task05.task0501;

/* 
Создаем массивы
*/

public class Solution {
    public static int getRandomDiceNumber()
    {
        return (int) (Math.random() * 6);
    }

    public static void main(String[] args)
    {
        for (int i = 0; i < 100; i++)
        {
            int x = getRandomDiceNumber();
           // System.out.print(x+" ");
        }
        System.out.println("Hello world!"+1);
    }
}

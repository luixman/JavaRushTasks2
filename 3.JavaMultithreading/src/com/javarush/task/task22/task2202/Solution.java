package com.javarush.task.task22.task2202;

/* 
Найти подстроку
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(getPartOfString("JavaRush - лучший сервис обучения Java."));
    }

    public static String getPartOfString(String string) {
       try {
           String[] s = string.split(" ");
           StringBuilder sb = new StringBuilder();

           for (int i = 1; i < 5; i++) {
               sb.append(s[i]).append(" ");
           }
           return sb.toString().substring(0, sb.length() - 1);
       }catch (RuntimeException e){
           throw new TooShortStringException();
       }
    }

    public static class TooShortStringException extends RuntimeException{
    }
}

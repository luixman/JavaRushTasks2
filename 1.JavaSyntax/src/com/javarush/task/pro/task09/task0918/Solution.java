package com.javarush.task.pro.task09.task0918;

/* 
Поработаем со StringBuilder
*/

import java.lang.reflect.Array;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        String string = "Учиться, учиться и еще раз учиться! ";

        System.out.println(addTo(string, new String[]{"Под ", "лежачий ", "камень ", "вода ", "не ", "течет"}));
        System.out.println(replace(string, ", ", 16, 27));
    }

    public static StringBuilder addTo(String string, String[] strings) {
        //напишите тут ваш код
        StringBuilder stringBuilder=new StringBuilder();

        stringBuilder.append(string);
        for (String s : strings) {
            stringBuilder.append(s);
        }


        return stringBuilder;
    }

    public static StringBuilder replace(String string, String str, int start, int end) {
        StringBuilder stringBuilder=new StringBuilder();
        stringBuilder.append(string);
        stringBuilder.replace(start,end,str);
        return stringBuilder;
    }
}

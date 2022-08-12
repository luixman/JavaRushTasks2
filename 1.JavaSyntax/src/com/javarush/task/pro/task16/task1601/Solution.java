package com.javarush.task.pro.task16.task1601;

import java.util.Calendar;
import java.util.Date;

/* 
Лишь бы не в понедельник :)
*/

public class Solution {

    static Date birthDate=new Date(98,0,29,0,0,0);;

    public static void main(String[] args) {
        System.out.println(getDayOfWeek(birthDate));
    }

    static String getDayOfWeek(Date date) {

        int day = date.getDay();
        String[] week = {"воскресенье", "понедельник", "вторник", "среда", "четверг", "пятница", "суббота"};

        return week[day];


    }
}

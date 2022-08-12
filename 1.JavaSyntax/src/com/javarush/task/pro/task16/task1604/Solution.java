package com.javarush.task.pro.task16.task1604;



import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

/* 
День недели рождения твоего
*/

public class Solution {

    static Calendar birthDate=new GregorianCalendar(1998, Calendar.JANUARY,29);

    public static void main(String[] args) {
        System.out.println(getDayOfWeek(birthDate));
    }

    static String getDayOfWeek(Calendar calendar) {
        //напишите тут ваш код
        String[] week = {"воскресенье", "понедельник", "вторник", "среда", "четверг", "пятница", "суббота"};
        return week[calendar.get(Calendar.DAY_OF_WEEK)-1];
    }
}

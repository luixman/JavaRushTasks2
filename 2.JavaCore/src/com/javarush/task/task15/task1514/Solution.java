package com.javarush.task.task15.task1514;

import java.util.HashMap;
import java.util.Map;

/* 
Статики-1
*/

public class Solution {
    public static Map<Double, String> labels = new HashMap<Double, String>();

    static {
        labels.put(10.0,"1");
        labels.put(11.0,"2");
        labels.put(12.0,"3");
        labels.put(13.0,"4");
        labels.put(14.0,"5");


    }

    public static void main(String[] args) {
        System.out.println(labels);
    }
}

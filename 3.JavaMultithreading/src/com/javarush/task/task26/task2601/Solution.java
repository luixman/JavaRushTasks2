package com.javarush.task.task26.task2601;

import java.util.*;
import java.util.stream.Collectors;

/* 
Почитать в инете про медиану выборки
*/

public class Solution {

    public static void main(String[] args) {
       /* Integer[] array =new Integer[]{1,2,3,10,15,16,17};

        array =sort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }*/


    }

    public static Integer[] sort(Integer[] array) {
        final double mediana = getMediana(array);

        Arrays.sort(array, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                double v1 = o1.intValue() - mediana;
                double v2 = o2.intValue() - mediana;
                return (int) ((v1 * v1 - v2 * v2) * 100);
            }
        });

        return array;
    }

    private static double getMediana(Integer[] array) {
        Arrays.sort(array);
        double res;
        int length = array.length;

        if (length % 2 == 1) {
            res = array[length / 2];
        } else {
            res = (array[length / 2 - 1] + array[length / 2]) / 2.;
        }
        return res;
    }
}

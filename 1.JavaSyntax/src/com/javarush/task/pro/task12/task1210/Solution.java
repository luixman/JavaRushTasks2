package com.javarush.task.pro.task12.task1210;

import java.util.ArrayList;

/* 
Переворачивание данных
*/

public class Solution {

    public static ArrayList<Integer> numbers=new ArrayList<Integer>();

    public static void main(String[] args) {
        init();
        print();

        reverse();
        print();
    }

    public static void init() {
        for (int i = 0; i < 10; i++) {
            numbers.add(i);
        }
    }

    public static void reverse() {
        for (int i = 0; i <numbers.size(); i++) {

            int temp=numbers.remove(numbers.size()-1);
            numbers.add(i,temp);








        }



    }

    private static void print() {
        for (int i = 0; i < numbers.size(); i++) {

            System.out.println(numbers.get((i)));
        }
    }
}

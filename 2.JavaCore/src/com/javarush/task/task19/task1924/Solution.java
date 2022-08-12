package com.javarush.task.task19.task1924;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* 
Замена чисел
*/

public class Solution {
    public static Map<Integer, String> map = new HashMap<Integer, String>();
    static {
        map.put(0, "ноль");
        map.put(1, "один");
        map.put(2, "два");
        map.put(3, "три");
        map.put(4, "четыре");
        map.put(5, "пять");
        map.put(6, "шесть");
        map.put(7, "семь");
        map.put(8, "восемь");
        map.put(9, "девять");
        map.put(10, "десять");
        map.put(11, "одиннадцать");
        map.put(12, "двенадцать");

    }

    public static void main(String[] args) throws IOException{

        String fileName;
        try(BufferedReader console = new BufferedReader(new InputStreamReader(System.in))){
            fileName=console.readLine();
        }



        try(BufferedReader reader = new BufferedReader(new FileReader(fileName))){
            while(reader.ready()){
                String[] line = reader.readLine().split(" ");

                for (int i=0;i<line.length;i++) {
                    for (Map.Entry<Integer,String> elem: map.entrySet()) {
                       // if(line[i].equals(elem.getKey().toString()))
                           // line[i]=elem.getValue();
                        line[i] = line[i].replaceAll("\\b"+elem.getKey()+"\\b",elem.getValue());
                        //здесь вообще можно выкинуть массив и использовать всю строку

                    }
                }
                System.out.println(String.join(" ",line));

            }
        }




    }
}

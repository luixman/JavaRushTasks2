package com.javarush.task.task18.task1821;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/* 
Встречаемость символов
*/

public class Solution {
    public static void main(String[] args) {
        Map<Character, Integer> characterCount = new TreeMap<>();
        String fileName = null;

        if (args.length != 0) {
            fileName = args[0];
        }

        try(FileReader reader = new FileReader(fileName)){

            while (reader.ready()) {
                char c = (char)reader.read();

                if (!characterCount.containsKey(c)){
                    characterCount.put(c,1);
                } else{
                   // characterCount.put(c,characterCount.get(c)+1);
                    characterCount.compute(c,(k,v)->v+=1);
                }
            }

        }catch (IOException e){

        }

        for (char c :
                characterCount.keySet()) {
            System.out.println(c+" "+characterCount.get(c));
        }


    }
}

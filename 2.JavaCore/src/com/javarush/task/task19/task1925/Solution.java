package com.javarush.task.task19.task1925;

import java.io.*;
import java.util.ArrayList;

/* 
Длинные слова
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        String fileName1 = args[0];
        String fileName2 = args[1];

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName1));
             FileWriter writer = new FileWriter(fileName2)) {
            ArrayList<String> longWords = new ArrayList<>();
            while(reader.ready()){
                String [] line =reader.readLine().split("\\s");
                for (String s :
                        line) {
                    if(s.length()>6){
                        longWords.add(s);
                    }

                }
            }
            writer.write(String.join(",",longWords));

        }


    }
}

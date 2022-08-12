package com.javarush.task.task19.task1907;

import java.io.*;

/* 
Считаем слово
*/

public class Solution {
    public static void main(String[] args) throws IOException {

        String fileName;

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            fileName = br.readLine();
        }

        StringBuilder text = new StringBuilder();

        try (FileReader reader = new FileReader(fileName)) {

            while (reader.ready()) {
                text.append((char)reader.read());

            }

        }
        int sum =0;
        
        
       String[] ms= text.toString().split("\\b");

        for (int i = 0; i < ms.length; i++) {
            if(ms[i].equals("world"))
                sum++;

        }

       

        System.out.println(sum);
    }
}

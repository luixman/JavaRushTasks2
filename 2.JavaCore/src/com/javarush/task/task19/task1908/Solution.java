package com.javarush.task.task19.task1908;

import java.io.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Выделяем числа
*/

public class Solution {
    public static void main(String[] args)throws IOException {
        String fileName;
        String outputFileName;

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            fileName = br.readLine();
            outputFileName = br.readLine();
        }

        StringWriter text= new StringWriter();
        try(BufferedReader reader = new BufferedReader(new FileReader(fileName))){
            while(reader.ready())
                text.append(reader.readLine()+"\n");
        }

       String array[]= text.toString().split("\\b");
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName))){
            for (int i = 0; i < array.length; i++) {
              try {
                  writer.write(Integer.parseInt(array[i])+" ");
              }catch (Exception e){


              }
            }
        }







    }
}

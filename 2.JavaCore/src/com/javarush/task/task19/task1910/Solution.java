package com.javarush.task.task19.task1910;

import java.io.*;
import java.util.ArrayList;

/* 
Пунктуация
*/

public class Solution {
    public static void main(String[] args) throws IOException{
        String fileName;
        String outputFileName;

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            fileName = br.readLine();
            outputFileName = br.readLine();
        }

        try(
                BufferedReader reader = new BufferedReader(new FileReader(fileName));
                BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName))
                ){
            while(reader.ready()){
                writer.write(reader.readLine().replaceAll("(\\p{P})",""));
            }
        }
    }
}

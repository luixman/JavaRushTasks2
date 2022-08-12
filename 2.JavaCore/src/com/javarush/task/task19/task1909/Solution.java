package com.javarush.task.task19.task1909;

import java.io.*;
import java.util.ArrayList;

/* 
Замена знаков
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        String inputFileName;
        String outputFileName;

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            inputFileName = reader.readLine();
            outputFileName = reader.readLine();
        }

        ArrayList<String> fileContent = new ArrayList<>();
        try (BufferedReader inputFileReader = new BufferedReader(new FileReader(inputFileName))) {
            while (inputFileReader.ready()) {
                fileContent.add(inputFileReader.readLine());
            }
        }
        try (BufferedWriter outputFileWriter = new BufferedWriter(new FileWriter(outputFileName))) {
            for (String s : fileContent) {
                outputFileWriter.write(s.replaceAll("\\.", "!"));
            }
        }
    }
}


/* public static void main(String[] args) throws Exception{
        String file1 ;
        String file2 ;
        try( BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            file1 = reader.readLine();
            file2 = reader.readLine();
       }


        try (BufferedReader reader1 = new BufferedReader(new InputStreamReader(new FileInputStream(file1)));
             BufferedWriter writer = new BufferedWriter(new FileWriter(file2))) {

            while(reader1.ready()){
                writer.write(reader1.readLine().replaceAll("\\.","!")+"\n");
            }

        }

    }*/

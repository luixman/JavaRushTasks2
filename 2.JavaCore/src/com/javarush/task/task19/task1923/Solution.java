package com.javarush.task.task19.task1923;

import java.io.*;
import java.util.regex.Pattern;

/* 
Слова с цифрами
*/

public class Solution {
    public static void main(String[] args) {
        try (BufferedReader fileReader = new BufferedReader(new FileReader(args[0]));
             FileWriter fileWriter = new FileWriter(args[1])) {
            String fileReadLine;
            String[] splitedLine;
            while ((fileReadLine = fileReader.readLine()) != null) {
                splitedLine = fileReadLine.split(" ");
                for (String word : splitedLine) {
                    if (word.matches(".*[0-9].*")) {
                        fileWriter.write(word + " ");
                    }
                }
            }
        } catch (IOException ignored) {
        }
    }


    /*    public static void main(String[] args)throws IOException {
        Pattern p = Pattern.compile("(\\b(\\w+)?\\d+(\\w+)?\\b)");
        String file1 = args[0];
        String file2 = args[1];

        try(BufferedReader reader = new BufferedReader(new FileReader(file1));
            FileWriter writer = new FileWriter(file2)){

            while(reader.ready()){
                String[] line =reader.readLine().split(" ");
                for (int i = 0; i < line.length; i++) {
                    if(line[i].matches(p.pattern())) {
                        writer.write(line[i]+" ");

                    }
                }
            }
        }




    }*/
}

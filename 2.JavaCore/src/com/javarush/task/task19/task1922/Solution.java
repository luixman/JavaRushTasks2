package com.javarush.task.task19.task1922;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/* 
Ищем нужные строки
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) throws IOException {

        List<String> stringLines = new ArrayList<>();

        StringBuilder pattern = new StringBuilder();
        for (int i = 0; i < words.size(); i++) {
            if (i == words.size() - 1) {
                pattern.append("(\\b").append(words.get(i)).append("\\b)");
            } else {
                pattern.append("(\\b").append(words.get(i)).append("\\b)|");
            }
        }

        String fileName;
        try (BufferedReader console = new BufferedReader(new InputStreamReader(System.in))) {
            fileName = console.readLine();
        }

        try(BufferedReader reader= new BufferedReader(new FileReader(fileName))){
            while (reader.ready()){
                String[] line =reader.readLine().split(" ");
               int sum=0;
                for (String s: line) {
                    if(s.matches(pattern.toString()))
                        sum++;
                }
                if(sum==2)
                    stringLines.add(String.join(" ",line));
            }
        }

        stringLines.forEach(System.out::println);



    }
}

package com.javarush.task.task18.task1816;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

/* 
Английские буквы
*/

public class Solution {
    private static final String ENGLISH = "abcdefghijklmnopqrstuvwxyz";

    public static void main(String[] args) {

        String path = "";
        if (args.length != 0) {
            path = args[0];
        }

        int sumOfEnglishCharacters = 0;
        try (FileReader reader = new FileReader(path)) {

            while (reader.ready()) {
                char c = (char) reader.read();
                if (ENGLISH.contains(Character.toString(c).toLowerCase())
                        || ENGLISH.contains(Character.toString(c))) {
                    sumOfEnglishCharacters++;
                }

            }

        } catch (IOException e) {

        }


        System.out.println(sumOfEnglishCharacters);


    }
}

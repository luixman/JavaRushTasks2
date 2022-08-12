package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Pattern;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws Exception {
        String fileName = args[0];

        SimpleDateFormat format = new SimpleDateFormat("dd MM yyyy");


        try (FileReader reader = new FileReader(fileName);
             BufferedReader bufferedReader = new BufferedReader(reader)) {
            while (bufferedReader.ready()) {

                String str = bufferedReader.readLine();
                String name = str.replaceAll("\\\\? \\w+", "");
                String date = str.replaceAll("^\\D+", "");

                PEOPLE.add(new Person(name, format.parse(date)));

            }
        }

    }



}


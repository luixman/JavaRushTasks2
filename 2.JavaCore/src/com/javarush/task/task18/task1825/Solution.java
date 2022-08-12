package com.javarush.task.task18.task1825;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

/* 
Собираем файл
*/

public class Solution {
    public static void main(String[] args) {
        List<String> paths = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String s = scanner.nextLine();
            if (!s.equals("end"))
                paths.add(s);
            else break;
        }

        paths = paths.stream().sorted().collect(Collectors.toList());
        String writeFile = paths.get(0).split(".part")[0];



        try (BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(writeFile))) {
            for (String file : paths) {
                try (BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(file))) {
                    while (inputStream.available()>0) {
                        outputStream.write(inputStream.read());

                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();

        }
    }
}

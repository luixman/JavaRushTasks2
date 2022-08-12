package com.javarush.task.task13.task1326;

import org.w3c.dom.ls.LSOutput;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/* 
Сортировка четных чисел из файла
*/

public class Solution {
    public static void main(String[] args) {
        // напишите тут ваш код
        try (Scanner scanner = new Scanner(System.in);
             BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(scanner.nextLine())))
        ) {
            List<Integer> list = new ArrayList<>();
            while (reader.ready()) {
                list.add(Integer.parseInt(reader.readLine()));
            }

            list.stream().filter(x -> x % 2 == 0).sorted().collect(Collectors.toList()).forEach(System.out::println);

        } catch (Exception e){
            e.printStackTrace();
        }

    }
}

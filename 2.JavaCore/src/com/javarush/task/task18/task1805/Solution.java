package com.javarush.task.task18.task1805;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

/* 
Сортировка байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        Set<Integer> byteList= new TreeSet<>();

        try(Scanner scanner = new Scanner(System.in);
        FileInputStream inputStream= new FileInputStream(scanner.nextLine())){
           while(inputStream.available()>0)
               byteList.add(inputStream.read());
           int f = 123;

        }

     //  List<Integer> sortedByteList = byteList.stream().sorted().collect(Collectors.toList());

        byteList.forEach(x-> System.out.print(x+" "));
    }
}

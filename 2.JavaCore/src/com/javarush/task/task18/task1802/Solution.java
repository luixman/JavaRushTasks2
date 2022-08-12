package com.javarush.task.task18.task1802;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

/* 
Минимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        try (BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
             FileInputStream inputStream = new FileInputStream(console.readLine())) {
            int min = 127;
            while (inputStream.available() > 0) {
                int temp = inputStream.read();
                if (temp < min) {
                    min = temp;
                }

            }
            System.out.println(min);
        }

    }
}

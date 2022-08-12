package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Парсер реквестов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String url = reader.readLine();
        String[] msUrl = url.split("\\?")[1].split("&");

        for (String s : msUrl) {
            String[] param = s.split("=");
            System.out.print(param[0] + " ");
        }
        System.out.println();

        for (String s : msUrl) {
            if (s.startsWith("obj")) {
                String[] objValue = s.split("=");

                if (objValue.length == 2) {
                    try {
                        alert(Double.valueOf(objValue[1]));
                    } catch (NumberFormatException e) {
                        alert(objValue[1]);
                    }

                }
            }
        }

    }


    public static void alert(double value) {
        System.out.println("double: " + value);
    }

    public static void alert(String value) {
        System.out.println("String: " + value);
    }
}

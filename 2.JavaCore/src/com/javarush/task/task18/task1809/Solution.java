package com.javarush.task.task18.task1809;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/* 
Реверс файла
*/

public class Solution {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in);
             FileInputStream inputStream = new FileInputStream(scanner.nextLine());
             FileOutputStream outputStream1 = new FileOutputStream(scanner.nextLine());
             ) {

            List<Integer> list = new ArrayList<>();
            while(inputStream.available()>0){
                list.add(inputStream.read());
            }

            Collections.reverse(list);

            for (int i = 0; i < list.size(); i++) {
                    outputStream1.write(list.get(i));
            }


        }catch (Exception e){

        }

    }
}

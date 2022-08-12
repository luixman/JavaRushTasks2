package com.javarush.task.task18.task1808;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/* 
Разделение файла
*/

public class Solution {
    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in);
             FileInputStream inputStream = new FileInputStream(scanner.nextLine());
             FileOutputStream outputStream1 = new FileOutputStream(scanner.nextLine());
             FileOutputStream outputStream2 = new FileOutputStream(scanner.nextLine())) {

            List<Integer> list = new ArrayList<>();
            while(inputStream.available()>0){
                list.add(inputStream.read());
            }

            //Collections.reverse(list);

            int byteCount = list.size() % 2 == 0 ? list.size() / 2 : list.size() / 2 + 1;


            for (int i = 0; i < list.size(); i++) {
                if (i < (list.size()/2+list.size()%2))
                    //использовал i < byteCount
                    //i <= byteCount
                    //все варинты валидатор отвергает
                    outputStream1.write(list.get(i));
                else
                    outputStream2.write((list.get(i)));

            }


        }catch (Exception e){

        }


    }
}

package com.javarush.task.task18.task1807;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/* 
Подсчет запятых
*/

public class Solution {
    public static void main(String[] args) {
       int sumComma=0;
        try(Scanner scanner = new Scanner(System.in);
        FileInputStream inputStream= new FileInputStream(scanner.nextLine())){

            while (inputStream.available()>0){
                if(inputStream.read()==Character.valueOf(','))
                    sumComma++;
            }


        } catch (Exception e){

        }
        System.out.println(sumComma);

    }
}

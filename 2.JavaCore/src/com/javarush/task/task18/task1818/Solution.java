package com.javarush.task.task18.task1818;

import java.io.*;
import java.util.Scanner;

/* 
Два в одном
*/

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try(
                BufferedWriter writerFile1= new BufferedWriter(new FileWriter(scanner.nextLine()));
                BufferedReader readerFile2 = new BufferedReader(new InputStreamReader(new FileInputStream(scanner.nextLine())));
                BufferedReader readerFile3= new BufferedReader(new InputStreamReader(new FileInputStream(scanner.nextLine())))
                ){

            while(readerFile2.ready()){
                writerFile1.write(readerFile2.readLine());
            }

            while(readerFile3.ready()){
                writerFile1.write(readerFile3.readLine());
            }


        } catch (IOException e){

        }

    }
}

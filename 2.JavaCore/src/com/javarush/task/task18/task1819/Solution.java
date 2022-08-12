package com.javarush.task.task18.task1819;

import java.io.*;
import java.util.Scanner;

/* 
Объединение файлов
*/

public class Solution {
    public static void main(String[] args) {

        Scanner scanner= new Scanner(System.in);
        String file1=scanner.nextLine();
        String file2=scanner.nextLine();

       try(
               BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(file1));
               BufferedInputStream inputStream2 = new BufferedInputStream(new FileInputStream(file2))
       ){
           byte[] buffer=inputStream.readAllBytes();

           BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(file1));
           outputStream.write(inputStream2.readAllBytes());
           outputStream.write(buffer);
           outputStream.close();

       } catch (IOException e){

       }


       /* public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try (FileInputStream fileInputStream1 = new FileInputStream(fileName1);
             FileInputStream fileInputStream2 = new FileInputStream(fileName2)) {

            while (fileInputStream2.available() > 0) {
                byteArrayOutputStream.write(fileInputStream2.read());
            }
            while (fileInputStream1.available() > 0) {
                byteArrayOutputStream.write(fileInputStream1.read());
            }
        }
        try (FileOutputStream fileOutputStream = new FileOutputStream(fileName1)) {
            byteArrayOutputStream.writeTo(fileOutputStream);
        }
    }*/



    }
}

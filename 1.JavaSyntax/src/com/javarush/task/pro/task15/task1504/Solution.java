package com.javarush.task.pro.task15.task1504;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

/* 
Перепутанные байты
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        try(Scanner scanner=new Scanner(System.in);
                    InputStream inputStream = Files.newInputStream(Paths.get(scanner.nextLine()));
        OutputStream outputStream = Files.newOutputStream(Paths.get(scanner.nextLine()));) {





            byte[] buffer=new byte[2];
            while(inputStream.available()>0){
                int counter=inputStream.read(buffer);

                if(counter==2){
                    outputStream.write(buffer[1]);
                    outputStream.write(buffer[0]);
                }
                if(counter==1){
                    outputStream.write(buffer[0]);
                }
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }


    }
}


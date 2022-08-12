package com.javarush.task.task18.task1810;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/* 
DownloadException
*/

public class Solution {
    public static void main(String[] args) throws DownloadException {

        Scanner scanner = new Scanner(System.in);
        while(true){
            try(FileInputStream inputStream = new FileInputStream(scanner.nextLine())){

                if(inputStream.available()<1000)
                    throw new DownloadException();


            } catch (IOException e){

            }
        }

    }

    public static class DownloadException extends Exception {

    }
}

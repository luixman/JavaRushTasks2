package com.javarush.task.task18.task1817;

import java.io.*;

/* 
Пробелы
*/

public class Solution {
    public static void main(String[] args) {

        String path="";

        if(args.length!=0){
            path=args[0];
        }
        int spaces=0;
        int total=0;

        try(BufferedReader reader= new BufferedReader(new InputStreamReader(new FileInputStream(path)))){
           while(reader.ready()){
               char[] s =reader.readLine().toCharArray();
               for (int i = 0; i < s.length; i++) {
                   if(Character.isSpaceChar(s[i])) {
                       spaces++;
                       total++;
                   }

                   else total++;


               }
           }

        }catch (IOException e){

        }

        double result = (double) spaces / total * 100;

        System.out.printf("%.2f",result);


    }
}

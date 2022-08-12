package com.javarush.task.task18.task1820;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* 
Округление чисел
*/

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String file1=scanner.nextLine();
        String file2 =scanner.nextLine();

        try(
                BufferedReader reader=new BufferedReader(new InputStreamReader( new FileInputStream(file1)));
                BufferedWriter writer = new BufferedWriter(new FileWriter(file2))
                ){
            List<Integer> integerNumbers =new ArrayList<>();
            while  (reader.ready()){
               String[] realNumbers  = reader.readLine().split(" ");

                for (int i = 0; i < realNumbers.length; i++) {
                    double temp =Double.parseDouble(realNumbers[i]);
                    integerNumbers.add((int)Math.round(temp));
                }
            }

            for (Integer i : integerNumbers) {
                writer.write(String.valueOf(i)+" ");
            }


        }catch (IOException e){

        }

    }
}

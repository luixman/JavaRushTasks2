package com.javarush.task.task13.task1318;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

/* 
Чтение файла
*/

public class Solution {
    public static void main(String[] args) {
        // напишите тут ваш код
        try(Scanner scanner=new Scanner(System.in);
        FileInputStream input =new FileInputStream(scanner.nextLine())){

            BufferedReader reader=new BufferedReader(new InputStreamReader(input));
            while(reader.ready()){
                System.out.println(reader.readLine());
            }
            reader.close();



        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
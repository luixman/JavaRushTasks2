package com.javarush.task.pro.task15.task1507;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

/* 
Пропускаем не всех
*/

public class Solution {
    public static void main(String[] args)  {
        //напишите тут ваш код
        try(Scanner scanner=new Scanner(System.in);
        ){
            List<String> input=Files.readAllLines(Paths.get(scanner.nextLine()))
            ;
            for (int i = 0; i < input.size(); i++) {
                if(i%2==0){
                    System.out.println(input.get(i));
                }

            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}


package com.javarush.task.pro.task15.task1506;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

/* 
Фейсконтроль
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        try(Scanner scanner=new Scanner(System.in)) {
            List<String> input=Files.readAllLines(Paths.get(scanner.nextLine()));

            for (String str : input) {


                char[] strChar=str.toCharArray();
                for (int i = 0; i < strChar.length; i++) {
                    if(strChar[i]==' '||strChar[i]==',' ||strChar[i]=='.'){
                        continue;
                    }
                    System.out.print(strChar[i]);

                }
                System.out.println(str);

            }

            }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}


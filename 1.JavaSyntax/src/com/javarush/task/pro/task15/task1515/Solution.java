package com.javarush.task.pro.task15.task1515;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

/* 
Абсолютный путь
*/

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        //напишите тут ваш код
        Path path= Paths.get(str);
        if(!path.isAbsolute()){
            System.out.println( path.toAbsolutePath());
        }
        else System.out.println(path);
    }
}


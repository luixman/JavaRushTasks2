package com.javarush.task.pro.task15.task1513;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

/* 
Зри в корень
*/

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        //напишите тут ваш код
        Path path= Paths.get(str);
        System.out.println(path.getRoot());
    }
}

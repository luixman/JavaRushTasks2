package com.javarush.task.pro.task15.task1517;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

/* 
Файловые операции
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        Path filePath = Paths.get(scanner.nextLine());
        Path fileNewPath = Paths.get(scanner.nextLine());
        //напишите тут ваш код
        if(Files.notExists(filePath)){
            Files.createFile(filePath);
        }else if(Files.notExists(fileNewPath)){
            Files.move(filePath,fileNewPath);
        }else if(Files.exists(fileNewPath)){
            Files.delete(filePath);
        }
    }
}


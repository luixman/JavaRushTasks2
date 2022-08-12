package com.javarush.task.pro.task15.task1520;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

/* 
Перемещение файлов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        Path sourceDirectory = Paths.get(scanner.nextLine());
        Path targetDirectory = Paths.get(scanner.nextLine());
        //напишите тут ваш код
        try(DirectoryStream<Path> directoryStream = Files.newDirectoryStream(sourceDirectory)){
            for (Path path : directoryStream) {
                if(Files.isRegularFile(path)){
                    Files.move(path,targetDirectory.resolve(path.getFileName()));

                }
            }
        }catch (Exception e){

        }
    }
}


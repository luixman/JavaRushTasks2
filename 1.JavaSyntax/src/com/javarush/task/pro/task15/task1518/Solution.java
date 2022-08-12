package com.javarush.task.pro.task15.task1518;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

/* 
А что же внутри папки?
*/

public class Solution {

    private static final String THIS_IS_FILE = " - это файл";
    private static final String THIS_IS_DIR = " - это директория";

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        Path directory = Paths.get(scanner.nextLine());
        //напишите тут ваш код
        try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(directory)) {

            for (Path pathStream : directoryStream) {
                if (Files.isDirectory(pathStream)) {
                    System.out.println(pathStream.toString() + THIS_IS_DIR);
                } else if (Files.isRegularFile(pathStream)) {
                    System.out.println(pathStream.toString() + THIS_IS_FILE);
                }
            }

        } catch (Exception e) {

        }

    }
}


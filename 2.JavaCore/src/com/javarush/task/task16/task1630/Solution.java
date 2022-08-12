package com.javarush.task.task16.task1630;

import java.io.*;
import java.nio.file.Paths;
import java.util.Scanner;

/* 
Последовательный вывод файлов
*/

public class Solution {
    public static String firstFileName;
    public static String secondFileName;

    //напишите тут ваш код
    static {
        Scanner scanner=new Scanner(System.in);
        firstFileName=scanner.nextLine();
        secondFileName=scanner.nextLine();
    }

    public static void main(String[] args) throws InterruptedException {
        systemOutPrintln(firstFileName);
        systemOutPrintln(secondFileName);
    }

    public static void systemOutPrintln(String fileName) throws InterruptedException {
        ReadFileInterface f = new ReadFileThread();
        f.setFileName(fileName);
        f.start();
        f.join();
        System.out.println(f.getFileContent());
    }

    public interface ReadFileInterface {

        void setFileName(String fullFileName);

        String getFileContent();

        void join() throws InterruptedException;

        void start();
    }

    //напишите тут ваш код
    public static class ReadFileThread extends Thread implements ReadFileInterface{
        String fullFileName;
        StringBuilder fullString= new StringBuilder();
        @Override
        public void setFileName(String fullFileName) {
            this.fullFileName=fullFileName;
        }

        @Override
        public String getFileContent() {

            return fullString.toString();
        }

        @Override
        public void run() {

            try(BufferedReader reader=new BufferedReader(new FileReader(fullFileName))){
                while(reader.ready()){
                    fullString.append(reader.readLine()+" ");
                }

            }catch (Exception e){

            }
            fullString.deleteCharAt(fullString.lastIndexOf(" "));
        }
    }

}

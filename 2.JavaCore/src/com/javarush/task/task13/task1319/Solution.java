package com.javarush.task.task13.task1319;

import java.io.*;
import java.util.Scanner;

/* 
Писатель в файл с консоли
*/

public class Solution {
    public static void main(String[] args) {
        // напишите тут ваш код
        try (Scanner scanner = new Scanner(System.in);
             FileOutputStream output = new FileOutputStream(scanner.nextLine());
             BufferedWriter writer=new BufferedWriter(new OutputStreamWriter(output));){


            while(true){
                String s= scanner.nextLine();
                if(!s.equalsIgnoreCase("exit")) {
                    writer.write(s+"\n");
                }
                else {
                    writer.write(s+"\n");
                    break;
                }
            }


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

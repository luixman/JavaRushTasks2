package com.javarush.task.task19.task1904;

import java.io.IOException;
import java.util.Date;
import java.util.Scanner;

/* 
И еще один адаптер
*/

public class Solution {

    public static void main(String[] args)  {
        /*PersonScannerAdapter personScannerAdapter = new PersonScannerAdapter(new Scanner(System.in));
        System.out.println(personScannerAdapter.read());*/

    }

    public static class PersonScannerAdapter implements PersonScanner {
       private final Scanner fileScanner;

        public PersonScannerAdapter(Scanner fileScanner) {
            this.fileScanner = fileScanner;
        }

        @Override
        public Person read() throws IOException {
           String[] personData =fileScanner.nextLine().split(" ");

            return new Person(personData[1],personData[2],personData[0],new Date(personData[5]+"/"+personData[4]+"/"+personData[3]));
        }

        @Override
        public void close() throws IOException {
            fileScanner.close();

        }
    }
}

package com.javarush.task.task19.task1915;

import java.io.*;

/* 
Дублируем текст
*/

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) throws IOException {
        String outputFileName;

        try (BufferedReader console = new BufferedReader(new InputStreamReader(System.in))) {
            outputFileName = console.readLine();
        }

        PrintStream defaultPrintStream = System.out;

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(outputStream);
        System.setOut(stream);

        testString.printSomething();
        System.setOut(defaultPrintStream);

        //тута
        try(FileOutputStream write= new FileOutputStream(outputFileName)){
            for (byte b : outputStream.toByteArray()) {
                write.write(b);
            }
        }


        System.out.println(outputStream.toString());

    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}


package com.javarush.task.task19.task1914;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/* 
Решаем пример
*/

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream defaultPrintStream = System.out;

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(outputStream);
        System.setOut(stream);

        testString.printSomething();
        System.setOut(defaultPrintStream);

        String operation =outputStream.toString().replaceAll("(\\d*\\s)|(=)","");
        String[] digit = outputStream.toString().split("(\\D*\\s)|(=)");

        int result=0;

        switch (operation){
            case"+":
                result=Integer.parseInt(digit[0])+Integer.parseInt(digit[1]);
                break;
            case"-":
                result=Integer.parseInt(digit[0])-Integer.parseInt(digit[1]);
                break;
            case"*":
                result=Integer.parseInt(digit[0])*Integer.parseInt(digit[1]);
                break;
        }
        System.out.print(outputStream.toString()+result);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}


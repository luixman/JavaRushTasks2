package com.javarush.task.pro.task09.task0908;

import java.util.regex.Pattern;

/* 
Двоично-шестнадцатеричный конвертер
*/

public class Solution {
    private static final String HEX = "0123456789abcdef";

    private static final String[] BINARY = {"0000", "0001", "0010", "0011",
            "0100", "0101", "0110", "0111",
            "1000", "1001", "1010", "1011",
            "1100", "1101", "1110", "1111"};

    public static void main(String[] args) {
         String binaryNumber = "100111010000";
        //String binaryNumber = "13";
        System.out.println("Двоичное число " + binaryNumber + " равно шестнадцатеричному числу " + toHex(binaryNumber));
        String hexNumber = "19d0";
        System.out.println("Шестнадцатеричное число " + hexNumber + " равно двоичному числу " + toBinary(hexNumber));
    }

    public static String toHex(String binaryNumber) {
        //напишите тут ваш код
        String hexNumber = "";

        if (binaryNumber == null || binaryNumber.isEmpty()) {
            return hexNumber;
        }

        while (binaryNumber.length() % 4 != 0) {
            binaryNumber = "0" + binaryNumber;
        }

        //создаем char массив
        char[] charBinaryNumber = binaryNumber.toCharArray();

        //проверка массива на посторонние символы
        for (int i = 0; i < charBinaryNumber.length; i++) {
            if (charBinaryNumber[i] != '1' & charBinaryNumber[i] != '0') {
                return "";
            }
        }

        for (int i = 0; i < charBinaryNumber.length; i = i + 4) {
            String hexSymbol = "";
            hexSymbol = "" + charBinaryNumber[i] + charBinaryNumber[i + 1] + charBinaryNumber[i + 2] + charBinaryNumber[i + 3];

            for (int j = 0; j < BINARY.length; j++) {
                if (BINARY[j].equals(hexSymbol)) {
                    hexNumber += HEX.charAt(j);
                    break;
                }
            }
        }
        return hexNumber;
    }

    public static String toBinary(String hexNumber) {
        //напишите тут ваш код
        String binaryNumber = "";

        if (hexNumber == null || hexNumber.isEmpty()) {
            return binaryNumber;
        }

        //добавить проверку на 16чные символы, выводить пустую строку
        for (int i = 0; i < hexNumber.length(); i++) {
            int trigger = 0;
            for (int j = 0; j < HEX.length(); j++) {
                if (hexNumber.charAt(i) != HEX.charAt(j)) {
                    trigger++;


                }
            }
            if (trigger == 16) {
                return "";
            }
        }

        for (int i = 0; i < hexNumber.length(); i++) {
            for (int j = 0; j < HEX.length(); j++) {
                if (hexNumber.charAt(i) == HEX.charAt(j)) {
                    binaryNumber += BINARY[j];
                }
            }
        }

        return binaryNumber;
    }
}







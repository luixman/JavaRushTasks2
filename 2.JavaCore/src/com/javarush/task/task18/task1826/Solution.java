package com.javarush.task.task18.task1826;

import java.io.*;

/* 
Шифровка
*/

public class Solution {
    public static void main(String[] args) {

        switch (args[0]){
            case"-e":
                encrypt(args);
                break;
            case"-d":
                decrypt(args);
                break;

        }

    }

    public static void encrypt(String[] args){
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(args[1])));
        Writer writer = new FileWriter(args[2])) {

            while(reader.ready()){
               char[] buffer = reader.readLine().toCharArray();

                for (int i = 0; i < buffer.length; i++) {
                    writer.write(buffer[i]+(7*i));
                }
                writer.write("\n");

            }

        } catch (Exception e){

        }


    }

    public static void decrypt(String[] args){

        try(BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(args[1])));
            Writer writer = new FileWriter(args[2])) {

            while(reader.ready()){
                char[] buffer = reader.readLine().toCharArray();

                for (int i = 0; i < buffer.length; i++) {
                    writer.write(buffer[i]-(7*i));
                }
                writer.write("\n");

            }

        } catch (Exception e){

        }
    }

}

package com.javarush.task.task18.task1804;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/* 
Самые редкие байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        Map<Integer,Integer> maxByte= new HashMap<>();
        int minElem=127;

        try(Scanner scanner= new Scanner(System.in);
            FileInputStream inputStream = new FileInputStream(scanner.nextLine())){
            while(inputStream.available()>0){
                int temp=inputStream.read();
                if(maxByte.containsKey(temp)){
                    int size=maxByte.get(temp)+1;
                    maxByte.put(temp,size);
                } else
                    maxByte.put(temp,1);
            }
        }

        for (int temp :maxByte.values()) {
            if(temp<minElem){
                minElem=temp;
            }

        }

        for (int key:
                maxByte.keySet()) {
            if(maxByte.get(key)==minElem){
                System.out.print(key+" ");
            }


        }
    }
}

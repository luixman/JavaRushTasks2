package com.javarush.task.task18.task1823;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str;
        List<Thread> threadList = new ArrayList<>();
        while (true) {
            str = scanner.nextLine();
            if (str.equals("exit"))
                break;
            else threadList.add(new ReadThread(str));
        }
        threadList.forEach(Thread::start);
    }

    public static class ReadThread extends Thread {
        public ReadThread(String fileName) {
            //implement constructor body
            super(fileName);
        }
        // implement file reading here - реализуйте чтение из файла тут
        @Override
        public void run() {
           try( FileInputStream inputStream = new FileInputStream(this.getName())){
               Map<Integer,Integer> numberOfByte = new HashMap<>();
               while(inputStream.available()>0){
                   int valueByte = inputStream.read();
                   if(!numberOfByte.containsKey(valueByte))
                       numberOfByte.put(valueByte,1);
                   else
                       numberOfByte.compute(valueByte,(k,v)->v+=1);
               }
               int max = numberOfByte.values().stream().max((x1, x2) -> x1 - x2).get();

               for (Map.Entry<Integer,Integer> pair:
                    numberOfByte.entrySet()) {
                   if(pair.getValue()==max){
                       resultMap.put(this.getName(),pair.getKey());
                       break;
                   }
               }
           }catch (IOException e){
               e.printStackTrace();
           }
        }
    }
}

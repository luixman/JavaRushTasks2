package com.javarush.task.task19.task1920;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

/* 
Самый богатый
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        String fileName = args[0];
        Map<String,Double> amountOfSalaries = new TreeMap<>();

        try(FileReader reader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(reader)){
            while(bufferedReader.ready()){

                String[] str =bufferedReader.readLine().split(" ");
                double sum=0;

                for (int i = 1; i < str.length; i++) {
                    sum+=Double.parseDouble(str[i]);
                }

                if(amountOfSalaries.containsKey(str[0])) {
                    double finalSum = sum;
                    amountOfSalaries.compute(str[0],(k, v)->v+= finalSum);
                } else {
                    amountOfSalaries.put(str[0],sum);
                }
            }
        }

       Double max = amountOfSalaries.values().stream().max(Double::compare).get();
        for (Map.Entry<String,Double> s: amountOfSalaries.entrySet()) {
            if(s.getValue().equals(max))
                System.out.println(s.getKey());

        }
    }
}

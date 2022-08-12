package com.javarush.task.task22.task2209;

import java.io.*;
import java.util.*;

/*
Составить цепочку слов
*/

public class Solution {
    public static void main(String[] args) {
        //...
        Scanner console = new Scanner(System.in);
        String fileName = console.nextLine();
        List<String> words = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            while (reader.ready()) {
                words.addAll(Arrays.asList(reader.readLine().split(" ")));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        String[] arrayWords = new String[words.size()];
        for (int i = 0; i < arrayWords.length; i++) {
            arrayWords[i] = words.get(i);
        }

        StringBuilder result = getLine(arrayWords);
        System.out.println(result.toString());
    }

    public static boolean isVerify(List<String> word){
        for (int i = 1; i < word.size(); i++) {
            char[] word1 =word.get(i-1).toCharArray();
            char[] word2 = word.get(i).toCharArray();
            if(Character.toUpperCase(word1[word1.length-1])!=word2[0])
                return false;
        }
        return true;
    }
    public static StringBuilder getLine(String... words) {

        List<String> word= new ArrayList<>();
        word.addAll(Arrays.asList(words));


        while(true){
            if(isVerify(word)){
                StringBuilder sb = new StringBuilder();
                for (String s :word) {
                    sb.append(s).append(" ");
                }
                sb.deleteCharAt(sb.length()-1);
                return sb;
            }
            else
               Collections.shuffle(word);


        }


       /* StringBuilder sb = new StringBuilder();
        List<Integer> position = new ArrayList<>();

        for (int i = 0; i < words.length; i++) {
            position.add(i);
            if(findSolutions(position,words)){
                for (Integer integer :
                        position) {
                    sb.append(words[integer]).append(" ");
                }
                return sb;
            }
            position.remove(Integer.valueOf(i));
        }

        return sb;*/
    }



    public static boolean findSolutions(List<Integer> list, String... words){
        if(list.size() == words.length)
            return true;

        for (int i = 0; i < words.length; i++) {
            if(isTrue(list,words[i],words)){
                list.add(i);
                if(findSolutions(list,words)){
                    return true;
                }
                list.remove(Integer.valueOf(i));
            }
        }
        return false;
    }

    public static  boolean isTrue(List<Integer> list, String word, String... words){
        for (Integer i :
                list) {
            if (words[i].equals(word))
                return false;
        }
        return isChars(words[list.get(list.size()-1)], word);
    }



    public static boolean isChars(String first, String second){
        if(first.endsWith(" ")){
            first = first.substring(0,first.length()-1);
        }
        return first.isEmpty() || (second!=null
                && Character.toUpperCase(first.charAt(first.length()-1)) ==Character.toUpperCase(second.charAt(0)));
    }
}

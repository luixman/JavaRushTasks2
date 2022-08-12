package com.javarush.task.task22.task2207;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/* 
Обращенные слова
*/

public class Solution {
    //
    // снизу мой код, который также правильно работает
    //
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) throws Exception {
        List<String> words = new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fileReader = new BufferedReader(new FileReader(bufferedReader.readLine()));
        bufferedReader.close();
        while (fileReader.ready()) {
            words.addAll(Arrays.asList(fileReader.readLine().split(" ")));
        }
        fileReader.close();

        for (int i = 0; i < words.size(); i++) {
            for (int j = 0; j < words.size(); ) {
                if (i >= words.size()) {
                    break;
                }
                if (words.get(j).equals(new StringBuilder(words.get(i)).reverse().toString()) && j != i) {
                    Pair pair = new Pair();
                    pair.first = words.get(j);
                    pair.second = words.get(i);
                    result.add(pair);
                    words.remove(j);
                    words.remove(i);
                    j = 0;
                } else
                    j++;
            }
        }
    }

    public static class Pair {
        String first;
        String second;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (first != null ? !first.equals(pair.first) : pair.first != null) return false;
            return second != null ? second.equals(pair.second) : pair.second == null;

        }

        @Override
        public int hashCode() {
            int result = first != null ? first.hashCode() : 0;
            result = 31 * result + (second != null ? second.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return first == null && second == null ? "" :
                    first == null ? second :
                            second == null ? first :
                                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}

/*
* public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        StringBuilder file = new StringBuilder();
        try(BufferedReader reader = new BufferedReader( new FileReader(console.nextLine()))){

            while(reader.ready()){
                file.append(reader.readLine()).append(" ");
            }

        }catch (IOException e){

        }
       String[] s = file.toString().split(" ");
        for (int i = 0; i < s.length-1; i++) {
            if(s[i].equals(ReverseString(s[i+1])) || s[i+1].equals(ReverseString(s[i]))){
        Pair pair = new Pair();
        pair.first =s[i];
        pair.second=s[i+1];
        result.add(pair);
        i++;
        }

        }
        result.forEach(System.out::println);

        }
public static String ReverseString(String s){
        return new StringBuilder(s).reverse().toString();
        }

public static class Pair {
    String first;
    String second;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Solution.Pair pair = (Solution.Pair) o;

        if (first != null ? !first.equals(pair.first) : pair.first != null) return false;
        return second != null ? second.equals(pair.second) : pair.second == null;

    }

    @Override
    public int hashCode() {
        int result = first != null ? first.hashCode() : 0;
        result = 31 * result + (second != null ? second.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return first == null && second == null ? "" :
                first == null ? second :
                        second == null ? first :
                                first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

    }
}

}

        *
*
* */

package com.javarush.task.task19.task1916;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws Exception {
        String file1;
        String file2;

        try(BufferedReader console = new BufferedReader(new InputStreamReader(System.in))){
            file1=console.readLine();
            file2=console.readLine();
        }

        List<String> oldFile = new ArrayList<>();
        List<String> newFile = new ArrayList<>();

        try(
                BufferedReader readFile1 = new BufferedReader(new FileReader(file1));
                BufferedReader readFile2 = new BufferedReader(new FileReader(file2));
        ){
            while(readFile1.ready()){
                oldFile.add(readFile1.readLine());
            }
            while(readFile2.ready()){
                newFile.add(readFile2.readLine());
            }
        }




        while(newFile.size()!=0 && oldFile.size()!=0) {

               int i = 0;
               if (oldFile.get(i).equals(newFile.get(i))) {
                   lines.add(new LineItem(Type.SAME, oldFile.get(i)));
                   oldFile.remove(0);
                   newFile.remove(0);
               } else if (oldFile.get(i + 1).equals(newFile.get(i))) {
                   lines.add(new LineItem(Type.REMOVED, oldFile.get(i)));
                   oldFile.remove(0);
               } else if (oldFile.get(i).equals(newFile.get(i + 1))) {
                   lines.add(new LineItem(Type.ADDED, newFile.get(i)));
                   newFile.remove(0);
               }
        }

        while(newFile.size()!=0){
            lines.add(new LineItem(Type.ADDED,newFile.get(0)));
            newFile.remove(0);
        }

        while(oldFile.size()!=0){
            lines.add((new LineItem(Type.REMOVED,oldFile.get(0))));
            oldFile.remove(0);
        }


        lines.forEach(x-> System.out.println(x.type+" "+x.line));



    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}

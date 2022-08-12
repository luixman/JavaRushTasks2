package com.javarush.task.task17.task1721;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) {
        try(Scanner scanner=new Scanner(System.in)){
            allLines=Files.readAllLines(Paths.get(scanner.nextLine()));
            forRemoveLines=Files.readAllLines(Paths.get(scanner.nextLine()));

            try{
                new Solution().joinData();
            } catch (CorruptedDataException e){
               // allLines.clear();
               // forRemoveLines.clear();
            }

        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void joinData() throws CorruptedDataException {


        if (allLines.containsAll(forRemoveLines))
            allLines.removeAll(forRemoveLines);
        else {
            allLines.clear();
            throw new CorruptedDataException();
        }

    }
}

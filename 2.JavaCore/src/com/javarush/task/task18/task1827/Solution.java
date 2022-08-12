package com.javarush.task.task18.task1827;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* 
Прайсы
*/

public class Solution {

    public static class Price{
       private int id;
       private String name;
       private String price;
       private String quantity;

        public Price(int id, String name, String price, String quantity) {
            this.id = id;
            this.name = name;
            this.price = price;
            this.quantity = quantity;
        }

        @Override
        public String toString() {
            return String.format("%-8d%-30s%-8s%-4s",id,name,price,quantity);
        }
    }


    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String fileDir=scanner.nextLine();

       if(args.length==4) {
           Price newPrice = new Price(getNewId(fileDir), args[1], args[2], args[3]);

           if (args[0].equals("-c")) {
               FileWriter writer = new FileWriter(fileDir, true);
               writer.append("\n");
               writer.append(newPrice.toString());
               writer.close();
           }
       }

    }



    /*public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String fileDir=scanner.nextLine();


        if (args[0].equals("-c")) {
            FileWriter writer = new FileWriter(fileDir, true);
            writer.append("\n");
            writer.append(getNewId(fileDir));

            while(args[1].length()!=30){
                args[1]=args[1]+" ";
            }
            writer.append(args[1]);

            while(args[2].length()!=8){
                args[2]=args[2]+" ";
            }
            writer.append(args[2]);

            while(args[3].length()!=4){
                args[3]=args[3]+" ";
            }
            writer.append(args[3]);
            writer.close();



        }
    }*/

    public static int getNewId(String fileDir) throws IOException {
        int max = 0;
        int increment=0;
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileDir)));

        while (reader.ready()) {
            String id = reader.readLine().substring(0, 8);
            if (Integer.parseInt(id.trim()) > max) {
                max = Integer.parseInt(id.trim());
            }

        }

        increment=max+1;
        reader.close();

        return increment;

        /*StringBuilder returnId = new StringBuilder(String.valueOf(increment));

        while (returnId.length()!=8){
            returnId.append(" ");
        }



        return returnId.toString();*/



    }
}

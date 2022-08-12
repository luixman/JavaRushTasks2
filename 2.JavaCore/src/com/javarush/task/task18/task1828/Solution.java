package com.javarush.task.task18.task1828;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* 
Прайсы 2
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

        public static Price getProductFromString(String s){
            int id =Integer.parseInt(s.substring(0,8).trim());
            String name = s.substring(8,38).trim();
            String price = s.substring(38,46).trim();
            String quantity = s.substring(46,50).trim();

            return new Price(id,name,price,quantity);
        }


        @Override
        public String toString() {
            return String.format("%-8d%-30s%-8s%-4s",id,name,price,quantity);
        }
    }
    public static void main(String[] args) throws Exception  {
        Scanner scanner = new Scanner(System.in);
        String fileDir = scanner.nextLine();

        List <Price> priceList;
        priceList=fillPriceList(fileDir);

        if(args.length!=0){
            int id =Integer.parseInt(args[1]);
            switch (args[0]){
                case"-u":

                    for (Price price:priceList){
                          if (price.id==id){
                              price.name=args[2];
                              price.price=args[3];
                              price.quantity=args[4];

                              writeListToDisk(priceList,fileDir);
                          }
                        }

                    break;
                case "-d":
                    for (Price price : priceList) {
                        if (price.id == id) {
                            priceList.remove(price);
                            writeListToDisk(priceList,fileDir);
                        }
                    }

                    break;

            }
        }

    }

    private static void writeListToDisk (List<Price> priceList,String fileDir) throws Exception{
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileDir));

        for (Price p : priceList) {
            writer.write(p.toString()+"\n");
        }
        writer.close();

    }

    private static List<Price> fillPriceList(String fileDir) throws IOException{
        List <Price> priceList= new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileDir)));

        while (reader.ready()){
            priceList.add(Price.getProductFromString(reader.readLine()));
        }
        reader.close();


        return priceList;
    }
}

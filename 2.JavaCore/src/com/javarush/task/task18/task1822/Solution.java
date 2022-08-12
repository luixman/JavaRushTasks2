package com.javarush.task.task18.task1822;

import java.io.*;
import java.util.Scanner;

/* 
Поиск данных внутри файла
*/

public class Solution {
    public static class Product {
        private int id;
        private String productName;
        private double price;
        private int quantity;

        public int getId() {
            return id;
        }

        public Product(int id, String productName, double price, int quantity) {
            this.id = id;
            this.productName = productName;
            this.price = price;
            this.quantity = quantity;
        }

        public static Product getNewProduct(String field) {
            String[] fields = field.split(" ");

            int id = Integer.parseInt(fields[0]);
            StringBuilder productName = new StringBuilder();
            for (int i = 1; i < fields.length - 2; i++) {
                productName.append(fields[i] + " ");
            }
            productName.deleteCharAt(productName.length() - 1);
            double price = Double.parseDouble(fields[fields.length - 2]);
            int quantity = Integer.parseInt(fields[fields.length - 1]);


            return new Product(id, productName.toString(), price, quantity);
        }

        @Override
        public String toString() {
            return String.format("%d %s %.1f %d", id, productName, price, quantity);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner((System.in));
        int id = Integer.parseInt(args[0]);

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(scanner.nextLine())))) {

            while (reader.ready()) {
                Product product = Product.getNewProduct(reader.readLine());
                if (product.getId() == id) {
                    System.out.println(product.toString());
                    break;

                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


        /* BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String str;
        try (BufferedReader bufferedFileReader = new BufferedReader(new FileReader(reader.readLine()))) {
            while ((str = bufferedFileReader.readLine()) != null) {
                if (str.startsWith(args[0] + " ")) {
                    System.out.println(str);
                    break;
                }
            }
        }*/
    }
}

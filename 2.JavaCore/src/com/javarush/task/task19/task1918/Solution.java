package com.javarush.task.task19.task1918;

import org.jsoup.*;
import org.jsoup.nodes.Document;
import org.jsoup.parser.Parser;
import org.jsoup.select.Elements;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;


/* 
Знакомство с тегами
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        String fileName;
        try (BufferedReader console = new BufferedReader(new InputStreamReader(System.in))) {
            fileName = console.readLine();
        }
        String tag = args[0];

        StringBuilder lines = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            while (reader.ready()) {
                lines.append(reader.readLine());
            }

        }
        Document document=Jsoup.parse(lines.toString(),"",Parser.xmlParser());
        Elements elements=document.getElementsByTag(tag);
        elements.forEach(System.out::println);

    }
}

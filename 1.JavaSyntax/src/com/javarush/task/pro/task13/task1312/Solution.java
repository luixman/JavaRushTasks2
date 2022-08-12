package com.javarush.task.pro.task13.task1312;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

/* 
ArrayList vs HashMap
*/

public class Solution {

    public static void main(String[] args) {
        System.out.println(getProgrammingLanguages());
    }

    public static HashMap<Integer,String> getProgrammingLanguages() {
        //напишите тут ваш код
        HashMap<Integer,String> programmingLanguages =new HashMap<>();
        int i=0;
        programmingLanguages.put(i++,"Java");
        programmingLanguages.put(i++,"Kotlin");
        programmingLanguages.put(i++,"Go");
        programmingLanguages.put(i++,"Javascript");
        programmingLanguages.put(i++,"Typescript");
        programmingLanguages.put(i++,"Python");
        programmingLanguages.put(i++,"PHP");
        programmingLanguages.put(i++,"C++");
        return programmingLanguages;
    }

}

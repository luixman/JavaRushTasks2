package com.javarush.task.pro.task13.task1309;

import java.util.HashMap;

/* 
Успеваемость студентов
*/

public class Solution {
    public static HashMap<String, Double> grades = new HashMap<>();

    public static void main(String[] args) {
        addStudents();
        System.out.println(grades);
    }

    public static void addStudents() {
        //напишите тут ваш код
        grades.put("ayaya",3.5);
        grades.put("aho",(double)3);
        grades.put("ayayha",3.5);
        grades.put("ajyaya",3.5);
        grades.put("ayalya",3.5);

    }
}

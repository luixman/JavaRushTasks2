package com.javarush.task.pro.task12.task1212;

/* 
Создаем свой список
*/

import java.util.Arrays;

public class CustomStringArrayList {

    private int size;
    private int capacity;
    private String[] elements;

    public CustomStringArrayList() {
        capacity = 10;
        size = 0;
        elements = new String[capacity];
    }

    public void add(String element) {
        if (size == capacity) {
            grow();
        }
        elements[size] = element;
        size++;
    }

    private void grow() {
        //напишите тут ваш код
        capacity=this.elements.length+this.elements.length/2;
        String[] elements = new String[capacity];

        for (int i = 0; i < this.elements.length; i++) {
            elements[i]=this.elements[i];
        }

        this.elements=elements;
        System.out.println(123);

        /*capacity=this.elements.length+this.elements.length/2;
        String[] elements = Arrays.copyOf(this.elements,capacity);
        this.elements=elements;*/
    }

}

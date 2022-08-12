package com.javarush.task.pro.task10.task1012;

import java.util.Arrays;
import java.util.Objects;

/* 
Дефрагментация памяти
*/

public class Memory {

    public static void main(String[] args) {
        String[] memory = {"object15", null, null, "object2", null, null, null, "object32", null, "object4"};
        String[] memory2 = { null,"object15", null, "object2", null, null, null, "object32", "object4",null};
        executeDefragmentation(memory);
        executeDefragmentation(memory2);
        System.out.println(Arrays.toString(memory));
        System.out.println(Arrays.toString(memory2));

    }

    public static void executeDefragmentation(String[] array) {
        //напишите тут ваш код
        int temp=0;
        String stringTemp;
        for (int i = 0; i < array.length;i++ ) {

            if(array[i]!=null){
                stringTemp=array[temp];
                array[temp]=array[i];
                temp++;
                if(i!=0){
                    array[i]=stringTemp;
                }

            }


        }



    }
}

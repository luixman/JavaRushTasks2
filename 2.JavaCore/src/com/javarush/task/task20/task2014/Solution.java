package com.javarush.task.task20.task2014;

import java.io.*;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;

/* 
Serializable Solution
*/

public class Solution  implements Serializable  {
    public static void main(String[] args) {
        //System.out.println(new Solution(4));
        String fileName = "D:\\123.log";

       try(ObjectOutput output = new ObjectOutputStream(new FileOutputStream(fileName))) {

           Solution savedObject = new Solution(8);
           output.writeObject(savedObject);
           output.flush();
           ObjectInput input = new ObjectInputStream(new FileInputStream(fileName));
           Solution loadedObject = (Solution) input.readObject();
           input.close();
           if(savedObject.string.equals(loadedObject.string))
               System.out.println("YEP");
       } catch (Exception e) {
           System.out.println("БЯДА");
       }

    }

    transient private final String pattern = "dd MMMM yyyy, EEEE";
    transient private Date currentDate;
    transient private int temperature;
    String string;

    public Solution(int temperature) {
        this.currentDate = new Date();
        this.temperature = temperature;

        string = "Today is %s, and the current temperature is %s C";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        this.string = String.format(string, format.format(currentDate), temperature);
    }

    @Override
    public String toString() {
        return this.string;
    }
}

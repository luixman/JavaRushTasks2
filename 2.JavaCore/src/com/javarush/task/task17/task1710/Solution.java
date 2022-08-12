package com.javarush.task.task17.task1710;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    public static SimpleDateFormat formatStart= new SimpleDateFormat("dd/MM/yyyy",Locale.ENGLISH);
    public static SimpleDateFormat format= new SimpleDateFormat("dd-MMM-yyyy",Locale.ENGLISH);

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        if(args.length!=0){
            switch (args[0]){
                case"-c":

                    Date birthdayDate=formatStart.parse(args[3]);
                    if(args[2].equals("м"))
                        allPeople.add(Person.createMale(args[1],birthdayDate));
                    else if(args[2].equals("ж"))
                        allPeople.add(Person.createFemale(args[1],birthdayDate));
                    System.out.println(allPeople.size()-1);
                    break;

                case"-r":
                    System.out.print(allPeople.get(Integer.parseInt(args[1])).getName() + " ");

                    if(allPeople.get(Integer.parseInt(args[1])).getSex()==Sex.MALE)
                        System.out.print("м"+" ");
                    else if(allPeople.get(Integer.parseInt(args[1])).getSex()==Sex.FEMALE)
                        System.out.print("ж"+" ");

                    System.out.println(format.format(allPeople.get(Integer.parseInt(args[1])).getBirthDate()));


                    break;
                case"-u":
                    allPeople.get(Integer.parseInt(args[1])).setName(args[2]);

                    if(args[3].equals("м"))
                        allPeople.get(Integer.parseInt(args[1])).setSex(Sex.MALE);
                    else if(args[3].equals("ж"))
                        allPeople.get(Integer.parseInt(args[1])).setSex(Sex.FEMALE);

                    allPeople.get(Integer.parseInt(args[1])).setBirthDate(formatStart.parse(args[4]));
                    break;

                case"-d":
                    allPeople.get(Integer.parseInt(args[1])).setName(null);
                    allPeople.get(Integer.parseInt(args[1])).setBirthDate(null);
                    allPeople.get(Integer.parseInt(args[1])).setSex(null);

                    break;
            }
        }
      //  allPeople.forEach(System.out::println);
      //  System.out.println(allPeople.get(0).getSex());
    }
}

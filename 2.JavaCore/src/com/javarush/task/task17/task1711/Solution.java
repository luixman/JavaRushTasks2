package com.javarush.task.task17.task1711;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    public static SimpleDateFormat dateStart = new SimpleDateFormat("dd/MM/yyyy");
    public static SimpleDateFormat datePrint = new SimpleDateFormat("dd-MMM-yyyy");

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws Exception {
        //start here - начни тут
        if (args.length != 0) {
            switch (args[0]) {
                case "-c":
                    synchronized (allPeople) {
                        for (int i = 1; i < args.length; i += 3) {
                            if (args[i + 1].equals("м"))
                                allPeople.add(Person.createMale(args[i], dateStart.parse(args[i + 2])));
                            else if (args[i + 1].equals("ж"))
                                allPeople.add(Person.createFemale(args[i], dateStart.parse(args[i + 2])));
                            System.out.println(allPeople.size() - 1);

                        }
                    }

                    break;
                case "-u":
                    synchronized (allPeople) {
                        for (int i = 1; i < args.length; i += 4) {
                            allPeople.get(Integer.parseInt(args[i])).setName(args[i + 1]);
                            if (args[i + 2].equals("м"))
                                allPeople.get(Integer.parseInt(args[i])).setSex(Sex.MALE);
                            else if (args[i + 2].equals("ж"))
                                allPeople.get(Integer.parseInt(args[i])).setSex(Sex.FEMALE);

                            allPeople.get(Integer.parseInt(args[i])).setBirthDate(dateStart.parse(args[i + 3]));
                        }


                    }

                    break;
                case "-d":
                    synchronized (allPeople) {
                        for (int i = 1; i < args.length; i++) {
                            allPeople.get(Integer.parseInt(args[i])).setName(null);
                            allPeople.get(Integer.parseInt(args[i])).setBirthDate(null);
                            allPeople.get(Integer.parseInt(args[i])).setSex(null);

                        }
                    }

                    break;
                case "-i":
                    synchronized (allPeople) {
                        for (int i = 1; i < args.length; i++) {
                            String name = allPeople.get(Integer.parseInt(args[i])).getName();
                            Sex sex = allPeople.get(Integer.parseInt(args[i])).getSex();
                            Date date = allPeople.get(Integer.parseInt(args[i])).getBirthDate();

                            System.out.println(name + " " + (sex.equals(Sex.MALE) ? "м" : "ж") + " " + datePrint.format(date));
                        }

                    }

                    break;
            }
        }
    }
}

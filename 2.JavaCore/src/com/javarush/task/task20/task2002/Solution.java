package com.javarush.task.task20.task2002;

import java.io.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/* 
Читаем и пишем в файл: JavaRush
*/

public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or adjust outputStream/inputStream according to your file's actual location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File yourFile = File.createTempFile("123123.log", null);
            OutputStream outputStream = new FileOutputStream(yourFile);
            InputStream inputStream = new FileInputStream(yourFile);

            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            User user = new User();
            user.setFirstName("Aleha");
            user.setLastName("SHilo");
            user.setBirthDate(new Date(1998, Calendar.JANUARY,29));
            user.setMale(true);
            user.setCountry(User.Country.RUSSIA);
            javaRush.users.add(user);

            User user2 = new User();
            user2.setFirstName("Aleha");
            user2.setLastName("SHilo");
            user2.setBirthDate(new Date(1998, Calendar.JANUARY,29));
            user2.setMale(true);
            user2.setCountry(User.Country.RUSSIA);
            javaRush.users.add(user2);
            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //here check that the javaRush object is equal to the loadedObject object - проверьте тут, что javaRush и loadedObject равны
            if(javaRush.equals(loadedObject))
                System.out.println("YEP");

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with the save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            if (!users.isEmpty()) {
                for (User user : users) {
                    outputStream.write((user.getFirstName() + "\n").getBytes());
                    outputStream.write((user.getLastName() + "\n").getBytes());
                    outputStream.write((user.getBirthDate().getTime() + "\n").getBytes());
                    outputStream.write((user.isMale() + "\n").getBytes());
                    outputStream.write((user.getCountry().name() + "\n").getBytes());
                }
                // outputStream.write((".\n").getBytes());
            }

        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
           // String str = reader.readLine();

            while (reader.ready()) {
                User user = new User();
                user.setFirstName(reader.readLine());
                user.setLastName(reader.readLine());
                Date date= new Date(Long.parseLong(reader.readLine()));
                user.setBirthDate(date);

                if(reader.readLine().equals("true")){
                    user.setMale(true);
                }

                String country = reader.readLine();
                switch (country) {
                    case "UKRAINE":
                        user.setCountry(User.Country.UKRAINE);
                        break;
                    case "RUSSIA":
                        user.setCountry(User.Country.RUSSIA);
                        break;
                    case "OTHER":
                        user.setCountry(User.Country.OTHER);
                        break;
                }
                users.add(user);

            }

        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return users != null ? users.equals(javaRush.users) : javaRush.users == null;

        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }
}

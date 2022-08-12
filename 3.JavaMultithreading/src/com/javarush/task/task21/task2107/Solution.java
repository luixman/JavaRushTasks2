package com.javarush.task.task21.task2107;

import javax.sound.midi.Soundbank;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

/* 
Глубокое клонирование карты
*/

public class Solution implements Cloneable {

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.users.put("Hubert", new User(172, "Hubert"));
        solution.users.put("Zapp", new User(41, "Zapp"));
        Solution clone = null;
        try {
            clone = (Solution) solution.clone();
            System.out.println(solution);
            System.out.println(clone);

            System.out.println(solution.users);
            System.out.println(clone.users);

        } catch (CloneNotSupportedException e) {
            e.printStackTrace(System.err);
        }
    }

   @Override
    public Object clone() throws CloneNotSupportedException{
        Solution clone  = (Solution) super.clone();
        Map<String,User> newUsers = new LinkedHashMap<>();

       for (Map.Entry<String,User> o:
            users.entrySet()) {
           newUsers.put(o.getKey(),(User)o.getValue().clone());

       }
       clone.users=newUsers;
       return clone;

    }

    protected Map<String, User> users = new LinkedHashMap();

    public static class User implements Cloneable {
        int age;
        String name;

        public User(int age, String name) {
            this.age = age;
            this.name = name;
        }



        @Override
        public Object clone() throws CloneNotSupportedException{
           User user = new User(this.age,this.name.toString());
            return  user;
        }

        @Override
        public boolean equals(Object o){
            if(o == this)
                return true;
            if(!(o instanceof User))
                return false;
            User user =(User) o;
            return (age== user.age) && Objects.equals(name,user.name);

        }

        public int hashCode(){
            int result = age;
            result=result*31 +(name!=null?name.hashCode():0);
            return result;
        }


    }
}

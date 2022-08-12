package vectorAndrey;

import java.util.Vector;

public class Solution {

    public static Vector<A>  vector= new Vector<>();
    public static String s = " test %I32d test continue {%I64s}";
    public static String newS ;



    public static String argument1="%I32d";
    public static String argument2="%I64s";



    public static void main(String[] args) {
        vector.add(new A(5,6));

        System.out.println("123.tt".lastIndexOf(".txt"));


        if(s.contains(argument1))
          newS=  s.replace(argument1,String.valueOf(vector.get(0).getA()));

        if(s.contains(argument2))
          newS=  newS.replace(argument2,String.valueOf(vector.get(0).getB()));


        System.out.println(newS);



    }

}



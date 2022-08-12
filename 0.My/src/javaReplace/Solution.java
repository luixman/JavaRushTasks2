package javaReplace;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        String path = "/usr/javasa/jdk1.8/bin/";

        String jdk13 = "jdk-13";
        System.out.println(changePath(path, jdk13));
    }


    public static String changePath(String path, String jdk) {
        //напишите тут ваш код
        String version =path.substring(path.indexOf("jdk"),path.indexOf("/",path.indexOf(("jdk"))));




        return path.replace(version,jdk);
    }

}

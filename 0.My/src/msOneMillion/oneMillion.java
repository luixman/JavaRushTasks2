package msOneMillion;


import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class oneMillion {
    private static double [] ms=new double[100_000_000];
    private static double [] ms2=new double[100_000_000];

    public static void main(String[] args) {
        for (int i = 0; i < ms.length; i++) {
            ms[i]=i;
            ms2[i]=i;
                System.out.println(ms[i]+" ыыы "+ms2[i]);

        }






    }
}

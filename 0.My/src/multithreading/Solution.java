package multithreading;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Solution {
    /*public static void main(String[] args) {
        Printer printer = new Printer();
        Thread childThread = new Thread(printer);
        childThread.start();
        System.out.println("main1");
        System.out.println("main2");


    }*/

    public static int[] array = {5, 8, 7, 6, 1, 4, 3, 2, 22};
    public static int element = 5;

    public  static int[] tmp = Arrays.copyOfRange(array, 0, array.length);

    public static void main(String[] args) {
        //напишите тут ваш код


        Arrays.sort(tmp);

        if(Arrays.binarySearch(tmp, element) >= 0)
            System.out.println(true);

        else
            System.out.println(false);

    }
}


class Printer  implements Runnable{
    public void run(){
        System.out.println("я принтер");
        System.out.println("конец принтер");
    }
}
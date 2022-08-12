import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Test {
    public static String[] strings;

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        strings = new String[6];
        for (int i = 0; i < strings.length; i++) {
            strings[i] = console.nextLine();
        }
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if ((strings[i] != null) && (strings[j] != null)) {
                    if (i != j) {
                        boolean x;
                        x = strings[i].equals(strings[j]);
                        if (x == true) {
                            strings[i] = null;
                            strings[j] = null;
                        }
                    }
                }
            }

        }
        for (int i = 0; i < strings.length; i++) {
            System.out.print(strings[i] + ", ");
        }
    }
}

 class DownloadManager {
     public static void main(String[] args) {
         Thread thread = new Thread();
         thread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
             @Override
             public void uncaughtException(Thread t, Throwable e) {

             }
         });

         thread.start();
     }
 }





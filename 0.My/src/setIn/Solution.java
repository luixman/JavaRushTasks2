package setIn;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Scanner;

public class Solution   {


    public static void main (String[] args) throws Exception {

        System.setIn(new FileInputStream("0.My/src/setIn/inputConsole"));

        Scanner scanner = new Scanner(System.in);

        while(scanner.hasNext()){
            System.out.println(scanner.nextLine());
        }
    }


}

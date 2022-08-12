package com.javarush.task.task16.task1632;

import java.util.Scanner;

public  class ThreadFive implements Runnable{

    @Override
    public void run() {
        Scanner scanner =new Scanner(System.in);
      int sum=0;
       while(true){
           String value=scanner.next();
           if(value.equals("N")){
               break;
           } else  {
               sum+=Integer.decode(value);
           }

       }
        System.out.println(sum);
    }
}

package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Hippodrome {
    public static Hippodrome game;
    private List<Horse> horses;

    public List<Horse> getHorses() {
        return horses;
    }

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    void run() throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            move();
            print();
            Thread.sleep(200);
        }
    }
     void print(){
        getHorses().forEach(Horse::print);
         for (int i = 0; i < 10; i++) {
             System.out.println();
         }


    }
     void move(){
        getHorses().forEach(Horse::move);
    }

    public Horse getWinner(){
      Horse winner=horses.get(0);
      int dis =(int)horses.get(0).getDistance();
        for (Horse h : horses) {
            if((int)h.getDistance()>dis) {
                dis = (int) h.getDistance();
                winner =h;
            }
        }
        return winner;
    }
    public void printWinner(){
        System.out.println("Winner is "+getWinner().getName()+"!");

    }

    public static void main(String[] args) throws InterruptedException {
        List<Horse> horses = new ArrayList<>();
        horses.add(new Horse("name 1",3,0));
        horses.add(new Horse("name 2",3,0));
        horses.add(new Horse("name 3",3,0));
        game = new Hippodrome(horses);

        game.run();
        game.printWinner();

    }
}

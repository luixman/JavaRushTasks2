package memTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Solution {

    public static void main(String[] args) throws InterruptedException {
        List<MemoryUse> memoryUses= new ArrayList<>();
        Random rnd = new Random();

        while(true){
           try {
               memoryUses.add(new MemoryUse(rnd.nextLong(), rnd.nextLong()));
           } catch (OutOfMemoryError e){
               System.out.println(e.getMessage());
               memoryUses.clear();
           }

            if(memoryUses.size()%1000000==0) {
                System.out.println(memoryUses.size());
                Thread.sleep(10);
            }
        }

    }

}

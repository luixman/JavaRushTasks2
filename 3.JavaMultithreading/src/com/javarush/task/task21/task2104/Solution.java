package com.javarush.task.task21.task2104;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/* 
Equals and HashCode
*/

public class Solution {
    private final String first, last;

    public Solution(String first, String last) {
        this.first = first;
        this.last = last;
    }

    @Override
    public boolean equals(Object o) {
       if(this==o) return true;

       if(!(o instanceof Solution))
           return false;

       Solution solution =(Solution) o;

      // if(first!=null ? first.equals(solution.first) : solution.first!=null) return false;
       return Objects.equals(last, solution.last) && Objects.equals(first,solution.first);
    }


    @Override
    public int hashCode() {
       int result =first!=null ? first.hashCode() : 0;
        return 31*result+(last!=null? last.hashCode() : 0);
    }

    public static void main(String[] args) {
        Set<Solution> s = new HashSet<>();
        s.add(new Solution("Donald", "Duck"));
        System.out.println(s.contains(new Solution("Donald", "Duck")));
    }
}

package stringComparator;

import java.util.*;

public class Solution {
    static List<String> strings = new ArrayList<>();

    public static void main(String[] args) {
        Collections.addAll(strings,"123","dfg","абв","333");

        strings.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });

        strings.forEach(System.out::println);



    }
}

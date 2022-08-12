package binarySearch;

import java.util.ArrayList;
import java.util.Collections;

public class binarySearch {


    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        Collections.addAll(list,1,2,3,4,5,6,7,8,10);

        System.out.println(binarySearch(list,5));
    }

    public static int binarySearch(ArrayList<Integer> list, Integer key) {
        int low = 0;
        int high = list.size() - 1;
        int mid = (low + high) / 2;
        int index = -1;
        while (low <= high) {
            if (list.get(mid) < key) {
                low = mid + 1;
            } else if (list.get(mid).equals(key)) {
                index = mid;
                break;
            } else {
                high = mid - 1;
            }
            mid = (low + high) / 2;
        }
        return index;


    }
}

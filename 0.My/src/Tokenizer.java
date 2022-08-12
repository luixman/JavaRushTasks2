import java.nio.charset.Charset;
import java.util.*;

public class Tokenizer {
    public static void main(String[] args) {
        StringTokenizer tokenizer = new StringTokenizer("привет!как!дела? 1x23 1x23 12x3x4", " ");

        List<String> wordsList = Arrays.asList("one", "two", "three");
        String[] wordsArray = (String[]) wordsList.toArray();

       /* for (Integer word : wordsArray) {
            System.out.println(word);


            while (tokenizer.hasMoreTokens()) {
                System.out.println(tokenizer.nextToken("!"));
            }

            String s = "привет!как!дела? 1x23 1x23 12x3x4";
            System.out.println(s.replaceAll("[!x]", " "));

            char a = 44;
            System.out.println(a);

            SortedMap<String, Charset> charsets = Charset.availableCharsets();
            charsets.forEach((k, v) -> System.out.println(k + " " + v));
        }*/
    }


   /* public static Integer[] sort(Integer[] array) {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(array));
        Collections.sort(list);
        double mediana;
        if (list.size()%2!=0) mediana = list.get(list.size()/2);
        else mediana = ( list.get(list.size()/2) + list.get(list.size()/2-1) )*(1.0)/2;

        Comparator<Integer> compAbs = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                double d1 = Math.abs(o1-mediana);
                double d2 = Math.abs(o2-mediana);
                return (d1 - d2)<0?-1:d1-d2==0?0:1;
            }
        };

        Collections.sort(list,compAbs);

        return (Integer[]) list.toArray();
    }*/

}

public class Solution {
    public static char[][] chars = {
            {'a', 'b', 'c', 'd', 'e'},
            {'j', 'h', 'i', 'j', 'k'},
            {'m', 'n', 'o', 'p', 'q'},
            {'s', 't', 'u', 'v', 'w'}};

    public static void main(String[] args) {
        printArray();
        for(int i=1; i<chars.length-1; i++)
            for(int j=1; j<=chars.length;j++)
                chars[i][j]='-';


        printArray();
    }

    private static void printArray() {
        for (int i = 0; i < chars.length; i++) {
            for (int j = 0; j < chars[i].length; j++) {
                System.out.print(chars[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
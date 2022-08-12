package com.javarush.task.task20.task2027;

import java.util.ArrayList;
import java.util.List;

/* 
Кроссворд
*/

public class Solution {
    public static void main(String[] args) {
        int[][] crossword = new int[][]{
                {'f', 'd', 'e', 'r', 'l', 'k'},
                {'u', 's', 'a', 'm', 'e', 'o'},
                {'l', 'n', 'g', 'r', 'o', 'v'},
                {'m', 'l', 'p', 'r', 'r', 'h'},
                {'p', 'o', 'e', 'e', 'j', 'j'}
        };
        detectAllWords(crossword, "home", "same");
        /*
Ожидаемый результат
home - (5, 3) - (2, 0)
same - (1, 1) - (4, 1)
         */
    }

    public static List<Word> detectAllWords(int[][] crossword, String... words) {

        int hor = crossword[0].length;
        int vert = crossword.length;
        List<Word> result = new ArrayList<>();

        outer:
        for (String s : words) {

            //horizontal
            for (int i = 0; i < vert; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < hor; j++) {
                    sb.append((char)crossword[i][j]);
                }

                String line = sb.toString();
                if (line.contains(s)) {
                    Word word = new Word(s);
                    word.setStartPoint(line.indexOf(s), i);
                    word.setEndPoint(line.indexOf(s) + s.length() - 1, i);
                    result.add(word);
                    continue outer;
                }

                line = sb.reverse().toString();
                if (line.contains(s)) {
                    Word word = new Word(s);
                    word.setStartPoint(hor - line.indexOf(s) - 1, i);
                    word.setEndPoint(hor - line.indexOf(s) - s.length(), i);
                    result.add(word);
                    continue outer;
                }
            }
            //vert

            for (int i = 0; i < hor; i++) {
                StringBuilder sb = new StringBuilder();
                for (int[] aCrossword : crossword)
                    sb.append((char) aCrossword[i]);

                String line = sb.toString();
                if (line.contains(s)) {
                    Word word = new Word(s);
                    word.setStartPoint(i, line.indexOf(s));
                    word.setEndPoint(i, line.indexOf(s) + s.length() - 1);
                    result.add(word);
                    continue outer;
                }

                line = sb.reverse().toString();
                if (line.contains(s)) {
                    Word word = new Word(s);
                    word.setStartPoint(i, vert - line.indexOf(s) - 1);
                    word.setEndPoint(i, vert - s.length() - line.indexOf(s));
                    result.add(word);
                    continue outer;
                }
            }

            //rightDiagonal

            for (int i = 0; i < vert; i++) {
                for (int j = 0; j < hor; j++) {
                    int iTemp = i;
                    int jTemp = j;
                    StringBuilder sb = new StringBuilder();

                    while (iTemp < vert && jTemp < hor) {
                        sb.append((char) crossword[iTemp][jTemp]);
                        iTemp++;
                        jTemp++;
                    }
                    String line = sb.toString();
                    if (line.contains(s)) {
                        Word word = new Word(s);
                        word.setStartPoint(j + line.indexOf(s), i + line.indexOf(s));
                        word.setEndPoint(j + line.indexOf(s) + s.length() - 1, i + line.indexOf(s) + s.length() - 1);
                        result.add(word);
                        continue outer;
                    }

                    line = sb.reverse().toString();
                    if (line.contains(s)) {
                        Word word = new Word(s);
                        word.setStartPoint(jTemp - 1 - line.indexOf(s), iTemp - 1 - line.indexOf(s));
                        word.setEndPoint(jTemp - line.indexOf(s) - s.length(), iTemp - line.indexOf(s) - s.length());
                        result.add(word);
                        continue outer;
                    }
                }
            }

            //leftDiagonal
            for (int i = 0; i < vert; i++) {
                for (int j = hor - 1; j >= 0; j--) {
                    int iTemp = i;
                    int jTemp = j;
                    StringBuilder sb = new StringBuilder();

                    while (iTemp < vert && jTemp >= 0) {
                        sb.append((char) crossword[iTemp][jTemp]);
                        iTemp++;
                        jTemp--;
                    }
                    String line = sb.toString();
                    if (line.contains(s)) {
                        Word word = new Word(s);
                        word.setStartPoint(j - line.indexOf(s), i + line.indexOf(s));
                        word.setEndPoint(j - line.indexOf(s) - s.length() + 1, i + line.indexOf(s) + s.length() - 1);

                        result.add(word);
                        continue outer;
                    }
                    String horReverse = sb.reverse().toString();
                    if (horReverse.contains(s)) {
                        Word word = new Word(s);
                        word.setStartPoint(jTemp + 1 + horReverse.indexOf(s), iTemp - 1 - horReverse.indexOf(s));
                        word.setEndPoint(jTemp + horReverse.indexOf(s) + s.length(), iTemp - horReverse.indexOf(s) - s.length());

                        result.add(word);
                        continue outer;
                    }

                }
            }
        }
        result.forEach(System.out::println);
        return result;

    }



public static class Word {
    private String text;
    private int startX;
    private int startY;
    private int endX;
    private int endY;

    public Word(String text) {
        this.text = text;
    }

    public void setStartPoint(int i, int j) {
        startX = i;
        startY = j;
    }

    public void setEndPoint(int i, int j) {
        endX = i;
        endY = j;
    }

    @Override
    public String toString() {
        return String.format("%s - (%d, %d) - (%d, %d)", text, startX, startY, endX, endY);
    }
}
}

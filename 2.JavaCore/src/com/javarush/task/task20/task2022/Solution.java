package com.javarush.task.task20.task2022;

import java.io.*;

/* 
Переопределение сериализации в потоке
*/

public class Solution implements Serializable, AutoCloseable {

    String fileName;
    transient private FileOutputStream stream;

    public Solution(String fileName) throws FileNotFoundException {
        this.fileName = fileName;
        this.stream = new FileOutputStream(this.fileName);
    }

    public void writeObject(String string) throws IOException {
        stream.write(string.getBytes());
        stream.write("\n".getBytes());
        stream.flush();
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();


    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        stream = new FileOutputStream(fileName, true);

    }

    @Override
    public void close() throws Exception {
        System.out.println("Closing everything!");
        stream.close();
    }

    public static void main(String[] args) {

       String fileName="D:\\123.log";

        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(fileName));
             ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(fileName))
        ) {

            Solution solution = new Solution("D:\\1233.log");

            outputStream.writeObject(solution);
            outputStream.flush();

            Solution solution1 =(Solution) inputStream.readObject();
            if(solution.fileName.equals(solution1.fileName))
                System.out.println("YEP");
        } catch (Exception e){

        }

    }
}

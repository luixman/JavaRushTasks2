package PrintStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

//записываем содержимое одного файла в другой   100 раз
public class Solution {
    public static void main(String[] args) throws Exception {

        PrintStream printStream= new PrintStream("0.My/src/PrintStream/newFile");

      List<String> list =  Files.readAllLines(Paths.get("0.My/src/PrintStream/file"));

        for (int i = 1; i <= 100; i++) {
            list.forEach(printStream::println);
            printStream.println("------- Копия "+i+"------");

        }




    }
}

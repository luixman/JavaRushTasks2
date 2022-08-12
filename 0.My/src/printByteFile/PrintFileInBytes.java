package printByteFile;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

public class PrintFileInBytes {
    public static void main(String[] args) throws Exception
    {
        //Создаем поток-чтения-байт-из-файла
        FileInputStream inputStream = new FileInputStream("d:\\audio.log");
        // Создаем поток-записи-байт-в-файл
       FileOutputStream outputStream = new FileOutputStream("d:\\123.log");

        while (inputStream.available() > 0) //пока есть еще непрочитанные байты
        {
            byte[] b = new byte[inputStream.available()];
            b= Files.readAllBytes(Path.of("d:\\audio.log"));
            for (byte byt :
                    b) {
                System.out.println(byt);
                outputStream.write(byt);
            }

            break;

           // прочитать очередной байт в переменную data
          //  outputStream.write(inputStream.read()); // и записать его во второй поток
        }

        inputStream.close(); //закрываем оба потока. Они больше не нужны.
      //  outputStream.close();
    }
}

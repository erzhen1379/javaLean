package leaning.jdk.io;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileReaderTest {
    public static void main(String[] args) {
        FileReader fileReader = null;
        FileWriter fileWriter = null;
        try {
            fileReader = new FileReader("./demo/filereader.txt");
            fileWriter = new FileWriter("./demo/filewriter.txt");
            char[] chars = new char[1024 * 1024];
            int read;
            while ((read = fileReader.read(chars)) != -1) {
                fileWriter.write(chars, 0, read);
            }
            fileWriter.flush();
            if (fileReader != null) {
                fileReader.close();
            }
            if (fileWriter != null) {
                fileWriter.close();
            }
        } catch (IOException e) {
            e.printStackTrace();

        }
    }
}

package leaning.jdk.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BufferedReaderDemo {
    public static void main(String[] args) {
        BufferedReader reader = null;
        try {
            for (int i = 0; i < 3; i++) {
                reader = new BufferedReader(new FileReader("./demo/filereader.txt"));
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
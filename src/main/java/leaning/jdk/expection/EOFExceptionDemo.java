package leaning.jdk.expection;

import java.io.*;

public class EOFExceptionDemo {
    public static void main(String[] args) {
       // streamRead();
    }

    /**
     * 1.测试抛出EOFException
     */
    public static void streamRead() {
        try {
            FileInputStream fileInputStream = new FileInputStream("./demo/filereader.txt");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            while (true) {
                Object o = objectInputStream.readObject();
                System.out.println(o);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            if (e instanceof EOFException) {
                System.out.println("模拟生成EOFException");
            } else {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


}

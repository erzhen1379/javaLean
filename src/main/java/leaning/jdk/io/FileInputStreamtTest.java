package leaning.jdk.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 测试字符输入流
 */
public class FileInputStreamtTest {
    public static void main(String[] args) {
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream("./demo/inputTest.txt");
            //1、返回从该输入流中可以读取（或跳过）的字节数的估计值，而不会被下一次调用此输入流的方法阻塞。
            int available = fileInputStream.available();
            System.out.println("available" + available);
            //2、跳过并丢弃来自此输入流的 2字节数据。
            //     long skip = fileInputStream.skip(2);
            //      System.out.println("skip:" + skip);
            //3、读取文件内容，为了减少IO，我们创建一个Byte数组作为接收缓冲区
            byte[] bytes = new byte[1024];
            int read;
            System.out.println("----------------------------");
            //4.从输入流中读取一些字节数，并将他们存到缓冲区
            while ((read = fileInputStream.read(bytes)) != -1) {
                System.out.println(new String(bytes, 0, read));
            }
            if (fileInputStream != null) {
                fileInputStream.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

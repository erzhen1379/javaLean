package leaning.jdk.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 文件输出流
 * <p>
 * 1.换行写  \n
 * <p>
 * 2.续写,true
 */
public class FileOutputStreamTest {
    public static void main(String[] args) {
        OutStream();
        intCopyOut();
    }

    private static void OutStream() {
        FileOutputStream fileOutputStream = null;
        String str;
        try {
            //todo 创建对象
            fileOutputStream = new FileOutputStream("./demo/outputStream.txt",true);
            str = "zhangsan\n" + "lisi\n" + "wangwu\n";
            //将字符串转换成byte数组
            byte[] bytes = str.getBytes();
            for (int i = 0; i < bytes.length; i++) {
                System.out.println(bytes[i]);
            }
            //写对象，要求父目录存在，文件存在会覆盖对象
            fileOutputStream.write(bytes);



            fileOutputStream.flush();

            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void intCopyOut() {
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            fileInputStream = new FileInputStream("./demo/inputTest.txt");
            fileOutputStream = new FileOutputStream("./demo/coyy.txt");
            byte[] bytes = new byte[1024];
            int read;
            while ((read = fileInputStream.read(bytes)) != -1) {
                fileOutputStream.write(bytes, 0, read);
            }
            fileOutputStream.flush();
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

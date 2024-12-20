package leaning.structure.demo;



import org.testng.annotations.Test;

import java.io.*;
import java.util.Arrays;

public class ReadAndWrite {

    /**
     * 一行一行读取文件，适合字符读取，若读取中文字符时会出现乱码
     * <p>
     * 流的关闭顺序：先打开的后关，后打开的先关，
     * 否则有可能出现java.io.IOException: Stream closed异常
     *
     * @throws IOException
     */
    @Test
    public void readFile01() throws IOException {
        FileReader fr = new FileReader("./input/file.txt");
        BufferedReader br = new BufferedReader(fr);
        String line = "";
        String[] arrs = null;
        while ((line = br.readLine()) != null) {
            arrs = line.split(",");
            System.out.println(Arrays.toString(arrs));
        }
        br.close();
        fr.close();
    }

    /**
     * 一行一行读取文件，解决读取中文字符时出现乱码
     * <p>
     * 流的关闭顺序：先打开的后关，后打开的先关，
     * 否则有可能出现java.io.IOException: Stream closed异常
     *
     * @throws IOException
     */
    @Test
    public void readFile02() throws IOException {
        /*FileInputStream fis = new FileInputStream("./input/file.txt");
        InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
        BufferedReader br = new BufferedReader(isr);*/
        //简写如下
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("./input/file.txt"), "UTF-8"));
        String line = "";
        String[] arrs = null;
        while ((line = br.readLine()) != null) {
            arrs = line.split(",");
            System.out.println(Arrays.toString(arrs));
        }
        br.close();
     //   isr.close();
      //  fis.close();
    }

    /**
     * 一行一行写入文件，适合字符写入，若写入中文字符时会出现乱码
     * <p>
     * 流的关闭顺序：先打开的后关，后打开的先关，
     * 否则有可能出现java.io.IOException: Stream closed异常
     *
     * @throws IOException
     */
    @Test
    public void writeFile01() throws IOException {
        String[] arrs = {
                "zhangsan,23,FuJian",
                "lisi,30,ShangHai",
                "wangwu,43,BeiJing",
                "laolin,21,ChongQing",
                "ximenqing,67,GuiZhou"
        };
        FileWriter fw = new FileWriter(new File("./input/file2.txt"));
        //写入中文字符时会出现乱码
        BufferedWriter bw = new BufferedWriter(fw);
        //BufferedWriter  bw=new BufferedWriter(new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File("./input/file.txt")), "UTF-8")));

        for (String arr : arrs) {
            bw.write(arr + "\t\n");
        }
        bw.close();
        fw.close();
    }

    /**
     * 一行一行写入文件，解决写入中文字符时出现乱码
     * <p>
     * 流的关闭顺序：先打开的后关，后打开的先关，
     * 否则有可能出现java.io.IOException: Stream closed异常
     *
     * @throws IOException
     */
    @Test
    public void writeFile02() throws IOException {
        String[] arrs = {
                "zhangsan,23,福建",
                "lisi,30,上海",
                "wangwu,43,北京",
                "laolin,21,重庆",
                "ximenqing,67,贵州"
        };
        //写入中文字符时解决中文乱码问题
        //注意，若为true，则为追加写入
        /*FileOutputStream fos = new FileOutputStream(new File("./input/file2.txt"),true);
        OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
        BufferedWriter bw = new BufferedWriter(osw);*/
        //简写如下：
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File("./input/file2.txt"),true), "UTF-8"));

        for (String arr : arrs) {
            //bw.write(arr + "\t\n");
            writer.write(arr + "\t\n");
        }

        //注意关闭的先后顺序，先打开的后关闭，后打开的先关闭
       /* bw.close();
        osw.close();
        fos.close();*/
        writer.close();
    }
}

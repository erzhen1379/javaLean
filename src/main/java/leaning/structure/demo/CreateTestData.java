package leaning.structure.demo;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

public class CreateTestData {

    public static void main(String[] args) {
        writer();
    }
    public static void writer() {
        PrintWriter PrintWriter;
        String[] name = {"张三", "李四", "王五"};
        String age;    //年龄
        String[] sex = {"男", "女", "其他"};  //性别
        String[] creeer = {"程序员", "教师", "律师"}; //职业
        Random rand = new Random();
        String str = null;
        try {
            PrintWriter = new PrintWriter(new FileWriter("D:\\creereInfo.txt"));
            for (int i = 0; i < 100; i++) {
                int num = rand.nextInt(3);
                str = name[num] + "," + rand.nextInt(100) + "," + sex[num] + "," + creeer[num];
                PrintWriter.printf(i + "," + str);
                PrintWriter.printf("\n");
                PrintWriter.flush();
            }
            PrintWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

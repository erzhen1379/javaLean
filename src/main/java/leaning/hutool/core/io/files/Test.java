package leaning.hutool.core.io.files;

import java.io.File;

public class Test {
    public static void main(String[] args) {
        FileNameUitl fileNameUitl = new FileNameUitl();
        String s = fileNameUitl.mainName("/home/hadoop/abc..tar.gz");
        System.out.println(s);



    }

    @org.testng.annotations.Test
    public void mainNameTest() {
        FileNameUitl fileNameUitl = new FileNameUitl();
        String s = fileNameUitl.mainName("/home/hadoop/abc..tar.gz");
        System.out.println(s);
    }
}

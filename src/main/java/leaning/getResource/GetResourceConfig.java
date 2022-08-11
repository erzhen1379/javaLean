package leaning.getResource;

import java.io.*;

public class GetResourceConfig {
    public static void main(String[] args) throws IOException {
        System.out.println("测试读取配置文件");
        GetFunctionResourcesUtils resources = new GetFunctionResourcesUtils();
        //resources.function1("log4j.properties");
        // resources.function2("log4j.properties");
        // resources.function3("log4j.properties");
        // resources.function4("log4j.properties");
        //resources.function5("log4j.properties");
       // resources.function8("log4j.properties");
        resources.function9("log4j.properties");
    }

}

package leaning.getResource;


import java.io.*;
import java.net.URL;
import java.net.URLDecoder;

public class GetFunctionResourcesUtils {
    /**
     * 主要核心方法是使用getResource和getPath方法，这里的getResource("")里面是空字符串
     *
     * @param fileName
     * @throws IOException
     */
    public void function1(String fileName) throws IOException {
        String path = this.getClass().getClassLoader().getResource("").getPath();//注意getResource("")里面是空字符串
        System.out.println(path);
        String filePath = path + fileName;
        System.out.println(filePath);
        getFileContent(filePath);
    }

    /**
     * 直接通过文件名getPath来获取路径
     *
     * @param fileName
     * @throws IOException
     */
    public void function2(String fileName) throws IOException {
        String path = this.getClass().getClassLoader().getResource(fileName).getPath();//注意getResource("")里面是空字符串
        System.out.println(path);
        String filePath = URLDecoder.decode(path, "UTF-8");//如果路径中带有中文会被URLEncoder,因此这里需要解码
        System.out.println(filePath);
        getFileContent(filePath);
    }

    /**
     * 直接通过文件名+getFile()来获取
     *
     * @param fileName
     * @throws IOException
     */
    public void function3(String fileName) throws IOException {
        String path = this.getClass().getClassLoader().getResource(fileName).getFile();
        System.out.println(path);
        String filePath = URLDecoder.decode(path, "UTF-8");//如果路径中带有中文会被URLEncoder,因此这里需要解码
        System.out.println(filePath);
        getFileContent(filePath);
    }

    /**
     * (常用)
     * 直接使用getResourceAsStream方法获取流
     * springboot项目中需要使用此种方法，因为jar包中没有一个实际的路径存放文件
     *
     * @param fileName
     * @throws IOException
     */
    public void function4(String fileName) throws IOException {
        InputStream in = this.getClass().getClassLoader().getResourceAsStream(fileName);
        getFileContent(in);
    }

    /**
     * (常用)
     * 直接使用getResourceAsStream方法获取流
     * 如果不使用getClassLoader，可以使用getResourceAsStream("/配置测试.txt")直接从resources根路径下获取
     *
     * @param fileName
     * @throws IOException
     */
    public void function5(String fileName) throws IOException {
        InputStream in = this.getClass().getResourceAsStream("/" + fileName);
        getFileContent(in);
    }

    /**
     * 通过绝对路径获取项目中文件的位置（不能用于服务器）
     *
     * @param fileName
     * @throws IOException
     */
    public void function8(String fileName) throws IOException {
        File directory = new File("");
        //规范路径：getCanonicalPath() 方法返回绝对路径，会把 ..\ 、.\ 这样的符号解析掉
        String canonicalPath = directory.getCanonicalPath();
        System.out.println(canonicalPath);
        //绝对路径：getAbsolutePath() 方法返回文件的绝对路径，如果构造的时候是全路径就直接返回全路径，如果构造时是相对路径，就返回当前目录的路径 + 构造 File 对象时的路径
        String absolutePath = directory.getAbsolutePath();
        System.out.println(absolutePath);
    }

    /**
     * 通过设置环境变量，然后通过绝对路径获取文件
     * System.getenv("TEST_ROOT");
     * System.getProperty("TEST_ROOT")
     *
     * @param fileName
     * @throws IOException
     */
    public void function9(String fileName) throws IOException {
        //设置环境变量
        System.setProperty("TEST_ROOT", "D:\\javaProject\\javaLean\\src\\main\\resources\\");
        String testRoot = System.getProperty("TEST_ROOT");
        System.out.println(testRoot);
        String filePath = testRoot + fileName;
        getFileContent(filePath);

    }

    /**
     * 根据文件路径读取文件内容
     *
     * @param fileInPath
     * @throws IOException
     */
    public static void getFileContent(Object fileInPath) throws IOException {
        BufferedReader br = null;
        if (fileInPath == null) {
            return;
        }
        if (fileInPath instanceof String) {
            br = new BufferedReader(new FileReader(new File((String) fileInPath)));
        } else if (fileInPath instanceof InputStream) {
            br = new BufferedReader(new InputStreamReader((InputStream) fileInPath));
        }
        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }
        br.close();
    }
}

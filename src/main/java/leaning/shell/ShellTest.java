package leaning.shell;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class ShellTest {
    private static final Logger logger = LoggerFactory.getLogger(ShellTest.class);

    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("测试java调用shell命令");
        //测试
      //  ExecResult execResult = execuShell("javac");
        ExecResult execResult = execuShell("sh ./src/main/java/leaning/shell/echo.sh");
        System.out.println(String.valueOf(execResult.isResult()) + "\n" + execResult.getExecOut());
    }

    /**
     * @param pathOrCommand
     * @return
     */
    public static ExecResult execuShell(String pathOrCommand) {
        ExecResult execResult = new ExecResult();
        StringBuilder stringBuilder = new StringBuilder();
        String charSet;
        ProcessBuilder builder;
        //获取当前系统版本
        String osName = System.getProperty("os.name");
        //判断当前系统为linux
        if (osName.equals("Linux")) {
            builder = new ProcessBuilder("sh", "-c", pathOrCommand.toString());
            charSet = "utf-8";
        } else {
            builder = new ProcessBuilder("cmd", "/c", pathOrCommand.toString());
            charSet = "gbk";
        }
        builder.redirectErrorStream(true);
        Process process = null;
        String line = null;
        try {
            process = builder.start();
            BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream(), charSet));
            while ((line = br.readLine()) != null) {
                line = line.trim();
                // System.out.println(line);
                stringBuilder.append(line + "\n");
                execResult.setExecOut(stringBuilder.toString());
            }
            // 等待命令执行完成
            int code = process.waitFor();
            if (code == 0) {
                //通常情况0 表示命令或者脚本正常退出，但是如果脚本自己有返回状态这里需要根据自己状态判断
                //  System.out.println("success");
                execResult.setResult(true);
            } else {
                execResult.setResult(false);
                //   System.out.println("fail");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return execResult;
    }
}

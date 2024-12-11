package leaning.hutool.core.io.files;


import leaning.hutool.core.io.IORuntimeException;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/**
 * 文件写入器
 */
public class FileWriter extends FileWrapper {
    /**
     * 构造<br>
     * 编码使用 {@link FileWrapper#DEFAULT_CHARSET}
     *
     * @param file 文件
     */
    public FileWriter(File file) {
        this(file, DEFAULT_CHARSET);
    }

    /**
     * 构造
     *
     * @param file    文件
     * @param charset 编码，使用 {@link CharsetUtil}
     */
    public FileWriter(File file, Charset charset) {
        super(file, charset);
    }


    /**
     * 将String写入文件，追加模式
     *
     * @param content 写入的内容
     * @return 写入的文件
     * @throws IORuntimeException IO异常
     */
    public File write(String content) {
        return write(content, true);
    }

    /**
     * 将String写入文件
     *
     * @param content  写入的内容
     * @param isAppend 是否追加
     * @return 目标文件
     * @throws IORuntimeException IO异常
     */
    public File write(String content, boolean isAppend) {
        BufferedWriter writer;
        try {
            writer = getWrite(isAppend);
            writer.write(content);
            writer.flush();
        } catch (IOException e) {
            //todo
            throw new IORuntimeException(e);
        }
        return file;
    }

    /**
     * 将内容追加写入
     *
     * @param content
     * @return
     */
    public File append(String content) {
        return write(content, true);
    }

    /**
     * 获得一个带缓存的写入对象
     *
     * @param isAppend
     * @return
     */
    public BufferedWriter getWrite(boolean isAppend) throws FileNotFoundException {
        return new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, isAppend), charset));
    }

    /**
     * 将列表写入文件
     *
     * @param <T>           集合元素类型
     * @param list          列表
     * @param lineSeparator 换行符枚举（Windows、Mac或Linux换行符）
     * @param isAppend      是否追加
     * @return 目标文件
     * @throws IORuntimeException IO异常
     * @since 3.1.0
     */
    public <T> File writeLines(Iterable<T> list, LineSeparator lineSeparator, boolean isAppend) throws IORuntimeException {
      /*  try (PrintWriter writer = getPrintWriter(isAppend)) {
            boolean isFirst = true;
            for (T t : list) {
                if (null != t) {
                    if (isFirst) {
                        isFirst = false;
                        if (isAppend && FileUtil.isNotEmpty(this.file)) {
                            // 追加模式下且文件非空，补充换行符
                            printNewLine(writer, lineSeparator);
                        }
                    } else {
                        printNewLine(writer, lineSeparator);
                    }
                    writer.print(t);

                    writer.flush();
                }
            }
        }*/
        return this.file;
    }

    @Override
    public void printLog() {
        System.out.println("child");
        super.printLog();

    }

    public static void main(String[] args) {
        FileWriter fileWriter = new FileWriter(new File("./demo/a.log"));
        fileWriter.write("java", false);

        List<String> list = new ArrayList<>();
        list.add("zhangsan");
        list.add("lisi");
        list.add("wangwu");
        fileWriter.writeLines(list, LineSeparator.WINDOWS, false);
        fileWriter.printLog();

    }
}

package leaning.hutool.core.io.files;


import leaning.hutool.core.io.IORuntimeException;

import java.io.*;
import java.nio.charset.Charset;

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
            writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, isAppend), charset));
            writer.write(content);
            writer.flush();
        } catch (IOException e) {
            //todo
            throw new IORuntimeException(e);
        } finally {
            writer=null;
        }
        return file;
    }

    public static void main(String[] args) {
        FileWriter fileWriter = new FileWriter(new File("./demo/a.log"));
        fileWriter.write("java");
    }
}

package leaning.hutool.core.io.files;

import java.io.File;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class FileWrapper {
    protected File file;
    protected Charset charset;

    //StandardCharsets  设置编码
    public static final Charset DEFAULT_CHARSET = StandardCharsets.UTF_8;


    public FileWrapper(File file, Charset charset) {
        this.file = file;
        this.charset = charset;
    }
}

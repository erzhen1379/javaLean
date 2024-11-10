package leaning.hutool.core.io.files;

import java.io.File;
import java.io.IOException;

/**
 * 文件追加器<br>
 * 持有一个文件，在内存中积累一定量的数据后统一追加到文件<br>
 * 此类只有在写入文件时打开文件，并在写入结束后关闭之。因此此类不需要关闭<br>
 * 在调用append方法后会缓存于内存，只有超过容量后才会一次性写入文件，因此内存中随时有剩余未写入文件的内容，在最后必须调用flush方法将剩余内容刷入文件
 */
public class FileAppender {
    /**
     * 内存中持有的字符串数
     */
    int capacity;
    /**
     * 追加内容是否为新
     */
    boolean isNewLineMode;



    public FileAppender(File file, int capacity, boolean isNewLineMode) throws IOException {

    }

    public static void main(String[] args) {

    }
}

package leaning.hutool.core.io.files;

import leaning.hutool.core.uitls.CharUtil;

/**
 * 文件名相关工具栏
 */
public class FileNameUitl {
    /**
     * 获取文件的名称
     *
     * @param fileName
     * @return
     */
    public static String mainName(String fileName) {
        //注意，  null==fileName，防止fileName=null
        if (null == fileName) {
            return null;
        }
        int len = fileName.length();
        if (0 == len) {
            return fileName;
        }

        int begin = 0;
        int end = len;
        char c;
        //此处要从结尾开始遍历
        for (int i = len - 1; i >= 0; i--) {
            c = fileName.charAt(i);
            //查找文件的最后一个文件名和扩展名的分隔符
            //CharUtil.DOT 接口
            if (CharUtil.DOT == c) {
                end = i;
            }
            // 查找最后一个路径分隔符（/或者\），如果这个分隔符在.之后，则继续查找，否则结束
            if (CharUtil.isFileSeparator(c)) {
                begin = i + 1;
                break;
            }
        }


        return fileName.substring(begin, end);
    }
}

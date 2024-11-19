package leaning.hutool.core.io.files;

/**
 * 换行符枚举<br>
 * 换行符包括：
 * <pre>
 * Mac系统换行符："\r"
 * Linux系统换行符："\n"
 * Windows系统换行符："\r\n"
 * </pre>
 *
 * @author Looly
 * @see #MAC
 * @see #LINUX
 * @see #WINDOWS
 * @since 3.1.0
 */
public enum LineSeparator {
    /**
     * Mac系统换行符："\r"
     */
    MAC("\r"),
    /**
     * Linux系统换行符："\n"
     */
    LINUX("\n"),
    /**
     * Windows系统换行符："\r\n"
     */
    WINDOWS("\r\n");
    private final String value;

    LineSeparator(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

}

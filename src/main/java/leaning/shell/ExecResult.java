package leaning.shell;

/**
 * shell 执行结果输出
 */
public class ExecResult {
    private boolean result=false;
    private String execOut;
    private String execErrorOut;

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public String getExecOut() {
        return execOut;
    }

    public void setExecOut(String execOut) {
        this.execOut = execOut;
    }


}

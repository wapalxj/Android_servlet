package c3_5_01_web_Vero_Server;

import java.io.Serializable;

/**
 * Created by vero on 2015/12/9.
 * 响应信息对象
 */
public class ResultJSONBean implements Serializable {
    private String result;
    private String errorMsg;

    public ResultJSONBean() {
    }
    public ResultJSONBean(String result, String errorMsg) {
        this.result = result;
        this.errorMsg = errorMsg;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}

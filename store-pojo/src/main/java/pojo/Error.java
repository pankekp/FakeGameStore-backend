package pojo;

/**
 * @author panke
 * @date created in 2018/4/8 21:34
 */
public class Error {

    private Integer code;
    private String message;

    public Error() {
    }

    public Error(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

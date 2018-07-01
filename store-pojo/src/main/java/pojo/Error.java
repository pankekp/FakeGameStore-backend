package pojo;

/**
 * @author panke
 * @date created in 2018/4/8 21:34
 */
public class Error {

    private String title;
    private String message;

    public Error() {
    }

    public Error(String title, String message) {
        this.title = title;
        this.message = message;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

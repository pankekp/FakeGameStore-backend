package exception.user;

/**
 * @author panke
 * @date created in 2018/7/27 20:47
 */
public class AddOrderException extends RuntimeException {

    private Integer userId;

    public AddOrderException(Integer userId) {
        this.userId = userId;
    }

    public Integer getUserId() {
        return userId;
    }
}

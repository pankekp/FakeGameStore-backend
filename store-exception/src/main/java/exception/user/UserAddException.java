package exception.user;

import pojo.User;

/**
 * @author panke
 * @date created in 2018/7/5 13:47
 */
public class UserAddException extends RuntimeException {

    private User user;

    public UserAddException(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }
}

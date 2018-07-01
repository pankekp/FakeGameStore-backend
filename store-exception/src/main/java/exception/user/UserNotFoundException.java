package exception.user;

import pojo.User;

/**
 * @author panke
 * @date created in 2018/7/1 13:30
 */
public class UserNotFoundException extends RuntimeException {

    private User user;

    public UserNotFoundException(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }
}

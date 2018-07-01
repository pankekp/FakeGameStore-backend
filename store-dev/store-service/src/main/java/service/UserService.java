package service;

import pojo.User;

/**
 * @author panke
 * @date created in 2018/7/1 13:17
 */
public interface UserService {

    /**
     * 根据登录信息查找用户
     *
     * @param user 登录信息
     * @return id、username或null
     */
    User login(User user);
}

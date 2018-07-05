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

    /**
     * 查找用户名是否存在
     *
     * @param user 用户名
     * @return 已存在的用户名或null
     */
    User ValidateUsername(User user);

    /**
     * 用户注册
     *
     * @param user 传入的用户名与密码
     * @return 新增用户的数量
     */
    int register(User user);
}

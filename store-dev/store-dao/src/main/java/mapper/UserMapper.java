package mapper;

import pojo.User;

/**
 * @author panke
 * @date created in 2018/7/1 11:31
 */
public interface UserMapper {

    /**
     * 根据登录信息查新用户
     *
     * @param user 用户登录信息
     * @return id与username或null
     */
    User findUser(User user);

    /**
     * 查找用户名是否存在
     *
     * @param user 用户名
     * @return 已存在的用户名或null
     */
    User findUsername(User user);

    /**
     * 用户注册
     *
     * @param user 传入的用户名与密码
     * @return 新增用户的数量
     */
    int addUser(User user);
}

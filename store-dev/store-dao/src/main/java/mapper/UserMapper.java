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
     * @return id与username或空
     */
    User findUser(User user);
}

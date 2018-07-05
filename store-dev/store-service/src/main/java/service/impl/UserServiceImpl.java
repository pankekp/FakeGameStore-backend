package service.impl;

import mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.User;
import service.UserService;

/**
 * @author panke
 * @date created in 2018/7/1 13:19
 */

@Service
public class UserServiceImpl implements UserService {

    private UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public User login(User user) {
        return userMapper.findUser(user);
    }

    @Override
    public User ValidateUsername(User user) {
        return userMapper.findUsername(user);
    }

    @Override
    public int register(User user) {
        return userMapper.addUser(user);
    }
}

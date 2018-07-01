package mapper;

import config.DaoConfig;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pojo.User;

/**
 * @author panke
 * @date created in 2018/7/1 11:39
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DaoConfig.class)
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testFindUser() {
        User user = new User(null, "test", "123");
        User existUser = userMapper.findUser(user);
        Assert.assertNotNull(existUser);
        System.out.println(existUser.getUsername());
    }

    @Test
    public void testFindUserNull() {
        User user = new User(null, "test1", "123");
        User existUser = userMapper.findUser(user);
        System.out.println(existUser);
    }
}

package mapper;

import config.DaoConfig;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pojo.Cart;
import pojo.CartInfo;
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

    @Test
    public void testFindUsername() {
        User user = new User(null, "testadd", null);
        User existUser = userMapper.findUsername(user);
        System.out.println(existUser);
    }

    @Test
    public void testAddUser() {
        User user = new User(null, "testAdd", "123");
        Integer addUserNum = userMapper.addUser(user);
        Assert.assertNotNull(addUserNum);
        System.out.println(addUserNum);
    }

    @Test
    public void TestAddCartInfo() {
        CartInfo cartInfo = new CartInfo(null, 1, 1);
        int record = userMapper.addCartInfo(cartInfo);
        Assert.assertEquals(1, record);
        System.out.println(cartInfo.getId());
    }

    @Test
    public void testAddCart() {
        Cart cart = new Cart(null, 1, 1);
        int record = userMapper.addCart(cart);
        Assert.assertEquals(1, record);
        System.out.println(cart.getId());
    }
}

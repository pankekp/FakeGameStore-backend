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
import pojo.CartItem;
import pojo.ContactInfo;
import pojo.User;

import java.util.ArrayList;
import java.util.List;

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

    @Test
    public void testGetCartInfoIdByUserId() {
        int userId = 1;
        List<Integer> cartInfoIds = userMapper.getCartInfoIdByUserId(userId);
        Assert.assertNotNull(cartInfoIds);
        System.out.println(cartInfoIds.size());
    }

    @Test
    public void testGetCartInfo() {
        List<Integer> ids = new ArrayList<>();
        ids.add(1);
        ids.add(2);
        List<CartItem> cartItems = userMapper.getCartInfo(ids);
        Assert.assertNotNull(cartItems);
        System.out.println(cartItems.size());
        System.out.println(cartItems.get(1).getItemId());
    }

    @Test
    public void testUpdateCartInfo() {
        List<CartInfo> cartInfos = new ArrayList<>();
        cartInfos.add(new CartInfo(1, 1, 3));
        cartInfos.add(new CartInfo(2, 2, 3));
        int rows = userMapper.updateCartInfo(cartInfos);
        System.out.println(rows);
    }

    @Test
    public void testDeleteCartInfo() {
        int row = userMapper.deleteCartInfo(3);
        Assert.assertEquals(1, row);
    }

    @Test
    public void testAddContactInfo() {
        ContactInfo contactInfo = new ContactInfo(null, "test", "13112345678", "陕西省西安市长安区", "710100");
        int row = userMapper.addContactInfo(contactInfo);
        Assert.assertEquals(1, row);
        System.out.println(contactInfo.getId());
    }

    @Test
    public void testAddOrderInfo() {
        List<Integer> cartInfoIds = userMapper.getCartInfoIdByUserId(1);
        List<CartItem> cartItems = userMapper.getCartInfo(cartInfoIds);
        int rows = userMapper.addOrderInfo(cartItems);
        Assert.assertEquals(cartItems.size(), rows);
    }

    @Test
    public void testAddOrders() {
        int userId = 1;
        int contactInfoId = 1;
        List<Integer> cartInfoIds = userMapper.getCartInfoIdByUserId(1);
        List<CartItem> cartItems = userMapper.getCartInfo(cartInfoIds);
        userMapper.addOrderInfo(cartItems);
        int rows = userMapper.addOrders(userId, contactInfoId, cartItems);
        Assert.assertEquals(cartItems.size(), rows);
    }

    @Test
    public void testDeleteCartInfos() {
        List<Integer> cartInfoIds = userMapper.getCartInfoIdByUserId(1);
        List<CartItem> cartItems = userMapper.getCartInfo(cartInfoIds);
        int rows = userMapper.deleteCartInfos(cartItems);
        Assert.assertEquals(cartItems.size(), rows);
    }

}

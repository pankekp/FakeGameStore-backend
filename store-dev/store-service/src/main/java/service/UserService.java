package service;

import exception.tx.TxException;
import pojo.CartCollection;
import pojo.CartItem;
import pojo.ContactInfo;
import pojo.User;

import java.util.List;

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
    User validateUsername(User user);

    /**
     * 用户注册
     *
     * @param user 传入的用户名与密码
     * @return 新增用户的数量
     */
    int register(User user);

    /**
     * 用户向购物车添加单条商品记录
     *
     * @param cartCollection 用户id&商品id&商品数量
     * @return 用户id&商品id&商品数量
     * @throws TxException 运行时事务异常
     */
    CartCollection addToCart(CartCollection cartCollection) throws TxException;

    /**
     * 通过用户id获取购物车信息
     *
     * @param userId 用户id
     * @return cartItem集合
     */
    List<CartItem> getCartItems(int userId);

    /**
     * 根据传入的cartItems集合与用户id更新此用户的购物车商品的数量
     *
     * @param cartItems cartItems集合
     * @return 更新成功的行数，应为cartItem的个数
     */
    int modifyCartItemNum(List<CartItem> cartItems);

    /**
     * 根据cartItemId删除cart中的指定item
     *
     * @param cartItemId id
     * @return 删除行数
     */
    int deleteCartItem(int cartItemId);

    /**
     * 根据用户id与传来的收货人信息进行下单操作
     *
     * @param userId      用户id
     * @param contactInfo 收货人信息
     * @return insert的行数
     */
    int submitOrder(int userId, ContactInfo contactInfo);

}

package mapper;

import org.apache.ibatis.annotations.Param;
import pojo.Cart;
import pojo.CartInfo;
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

    /**
     * 向购物车信息表添加记录
     *
     * @param cartInfo 商品id&商品数量
     * @return 新增记录数, cartInfo中的id为新增的id
     */
    int addCartInfo(CartInfo cartInfo);


    /**
     * 向购物车表添加记录
     *
     * @param cart 用户id&购物车信息id
     * @return 新增记录数, cart中的id为新增的id
     */
    int addCart(Cart cart);
}

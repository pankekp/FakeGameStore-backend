package mapper;

import org.apache.ibatis.annotations.Param;
import pojo.Cart;
import pojo.CartInfo;
import pojo.CartItem;
import pojo.ContactInfo;
import pojo.User;

import java.util.List;

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


    /**
     * 通过用户id获取其cart item
     *
     * @param userId 用户id
     * @return cartInfoId集合
     */
    List<Integer> getCartInfoIdByUserId(int userId);


    /**
     * 根据cartInfoId获取所有购物车记录
     *
     * @param cartInfoIds 购物车信息表id集合
     * @return 购物车记录列表
     */
    List<CartItem> getCartInfo(List<Integer> cartInfoIds);

    /**
     * 更新购物车商品数量
     *
     * @param cartInfos 包括cartInfoId与需要更新的num值
     * @return 更新成功的行数
     */
    int updateCartInfo(List<CartInfo> cartInfos);

    /**
     * 删除用户指定cartInfoId对应的商品
     *
     * @param cartInfoId cartItemId
     * @return 删除行数
     */
    int deleteCartInfo(int cartInfoId);

    /**
     * 插入新的收货人信息
     *
     * @param contactInfo 收货人信息
     * @return 插入成功的行数，新增记录的id在传入的对象中
     */
    int addContactInfo(ContactInfo contactInfo);

    /**
     * 将根据cartInfoId获取的所有购物车记录批量插入orderInfo表
     *
     * @param cartItems 含有goodId与goodNum即可
     * @return 插入的行数，cartItems的itemId为新插入记录的id
     */
    int addOrderInfo(List<CartItem> cartItems);

    /**
     * 根据本订单用户id、收货人信息id、订单详情id向orders表插入记录
     *
     * @param userId        用户id
     * @param contactInfoId 收货人信息id
     * @param cartItems     订单详情的集合,itemId为需要的id
     * @return 插入记录的行数
     */
    int addOrders(@Param("userId") int userId, @Param("contactInfoId") int contactInfoId, @Param("cartItems") List<CartItem> cartItems);

    /**
     * 批量删除已经查询出来的cart记录
     *
     * @param cartItems 包含cartInfoId的cartItem集合
     * @return 删除行数
     */
    int deleteCartInfos(List<CartItem> cartItems);
}

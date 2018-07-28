package service.impl;

import exception.tx.AddContactInfoTxException;
import exception.tx.AddOrderInfoTxException;
import exception.tx.AddOrdersTimeTxException;
import exception.tx.AddOrdersTxException;
import exception.tx.DeleteCartInfoTxException;
import exception.tx.TxException;
import exception.tx.AddCartTxException;
import exception.tx.AddCartInfoTxException;
import mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import pojo.Cart;
import pojo.CartCollection;
import pojo.CartInfo;
import pojo.CartItem;
import pojo.ContactInfo;
import pojo.Orders;
import pojo.OrdersTime;
import pojo.User;
import service.UserService;

import java.util.ArrayList;
import java.util.List;

/**
 * @author panke
 * @date created in 2018/7/1 13:19
 */

@Service
public class UserServiceImpl implements UserService {

    private UserMapper userMapper;
    private DataSourceTransactionManager dataSourceTransactionManager;

    @Autowired
    public UserServiceImpl(UserMapper userMapper,
                           DataSourceTransactionManager dataSourceTransactionManager) {
        this.userMapper = userMapper;
        this.dataSourceTransactionManager = dataSourceTransactionManager;
    }

    @Override
    public User login(User user) {
        return userMapper.findUser(user);
    }

    @Override
    public User validateUsername(User user) {
        return userMapper.findUsername(user);
    }

    @Override
    public int register(User user) {
        return userMapper.addUser(user);
    }

    @Override
    @Transactional
    public CartCollection addToCart(CartCollection cartCollection) throws TxException {
        DefaultTransactionDefinition defaultTransactionDefinition = new DefaultTransactionDefinition();
        TransactionStatus transactionStatus = dataSourceTransactionManager.getTransaction(defaultTransactionDefinition);
        try {
            CartInfo cartInfo = new CartInfo(null, cartCollection.getGoodId(), cartCollection.getGoodNum());
            int cartInfoRecord = userMapper.addCartInfo(cartInfo);
            if (cartInfoRecord != 1) {
                throw new AddCartInfoTxException("添加购物车信息表出错");
            }
            Cart cart = new Cart(null, cartCollection.getUserId(), cartInfo.getId());
            int cartRecord = userMapper.addCart(cart);
            if (cartRecord != 1) {
                throw new AddCartTxException("添加购物车表出错");
            }
            dataSourceTransactionManager.commit(transactionStatus);
            return cartCollection;
        } catch (AddCartInfoTxException | AddCartTxException e) {
            System.out.println(e.getMessage());
            dataSourceTransactionManager.rollback(transactionStatus);
            throw new TxException(e.getMessage());
        }

    }

    @Override
    public List<CartItem> getCartItems(int userId) {
        List<Integer> cartInfoIds = userMapper.getCartInfoIdByUserId(userId);
        return cartInfoIds.size() == 0 ? null : userMapper.getCartInfo(cartInfoIds);
    }

    @Override
    public int modifyCartItemNum(List<CartItem> cartItems) {
        List<CartInfo> cartInfos = new ArrayList<>();
        for (CartItem cartItem : cartItems) {
            cartInfos.add(new CartInfo(cartItem.getItemId(), cartItem.getGame().getId(), cartItem.getGameNum()));
        }
        return userMapper.updateCartInfo(cartInfos);
    }

    @Override
    public int deleteCartItem(int cartItemId) {
        return userMapper.deleteCartInfo(cartItemId);
    }

    @Override
    @Transactional
    public int submitOrder(int userId, ContactInfo contactInfo) throws TxException {
        DefaultTransactionDefinition defaultTransactionDefinition = new DefaultTransactionDefinition();
        TransactionStatus transactionStatus = dataSourceTransactionManager.getTransaction(defaultTransactionDefinition);
        try {
            //增加orderTime
            OrdersTime ordersTime = new OrdersTime();
            int rowForTime = userMapper.addOrdersTime(ordersTime);
            if (rowForTime != 1) {
                throw new AddOrdersTimeTxException("添加订单时间失败");
            }
            //增加联系人信息，取得id
            int rowForContact = userMapper.addContactInfo(contactInfo);
            if (rowForContact != 1) {
                throw new AddContactInfoTxException("添加收货人信息失败");
            }
            //根据用户id查询所有的cartInfoId
            List<Integer> cartInfoIds = userMapper.getCartInfoIdByUserId(userId);
            //根据得到的本用户的所有cartInfoId查询对应的cartItem
            List<CartItem> cartItems = userMapper.getCartInfo(cartInfoIds);
            //将cartInfo表的记录批量删除
            int rowsForDelete = userMapper.deleteCartInfos(cartItems);
            if (rowsForDelete != cartItems.size()) {
                throw new DeleteCartInfoTxException("删除cartItems有误");
            }
            //将得到的cartItems批量插入orderInfo表得到orderInfoId的集合
            int rowsForOrderInfo = userMapper.addOrderInfo(cartItems);
            if (rowsForOrderInfo != cartItems.size()) {
                throw new AddOrderInfoTxException("添加orderInfos有误");
            }
            //操作orders表，其插入行数应为orderInfoId的size大小
            int rowsForOrders = userMapper.addOrders(userId, contactInfo.getId(), ordersTime.getId(), cartItems);
            if (rowsForOrders != cartItems.size()) {
                throw new AddOrdersTxException("添加orders有误");
            }
            dataSourceTransactionManager.commit(transactionStatus);
            return rowsForOrders;
        } catch (AddOrdersTimeTxException | AddContactInfoTxException | DeleteCartInfoTxException | AddOrderInfoTxException | AddOrdersTxException e) {
            System.out.println(e.getMessage());
            dataSourceTransactionManager.rollback(transactionStatus);
            throw new TxException(e.getMessage());
        }
    }

    @Override
    public List<Orders> getOrders(int userId) {
        List<Orders> orders = userMapper.getOrders(userId);
        return orders.size() == 0 ? null : orders;
    }
}

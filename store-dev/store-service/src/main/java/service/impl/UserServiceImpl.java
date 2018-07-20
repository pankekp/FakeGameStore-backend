package service.impl;

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
        return userMapper.getCartInfo(cartInfoIds);
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
}

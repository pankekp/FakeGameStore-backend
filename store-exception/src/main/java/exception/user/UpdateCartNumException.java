package exception.user;

import pojo.CartItem;

import java.util.List;

/**
 * @author panke
 * @date created in 2018/7/20 14:55
 */
public class UpdateCartNumException extends RuntimeException {

    private List<CartItem> cartItems;

    public UpdateCartNumException(List<CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<CartItem> cartItems) {
        this.cartItems = cartItems;
    }
}

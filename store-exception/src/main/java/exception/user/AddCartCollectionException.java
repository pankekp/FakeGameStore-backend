package exception.user;

import pojo.CartCollection;

/**
 * @author panke
 * @date created in 2018/7/8 21:43
 */
public class AddCartCollectionException extends RuntimeException {

    private CartCollection cartCollection;

    public AddCartCollectionException(CartCollection cartCollection) {
        this.cartCollection = cartCollection;
    }

    public CartCollection getCartCollection() {
        return cartCollection;
    }
}

package exception.user;

/**
 * @author panke
 * @date created in 2018/7/20 16:32
 */
public class DeleteCartItemException extends RuntimeException {

    private Integer cartItemId;

    public DeleteCartItemException(Integer cartItemId) {
        this.cartItemId = cartItemId;
    }

    public Integer getCartItemId() {
        return cartItemId;
    }
}

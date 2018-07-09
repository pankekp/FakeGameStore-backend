package pojo;

/**
 * @author panke
 * @date created in 2018/7/8 18:13
 */
public class Cart {

    private Integer id;
    private Integer userId;
    private Integer cartInfoId;

    public Cart() {
    }

    public Cart(Integer id, Integer userId, Integer cartInfoId) {
        this.id = id;
        this.userId = userId;
        this.cartInfoId = cartInfoId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getCartInfoId() {
        return cartInfoId;
    }

    public void setCartInfoId(Integer cartInfoId) {
        this.cartInfoId = cartInfoId;
    }
}

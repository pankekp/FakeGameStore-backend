package pojo;

import java.util.List;

/**
 * @author panke
 * @date created in 2018/7/28 16:06
 */
public class Orders {

    private List<CartItem> cartItemList;
    private List<ContactInfo> contactInfoList;
    private OrdersTime ordersTime;

    public Orders() {
    }

    public Orders(List<CartItem> cartItemList, List<ContactInfo> contactInfoList, OrdersTime ordersTime) {
        this.cartItemList = cartItemList;
        this.contactInfoList = contactInfoList;
        this.ordersTime = ordersTime;
    }

    public List<CartItem> getCartItemList() {
        return cartItemList;
    }

    public void setCartItemList(List<CartItem> cartItemList) {
        this.cartItemList = cartItemList;
    }

    public List<ContactInfo> getContactInfoList() {
        return contactInfoList;
    }

    public void setContactInfoList(List<ContactInfo> contactInfoList) {
        this.contactInfoList = contactInfoList;
    }

    public OrdersTime getOrdersTime() {
        return ordersTime;
    }

    public void setOrdersTime(OrdersTime ordersTime) {
        this.ordersTime = ordersTime;
    }
}

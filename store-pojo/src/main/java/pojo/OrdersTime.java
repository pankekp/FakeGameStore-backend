package pojo;

import java.util.Date;

/**
 * @author panke
 * @date created in 2018/7/28 15:12
 */
public class OrdersTime {

    private Integer id;
    private Date orderTime;

    public OrdersTime() {
    }

    public OrdersTime(Integer id, Date orderTime) {
        this.id = id;
        this.orderTime = orderTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }
}

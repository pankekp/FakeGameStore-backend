package pojo;

/**
 * @author panke
 * @date created in 2018/7/8 21:30
 */
public class CartCollection {
    private Integer userId;
    private Integer goodId;
    private Integer goodNum;

    public CartCollection() {
    }

    public CartCollection(Integer userId, Integer goodId, Integer goodNum) {
        this.userId = userId;
        this.goodId = goodId;
        this.goodNum = goodNum;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getGoodId() {
        return goodId;
    }

    public void setGoodId(Integer goodId) {
        this.goodId = goodId;
    }

    public Integer getGoodNum() {
        return goodNum;
    }

    public void setGoodNum(Integer goodNum) {
        this.goodNum = goodNum;
    }

    @Override
    public String toString() {
        return "CartCollection{" +
                "userId=" + userId +
                ", goodId=" + goodId +
                ", goodNum=" + goodNum +
                '}';
    }
}

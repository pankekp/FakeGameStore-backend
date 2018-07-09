package pojo;

/**
 * @author panke
 * @date created in 2018/7/8 17:53
 */
public class CartInfo {
    private Integer id;
    private Integer goodId;
    private Integer goodNum;

    public CartInfo() {
    }

    public CartInfo(Integer id, Integer goodId, Integer goodNum) {
        this.id = id;
        this.goodId = goodId;
        this.goodNum = goodNum;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
}

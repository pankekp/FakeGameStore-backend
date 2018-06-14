package pojo;

/**
 * @author panke
 * @date created in 2018/6/10 18:51
 */
public class Game {

    private Integer id;
    private String name;
    private Integer stock;
    private Double price;
    private String cover;
    private String desc;

    public Game() {
    }

    public Game(Integer id, String name, Integer stock, Double price, String cover, String desc) {
        this.id = id;
        this.name = name;
        this.stock = stock;
        this.price = price;
        this.cover = cover;
        this.desc = desc;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}

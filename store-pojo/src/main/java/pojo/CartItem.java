package pojo;

/**
 * @author panke
 * @date created in 2018/7/15 15:01
 */
public class CartItem {

    private Game game;
    private Integer gameNum;
    private Integer itemId;

    public CartItem() {
    }

    public CartItem(Game game, Integer gameNum, Integer itemId) {
        this.game = game;
        this.gameNum = gameNum;
        this.itemId = itemId;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public Integer getGameNum() {
        return gameNum;
    }

    public void setGameNum(Integer gameNum) {
        this.gameNum = gameNum;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer id) {
        this.itemId = id;
    }
}

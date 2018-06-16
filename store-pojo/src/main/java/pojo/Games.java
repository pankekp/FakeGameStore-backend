package pojo;

import java.util.List;

/**
 * @author panke
 * @date created in 2018/6/16 22:57
 */
public class Games {

    private List<Game> games;
    private Integer total;

    public Games() {
    }

    public Games(List<Game> games, Integer total) {
        this.games = games;
        this.total = total;
    }

    public List<Game> getGames() {
        return games;
    }

    public void setGames(List<Game> games) {
        this.games = games;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }
}

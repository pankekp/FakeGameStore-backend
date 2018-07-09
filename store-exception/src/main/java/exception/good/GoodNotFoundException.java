package exception.good;

/**
 * @author panke
 * @date created in 2018/7/6 16:56
 */
public class GoodNotFoundException extends RuntimeException {

    private int gameId;

    public GoodNotFoundException(int gameId) {
        this.gameId = gameId;
    }

    public int getGameId() {
        return gameId;
    }
}

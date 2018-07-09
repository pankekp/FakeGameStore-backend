package mapper;

import pojo.Game;

import java.util.List;

/**
 * @author panke
 * @date created in 2018/6/12 21:50
 */
public interface GoodMapper {

    /**
     * 查询全部商品
     *
     * @return 商品列表
     */
    List<Game> findGames();

    /**
     * 统计商品数量
     *
     * @return 商品数量
     */
    int findGamesNum();

    /**
     * 查询指定id的商品
     *
     * @param gameId 商品id
     * @return 商品详情
     */
    Game findGame(int gameId);
}

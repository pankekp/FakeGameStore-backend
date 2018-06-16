package service;

import pojo.Games;

/**
 * @author panke
 * @date created in 2018/6/12 21:55
 */
public interface GoodService {

    /**
     * 分页查询商品
     *
     * @param pageNum  页码
     * @param pageSize 页面大小
     * @return 商品列表对象
     */
    Games getGamesByPage(int pageNum, int pageSize);

}

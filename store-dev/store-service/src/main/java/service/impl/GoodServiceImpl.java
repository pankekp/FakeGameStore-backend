package service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.Game;
import mapper.GoodMapper;
import service.GoodService;

import java.util.List;

/**
 * @author panke
 * @date created in 2018/6/12 21:58
 */

@Service
public class GoodServiceImpl implements GoodService {

    private GoodMapper goodMapper;

    @Autowired
    public GoodServiceImpl(GoodMapper goodMapper) {
        this.goodMapper = goodMapper;
    }

    @Override
    public List<Game> getGamesByPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Game> games = goodMapper.findGames();
        return new PageInfo<>(games).getList();
    }
}

package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pojo.Game;
import service.GoodService;

import java.util.List;

/**
 * @author panke
 * @date created in 2018/6/10 19:39
 */

@RestController
public class GoodController {

    private GoodService goodService;

    @Autowired
    public GoodController(GoodService goodService) {
        this.goodService = goodService;
    }

    @GetMapping(value = {"/findGames/{pageNum}/{pageSize}"})
    public List<Game> getGoodsList(@PathVariable int pageNum, @PathVariable int pageSize) {
        return goodService.getGamesByPage(pageNum, pageSize);
    }

}

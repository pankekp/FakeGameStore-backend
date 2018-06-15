package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pojo.Game;
import pojo.Page;
import service.GoodService;

import java.util.List;

/**
 * @author panke
 * @date created in 2018/6/10 19:39
 */

@CrossOrigin(origins = "*")
@RestController
public class GoodController {

    private GoodService goodService;

    @Autowired
    public GoodController(GoodService goodService) {
        this.goodService = goodService;
    }

    @GetMapping(value = {"/findGames"})
    public List<Game> getGoodsList(Page page) {
        return goodService.getGamesByPage(page.getPageNum(), page.getPageSize());
    }

}

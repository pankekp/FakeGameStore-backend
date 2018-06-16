package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pojo.Games;
import pojo.Page;
import service.GoodService;

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
    public Games getGoodsList(Page page) {
        return goodService.getGamesByPage(page.getPageNum(), page.getPageSize());
    }

}

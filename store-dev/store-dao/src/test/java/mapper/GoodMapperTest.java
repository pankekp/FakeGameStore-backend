package mapper;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import config.DaoConfig;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pojo.Game;

import java.util.List;

/**
 * @author panke
 * @date created in 2018/6/14 22:47
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DaoConfig.class)
public class GoodMapperTest {

    @Autowired
    private GoodMapper goodMapper;

    @Test
    public void testFindGames() {
        PageHelper.startPage(1, 8);
        List<Game> games = goodMapper.findGames();
        PageInfo<Game> gamePageInfo = new PageInfo<>(games);
        Assert.assertNotNull(gamePageInfo.getList());
        for (Game game : gamePageInfo.getList()) {
            System.out.println(game);
        }
    }

    @Test
    public void testFindGamesNum() {
        int num = goodMapper.findGamesNum();
        Assert.assertTrue(num == 20);
    }

}

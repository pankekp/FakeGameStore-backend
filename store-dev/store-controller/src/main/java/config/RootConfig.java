package config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author panke
 * @date created in 2018/6/10 19:01
 */

@Configuration
@Import({ServiceConfig.class, DaoConfig.class})
public class RootConfig {
}

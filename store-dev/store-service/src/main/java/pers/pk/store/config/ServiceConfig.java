package pers.pk.store.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author panke
 * @date created in 2018/6/10 19:09
 */

@Configuration
@Import({DaoConfig.class})
@ComponentScan(basePackageClasses = {ServiceConfig.class})
public class ServiceConfig {
}

package pers.pk.store.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import pers.pk.store.mapper.Mapper;

/**
 * @author panke
 * @date created in 2018/6/10 19:19
 */

@Configuration
@ComponentScan(basePackageClasses = Mapper.class)
public class DaoConfig {
}

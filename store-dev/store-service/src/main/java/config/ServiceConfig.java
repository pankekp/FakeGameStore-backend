package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import service.Service;

/**
 * @author panke
 * @date created in 2018/6/10 19:09
 */

@Configuration
@ComponentScan(basePackageClasses = {Service.class})
public class ServiceConfig {
}

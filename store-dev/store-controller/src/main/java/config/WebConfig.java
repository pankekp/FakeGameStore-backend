package config;

import controller.Controller;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @author panke
 * @date created in 2018/6/10 19:01
 */

@Configuration
@EnableWebMvc
@ComponentScan(basePackageClasses = {Controller.class})
public class WebConfig{
}

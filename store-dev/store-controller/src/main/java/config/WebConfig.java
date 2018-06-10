package config;

import controller.Controller;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @author panke
 * @date created in 2018/6/10 19:01
 */

@Configurable
@EnableWebMvc
@ComponentScan(basePackageClasses = {Controller.class})
public class WebConfig{
}

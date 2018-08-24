package cn.dectfix.conf;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Created by huqian on 2017/12/6.
 */
@Configurable
@EnableWebMvc
@ComponentScan("cn.dectfix.controller")
public class AppConfig implements WebMvcConfigurer {

}

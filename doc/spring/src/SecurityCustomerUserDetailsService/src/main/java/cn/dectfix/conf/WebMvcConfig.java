package cn.dectfix.conf;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Created by huqian on 2018/3/9.
 */
@Configuration
@EnableWebMvc
@ComponentScan("cn.dectfix")
public class WebMvcConfig implements WebMvcConfigurer {
}

package cn.dectfix.conf;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Created by huqian on 2017/12/6.
 */
@Configuration
@EnableWebMvc
@ComponentScan(value = "cn.dectfix")
public class SpringMVCConfig implements WebMvcConfigurer {
}

package cn.dectfix.conf;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

/**
 * Created by huqian on 2017/12/6.
 */
/*
 *
 * If we were using Spring elsewhere in our application
 * we probably already had a WebApplicationInitializer
 * that is loading our Spring Configuration. If we use
 * the previous configuration we would get an error.
 * Instead, we should register Spring Security with
 * the existing ApplicationContext.
 *
 */
public class SecurityWebApplicationInitializer extends AbstractSecurityWebApplicationInitializer {

}

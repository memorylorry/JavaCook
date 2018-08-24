package cn.dectfix.conf;

import org.springframework.lang.Nullable;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * Created by huqian on 2017/12/17.
 * Load the configurations
 */
public class WebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Nullable
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{DataSourceConfig.class,WebSecurityConfig.class,WebMvcConfig.class};
    }

    @Nullable
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{};
    }

    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}

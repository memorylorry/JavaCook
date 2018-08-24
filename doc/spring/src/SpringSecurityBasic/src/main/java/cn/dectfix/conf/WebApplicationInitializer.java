package cn.dectfix.conf;

import org.springframework.lang.Nullable;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * Created by huqian on 2017/12/6.
 */
public class WebApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Nullable
    protected Class<?>[] getRootConfigClasses() {
        //Load Security configuration
        return new Class[]{WebSecurityConfig.class};
    }

    @Nullable
    protected Class<?>[] getServletConfigClasses() {
        //Load SpringMVC configuration
        return new Class[]{SpringMVCConfig.class};
    }

    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}

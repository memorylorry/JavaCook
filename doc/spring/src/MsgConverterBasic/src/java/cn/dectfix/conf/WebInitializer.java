package cn.dectfix.conf;

import org.springframework.lang.Nullable;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * Created by huqian on 2017/12/12.
 */
public class WebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Nullable
    protected Class<?>[] getRootConfigClasses() {
        return new Class[0];
    }

    @Nullable
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{MVCConfig.class};
    }

    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}

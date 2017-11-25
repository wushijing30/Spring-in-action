package spittr.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import spittr.web.WebConfig;

/**
 * Created by wusj on 2017/11/25.
 */
public class SpitterWebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[] {RootConfig.class};
    }

    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[] {WebConfig.class};
    }

    protected String[] getServletMappings() {
        return new String[] {"/"};
    }
}

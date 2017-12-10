package spittr.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Import;
import org.springframework.core.type.filter.RegexPatternTypeFilter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import spittr.web.WebConfig;

import java.util.regex.Pattern;

/**
 * Created by wusj on 2017/11/25.
 */
@Configuration
@Import(DataConfig.class)
@ComponentScan(basePackages = {"spittr"},
                excludeFilters = {@ComponentScan.Filter(type=FilterType.CUSTOM, value=RootConfig.WebPackage.class)})
public class RootConfig {
    public static class WebPackage extends RegexPatternTypeFilter {
        public WebPackage(){
            super(Pattern.compile("spittr\\.web"));
        }
    }
}

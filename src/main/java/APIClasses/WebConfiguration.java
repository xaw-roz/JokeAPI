package APIClasses;

/**
 * Created by rocks on 6/8/2017.
 */


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.resourceresolver.SpringResourceResourceResolver;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.StandardTemplateModeHandlers;
import org.thymeleaf.templateresolver.TemplateResolver;


/*Class to enable html5 support to thymeleaf8*/
    @EnableWebMvc
    @Configuration
    public class WebConfiguration extends WebMvcConfigurerAdapter {

        @Bean
        public TemplateResolver templateResolver() {
            TemplateResolver resolver = new TemplateResolver();
            resolver.setResourceResolver(thymeleafResourceResolver());
            resolver.setPrefix("classpath:/templates/");
            resolver.setSuffix(".html");
            resolver.setTemplateMode(StandardTemplateModeHandlers.LEGACYHTML5.getTemplateModeName());
            resolver.setCacheable(false);
            resolver.setCharacterEncoding("UTF-8");
            return resolver;
        }

        @Bean
        public SpringResourceResourceResolver thymeleafResourceResolver() {
            return new SpringResourceResourceResolver();
        }

        public SpringTemplateEngine templateEngine() {
            SpringTemplateEngine engine = new SpringTemplateEngine();
            engine.setTemplateResolver(templateResolver());
            return engine;
        }

        @Bean
        public ViewResolver viewResolver() {
            ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
            viewResolver.setTemplateEngine(templateEngine());
            viewResolver.setOrder(1);
            viewResolver.setViewNames(new String[] { "*" });
            viewResolver.setCache(false);
            return viewResolver;
        }

    }


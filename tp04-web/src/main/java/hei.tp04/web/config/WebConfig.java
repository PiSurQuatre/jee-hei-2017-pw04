package hei.tp04.web.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.velocity.VelocityConfigurer;
import org.springframework.web.servlet.view.velocity.VelocityViewResolver;

@EnableWebMvc   // Permet de démarrer Spring MVC
@Configuration  // Permet de déclarer des Beans
@ComponentScan(basePackages = {"hei.tp04.web.controller"})  // Permet de scruter hei.tp04.web.controller
public class WebConfig extends WebMvcConfigurerAdapter{

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry)
    {
        registry
                .addResourceHandler("/webjars/**")
                .addResourceLocations("/webjars/");
    }

    @Bean
    public VelocityConfigurer velocityConfig() {
        VelocityConfigurer velocityConfigurer = new VelocityConfigurer();
        velocityConfigurer.setResourceLoaderPath("/WEB-INF/velocity/");

        return velocityConfigurer;
    }

    @Bean
    public ViewResolver VelocityViewResolver()
    {
        VelocityViewResolver viewResolver= new VelocityViewResolver();
        viewResolver.setPrefix("");
        viewResolver.setSuffix(".vm");

        return viewResolver;
    }

}

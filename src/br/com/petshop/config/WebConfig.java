package br.com.Petshop.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc 
@ComponentScan(basePackages = {"br.com.Petshop.controller"})
public class WebConfig{
	// The Environment class serves as the property holder
	   // and stores all the properties loaded by the @PropertySource
	   @Autowired
//	   private Environment env;
	 
	   @Bean(name = "viewResolver")
	   public InternalResourceViewResolver getViewResolver() {
		   InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		      resolver.setViewClass(JstlView.class);
		      resolver.setPrefix("/WEB-INF/views/");
		      resolver.setSuffix(".jsp");
		      return resolver;
	   }
//	

}

package br.com.petshop.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import br.com.petshop.interceptor.LoggingInterceptor;

@Configuration
@EnableWebMvc 
@ComponentScan(basePackages = {"br.com.petshop.controller"})
public class WebConfig extends WebMvcConfigurerAdapter{ 
	   @Bean(name = "viewResolver")
	   public InternalResourceViewResolver getViewResolver() {
		   InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		      resolver.setViewClass(JstlView.class);
		      resolver.setPrefix("/WEB-INF/views/");
		      resolver.setSuffix(".jsp");
		      return resolver;
	   }
	   
	   @Override
	   public void addInterceptors(InterceptorRegistry registry) {
		   System.out.println("passou");
	       registry.addInterceptor(new LoggingInterceptor());
//	       registry.addInterceptor((HandlerInterceptor) new TransactionInterceptor()).addPathPatterns("/person/save/*");
	   } 
//	

}

package com.bdqn.agentSystem.config;

import javax.annotation.Resource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.ResourceUtils;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.bdqn.agentSystem.interceptors.SysInit;
import com.bdqn.agentSystem.service.FunctionService;
import com.bdqn.agentSystem.service.PremissionServiceImpl;
import com.bdqn.agentSystem.service.RoleService;

@Configuration
@EnableWebMvc
public class WebConfig extends WebMvcConfigurerAdapter{
	
	
	public void addResourceHandlers(ResourceHandlerRegistry registry) {  
		  
        registry.addResourceHandler("/templates/**").addResourceLocations(ResourceUtils.CLASSPATH_URL_PREFIX+"/templates/");  
        registry.addResourceHandler("/static/**").addResourceLocations(ResourceUtils.CLASSPATH_URL_PREFIX+"/static/");  
        super.addResourceHandlers(registry);  
    }
	
	
	@Bean
	public SysInit sysInit() {
		return new SysInit();
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(sysInit()).addPathPatterns("/**")
		.excludePathPatterns("/login.action","/","/validateLoginUser.action");
		super.addInterceptors(registry);
	}
	
	
	

}

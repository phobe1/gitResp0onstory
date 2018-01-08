package com.bdqn.agentSystem.config;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.util.ResourceUtils;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
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
	
    /**
     * 利用fastjson替换掉jackson，且解决中文乱码问题
     * @param converters
     */
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
    	   StringHttpMessageConverter stringConverter = new StringHttpMessageConverter();
    	   List<MediaType> mediaTypes = new ArrayList<>();
    	    mediaTypes.add(MediaType.APPLICATION_JSON_UTF8);
    	    stringConverter.setSupportedMediaTypes(mediaTypes);
        FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        fastJsonConfig.setSerializerFeatures(SerializerFeature.WriteDateUseDateFormat);
        //处理中文乱码问题
        List<MediaType> fastMediaTypes = new ArrayList<>();
        fastMediaTypes.add(MediaType.APPLICATION_JSON_UTF8);
        fastMediaTypes.add(MediaType.TEXT_HTML);
        fastConverter.setSupportedMediaTypes(fastMediaTypes);
        fastConverter.setFastJsonConfig(fastJsonConfig);
        converters.add(stringConverter);
        converters.add(fastConverter);
    }
	
	
	

}

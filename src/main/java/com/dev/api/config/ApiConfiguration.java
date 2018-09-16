package com.dev.api.config;

import java.util.List;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.AbstractJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import com.dev.api.interceptor.GlobalInterceptor;
import com.dev.api.util.JsonUtils;
import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
public class ApiConfiguration extends WebMvcConfigurationSupport {

	@Override
    public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new GlobalInterceptor()).addPathPatterns("/*/**")
			.excludePathPatterns("/static/**");
    }
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
	}
	
	@Override
	protected void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
		converters
			.stream()
			.filter((c) -> c instanceof AbstractJackson2HttpMessageConverter)
			.forEach((c) -> {
				ObjectMapper mapper = JsonUtils.getMapper();
				((AbstractJackson2HttpMessageConverter)c).setObjectMapper(mapper);
		});
	}
	
}

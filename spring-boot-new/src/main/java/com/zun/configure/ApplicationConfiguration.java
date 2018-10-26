package com.zun.configure;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.zun.filter.TestFilter;
import com.zun.interceptor.MyInterceptor;
import com.zun.properties.BlogProperties;

@SpringBootApplication(scanBasePackages = {"com.zun"})
@MapperScan("com.zun.mapper")
public class ApplicationConfiguration {
	
	/**
	 * 实现方式一
	 * 注册过滤器
	 * @return
	 */
	@Bean
	public FilterRegistrationBean filterRegistrationBean(){
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        List<String> urlPatterns = new ArrayList<String>();
        TestFilter testFilter = new TestFilter();   //new过滤器
        urlPatterns.add("/getUser");      //指定需要过滤的url
        filterRegistrationBean.setFilter(testFilter);       //set
        filterRegistrationBean.setUrlPatterns(urlPatterns);     //set

        return filterRegistrationBean;
    } 
	
	
	//mvc控制器
    @Configuration
    static class WebMvcConfigurer extends WebMvcConfigurerAdapter{
        //增加拦截器
        public void addInterceptors(InterceptorRegistry registry){
            registry.addInterceptor(new MyInterceptor())    //指定拦截器类
                    .addPathPatterns("/getUser");        //指定该类拦截的url
        }
    }

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(ApplicationConfiguration.class, args);
		BlogProperties bean = context.getBean(BlogProperties.class);
		System.out.println(bean);
	}
}

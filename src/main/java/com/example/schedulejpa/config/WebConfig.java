package com.example.schedulejpa.config;

import com.example.schedulejpa.filter.LoginFilter;
import jakarta.servlet.Filter;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {


  @Bean
  public FilterRegistrationBean loginFilter(){
    FilterRegistrationBean<Filter> filterRegistrationBean = new FilterRegistrationBean<>();

    filterRegistrationBean.setFilter(new LoginFilter());

    filterRegistrationBean.setOrder(1);

    filterRegistrationBean.addUrlPatterns("/*");

    return filterRegistrationBean;
  }

}


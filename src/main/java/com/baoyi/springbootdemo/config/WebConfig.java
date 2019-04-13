package com.baoyi.springbootdemo.config;

import com.baoyi.springbootdemo.web.UserModelMethodArgumentResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(userModelMethodArgumentResolver());

    }

    @Bean
    public UserModelMethodArgumentResolver userModelMethodArgumentResolver() {
        return new UserModelMethodArgumentResolver();
    }

}

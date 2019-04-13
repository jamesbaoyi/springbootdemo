package com.baoyi.springbootdemo.web;


import com.baoyi.springbootdemo.annotation.UserModel;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

public class UserModelMethodArgumentResolver implements HandlerMethodArgumentResolver {

    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {
        return methodParameter.getParameterType().isAssignableFrom(com.baoyi.springbootdemo.model.UserModel.class)
                && methodParameter.hasParameterAnnotation(UserModel.class);
    }

    @Override
    public Object resolveArgument(MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer,
                                  NativeWebRequest nativeWebRequest, WebDataBinderFactory webDataBinderFactory) {

        com.baoyi.springbootdemo.model.UserModel userModel = new com.baoyi.springbootdemo.model.UserModel();
        userModel.setDeptName("一组");
        userModel.setUserName("祁保义");
        return userModel;
    }
}

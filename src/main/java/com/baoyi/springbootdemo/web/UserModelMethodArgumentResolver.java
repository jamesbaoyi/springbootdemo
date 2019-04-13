package com.baoyi.springbootdemo.web;


import com.baoyi.springbootdemo.annotation.CurrentOperator;
import com.baoyi.springbootdemo.model.UserModel;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

public class UserModelMethodArgumentResolver implements HandlerMethodArgumentResolver {

    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {
        return methodParameter.getParameterType().isAssignableFrom(UserModel.class)
                && methodParameter.hasParameterAnnotation(CurrentOperator.class);
    }

    @Override
    public Object resolveArgument(MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer,
                                  NativeWebRequest nativeWebRequest, WebDataBinderFactory webDataBinderFactory) {

        UserModel userModel = new UserModel();
        userModel.setDeptName("一组");
        userModel.setUserName("祁保义");
        return userModel;
    }

}

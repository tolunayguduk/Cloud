package com.tolunayguduk.interceptor;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

public class errorInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HandlerMethod hm = (HandlerMethod) handler;
        Method method = hm.getMethod();
        request.setAttribute("startTime", System.currentTimeMillis());
        request.setAttribute("method", method.getName());




        return super.preHandle(request,response,handler);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        Long starTime = Long.parseLong(request.getAttribute("startTime").toString());
        Long endTime = System.currentTimeMillis();
        System.out.println(request.getAttribute("method") + " isteği " + (endTime-starTime) + " ms. sürede işletildi");

        super.afterCompletion(request, response, handler, ex);
    }
}

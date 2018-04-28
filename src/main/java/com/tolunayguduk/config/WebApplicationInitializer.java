package com.tolunayguduk.config;

import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class WebApplicationInitializer implements org.springframework.web.WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        WebApplicationContext context =getContext();
        servletContext.addListener(new ContextLoaderListener(context));
        ServletRegistration.Dynamic MainDispatcher = servletContext.addServlet("MainDispatcher", new DispatcherServlet(context));
        MainDispatcher.setLoadOnStartup(1);
        MainDispatcher.addMapping("/");




        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding("UTF-8");
        characterEncodingFilter.setForceEncoding(true);
        servletContext.addFilter("characterEncodingFilter", characterEncodingFilter).addMappingForUrlPatterns(null, false, "/*");
    }

    private AnnotationConfigWebApplicationContext getContext() {
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.setConfigLocation("com.tolunayguduk.config");
        return context;
    }
}

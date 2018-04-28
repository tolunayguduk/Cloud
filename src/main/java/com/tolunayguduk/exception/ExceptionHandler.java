package com.tolunayguduk.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ExceptionHandler {
    @org.springframework.web.bind.annotation.ExceptionHandler(value = {NullPointerException.class, ArithmeticException.class})
    public ModelAndView handleException(HttpServletRequest request, Exception ex) {
        System.err.println(request.getRequestURL() + " isteği gerçekleştirilirken bir exception oluştu. Exception mesajı: " + ex.getLocalizedMessage());
        return new ModelAndView("error");
    }
}

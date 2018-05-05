package com.tolunayguduk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller
public class AnasayfaController {

    @RequestMapping(value = {"/","/anasayfa","/home"}, method = RequestMethod.GET)
    public String anasayfa(){

        return "anasayfa";
    }
}

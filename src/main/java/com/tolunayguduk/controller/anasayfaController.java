package com.tolunayguduk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.Locale;


@Controller
public class anasayfaController {

    @Autowired
    MessageSource messageSource;
    @RequestMapping(value = {"/","/anasayfa","/home"}, method = RequestMethod.GET)
    public String anasayfa(Locale locale, Model model){
        String welcome = messageSource.getMessage("kisiKarsilama", new Object[]{"Tolunay Guduk"}, locale);
        model.addAttribute("kisiKarsilama",welcome );
        return "anasayfa";
    }
}

package com.tolunayguduk.controller;

import com.tolunayguduk.model.User;
import com.tolunayguduk.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;
import java.util.Locale;


@Controller
public class loginController {
    @RequestMapping(value = {"/login","/giris"}, method = RequestMethod.GET)
    public String login(){
        return "login";
    }
//**********************************************************************************
// **********************************************************************************
// **********************************************************************************

    @Autowired
    UserService userService;
    @Autowired
    MessageSource messageSource;

    @RequestMapping(value = "/getLogin.ajax")
    public String getLogin(@RequestParam String username,
                                        @RequestParam String password,
                                        Locale locale,
                                        Model model) {
        int index = username.length();
        String uzanti = username.substring(index-4,index);
        List list = null;
        String result = "error";

        if(uzanti.equals(".com")){
            list = userService.isExistSearchUserByEmail(username, password);
        }else{
            list = userService.isExistSearchUserByUsername(username, password);
        }
        if(list.size()==1){
            result = "dashboard";
        }

        User user = (User) list.get(0);

        String nameSurname = user.getName().toUpperCase() + " " + user.getSurname().toUpperCase();

        String name = messageSource.getMessage("name", new Object[]{nameSurname}, locale);
        String username2 = messageSource.getMessage("username", new Object[]{user.getUsername()}, locale);
        model.addAttribute("name",name );
        model.addAttribute("username",username2 );


        return result;
    }
}

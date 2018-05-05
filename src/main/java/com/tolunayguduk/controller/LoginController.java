package com.tolunayguduk.controller;

import com.tolunayguduk.model.User;
import com.tolunayguduk.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class LoginController {

    @Autowired
    UserService userService;

    @RequestMapping(value = {"/login"}, method = RequestMethod.GET)
    public String login(){
        return "login";
    }
    @RequestMapping(value = {"/getLogin.ajax"}, method = RequestMethod.POST)
    public String getLogin(@RequestParam String username,
                           @RequestParam String password){
        int index = username.length();
        String uzanti = username.substring(index-4,index);
        List list = null;
        String result = "error";
        if(uzanti.equals(".com")){ list = userService.isExistSearchUserByEmail(username, password);
        }else{ list = userService.isExistSearchUserByUsername(username, password); }
        if(list.size()==1){ result = "dashboard"; }
        return result;
    }
}

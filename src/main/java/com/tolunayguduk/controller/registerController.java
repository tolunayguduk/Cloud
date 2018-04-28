package com.tolunayguduk.controller;


import com.tolunayguduk.model.User;
import com.tolunayguduk.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;


@Controller
public class registerController {


    @Autowired
    UserService userService;

    @RequestMapping(value = {"/register","/kayit"}, method = RequestMethod.GET)
    public String register(){
        return "register";
    }





    @RequestMapping(value = {"/register.ajax","/kayit.ajax"})
    public @ResponseBody String getRegister(@RequestParam String name,
                                            @RequestParam String surname,
                                            @RequestParam String username,
                                            @RequestParam String email,
                                            @RequestParam String password){

        User user = new User();
        Date date = new Date();
        Boolean result = false;
        try {
            user.setName(name);
            user.setSurname(surname);
            user.setUsername(username);
            user.setEmail(email);
            user.setPassword(password);
            user.setSign_up_date(date);
            user.setConfirmation(true);
            userService.insertUser(user);

            result = true;
        }catch (Exception e){
            System.out.println("ERROR = " + e.getMessage());
            result = false;
        }
        return result.toString();
    }

}

package com.tolunayguduk.controller;

import com.tolunayguduk.model.User;
import com.tolunayguduk.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;

@Controller
public class RegisterController {


    @Autowired
    UserService userService;

    @RequestMapping(value = {"/register"}, method = RequestMethod.GET)
    public String register(){

        return "register";
    }

    @RequestMapping(value = {"/register.ajax"},method = RequestMethod.POST)
    public String getRegister(@RequestParam String name,
                              @RequestParam String surname,
                              @RequestParam String username,
                              @RequestParam String password,
                              @RequestParam String email){
        User user = new User();
        Date date = new Date();
        String result = "error";
        try {
            user.setName(name);
            user.setSurname(surname);
            user.setUsername(username);
            user.setEmail(email);
            user.setPassword(password);
            user.setSign_up_date(date);
            user.setConfirmation(true);

            Path currentRelativePath = Paths.get("");
            String s = currentRelativePath.toAbsolutePath().toString();

            if(new File(s + "\\"+ "cloud\\" + username + "_" + email).mkdir()){
                userService.insertUser(user);
                result = "login";
            }
        }catch (Exception e){
            System.out.println("ERROR = " + e.getMessage());
            result = "error";
        }
        return result;
    }
}

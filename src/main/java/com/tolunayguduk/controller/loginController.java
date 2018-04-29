package com.tolunayguduk.controller;

import com.tolunayguduk.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;


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
    @RequestMapping(value = "/getLogin.ajax")
    public @ResponseBody String getLogin(@RequestParam String username,
                                        @RequestParam String password) {

        int index = username.length();
        String uzanti = username.substring(index-4,index);
        List list = null;
        Boolean result = false;

        if(uzanti.equals(".com")){
            list = userService.isExistSearchUserByEmail(username, password);
        }else{
            list = userService.isExistSearchUserByUsername(username, password);
        }
        if(list.size()==1){
            result = true;
        }
        return result.toString();
    }
}

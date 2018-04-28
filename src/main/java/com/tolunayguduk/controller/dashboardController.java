package com.tolunayguduk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
public class dashboardController {
    @RequestMapping(value = {"/dashboard","/yonetimPaneli"}, method = RequestMethod.GET)
    public String dashboard(){
        return "dashboard";
    }


    @RequestMapping(value = "/createFolder.ajax", method = RequestMethod.GET)
    public Boolean createFolder(HttpServletRequest request, HttpServletResponse response) throws IOException {

        /*Path path = Paths.get("'\'cloud'\'");*/
        //if directory exists?
        String path = (String) request.getHeader("Yol");
        String folName = (String) request.getHeader("Ad");
        String Paths = path + "/" + folName;


        
        /*if (!Files.exists(Paths.get(Paths))) {*/
        File f = new File(Paths);
        f.createNewFile();

        System.out.println("Dosya başarı ile oluşturuldu " + path + folName);
        return true;
    }
       /* else return false;*/

    }





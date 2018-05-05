package com.tolunayguduk.controller;

import com.tolunayguduk.dao.interfaces.FolderDAO;
import com.tolunayguduk.fuctions.Directory;
import com.tolunayguduk.fuctions.File;
import com.tolunayguduk.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.Locale;

@Controller
public class DashboardController {

    @Autowired
    UserService userService;
    @Autowired
    FolderDAO folderDAO;

    @RequestMapping(value = {"/dashboard"}, method = RequestMethod.GET)
    public String dashboard(){

        return "dashboard";
    }

    @RequestMapping(value = {"/dashboard/path"}, method = RequestMethod.GET)
    public String iterator(@RequestParam("username") String username,
                           @RequestParam("path") String path,
                           Model model,
                           Locale locale){

        model.addAttribute("folderList",Directory.repositoryIterator(userService,username,path));
        model.addAttribute("path", path);

        return "dashboard";
    }
    @RequestMapping(value = {"/dashboard/deleteDirectory"}, method = RequestMethod.GET)
    public String deleteDirectory(@RequestParam("username") String username,
                           @RequestParam("path") String path,
                           @RequestParam("fileName") String fileName,
                           Model model){

        String result = "error";
        if(Boolean.parseBoolean(Directory.deleteDirectory(userService,fileName,path,username))){
            model.addAttribute("folderList",Directory.repositoryIterator(userService,username,path));
            model.addAttribute("path", path);
            result = "dashboard";
        }
        return result;
    }
    @RequestMapping(value = {"/dashboard/deleteFile"}, method = RequestMethod.GET)
    public String deleteFile(@RequestParam("username") String username,
                         @RequestParam("path") String path,
                         @RequestParam("fileName") String fileName,
                         Model model){

        String result = "error";
        if(Boolean.parseBoolean(File.deleteFile(userService,fileName,path,username))){
            model.addAttribute("folderList",Directory.repositoryIterator(userService,username,path));
            model.addAttribute("path", path);
            result = "dashboard";
        }
        return result;
    }
    @RequestMapping(value = {"/dashboard/rename"}, method = RequestMethod.GET)
    public String rename(@RequestParam("username") String username,
                             @RequestParam("path") String path,
                             @RequestParam("fileName") String fileName,
                             @RequestParam("newName") String newName,
                             Model model){

        String result = "error";
        if(Boolean.parseBoolean(File.renameFile(userService,fileName,path,username, newName))){
            model.addAttribute("folderList",Directory.repositoryIterator(userService,username,path));
            model.addAttribute("path", path);
            result = "dashboard";
        }
        return result;
    }
    @RequestMapping(value = {"/dashboard/createFile"}, method = RequestMethod.GET)
    public String createFile(@RequestParam("username") String username,
                         @RequestParam("path") String path,
                         @RequestParam("name") String name,
                         Model model){

        String result = "error";
        if(Boolean.parseBoolean(File.createFile(userService,name,path,username))){
            model.addAttribute("folderList",Directory.repositoryIterator(userService,username,path));
            model.addAttribute("path", path);
            result = "dashboard";
        }
        return result;
    }
    @RequestMapping(value = {"/dashboard/createDirectory"}, method = RequestMethod.GET)
    public String createDirectory(@RequestParam("username") String username,
                             @RequestParam("path") String path,
                             @RequestParam("name") String name,
                             Model model){

        String result = "error";
        if(Boolean.parseBoolean(Directory.createDirectory(userService,name,path,username))){
            model.addAttribute("folderList",Directory.repositoryIterator(userService,username,path));
            model.addAttribute("path", path);
            result = "dashboard";
        }
        return result;
    }
}

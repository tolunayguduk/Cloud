package com.tolunayguduk.controller;

import com.tolunayguduk.fuctions.Directory;
import com.tolunayguduk.model.User;
import com.tolunayguduk.service.interfaces.FolderService;
import com.tolunayguduk.service.interfaces.UserService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class dashboardController {

    @Autowired
    FolderService folderService;
    @Autowired
    UserService userService;

    @RequestMapping(value = {"/dashboard"})
    public String dashboard() {
       return "dashboard";
    }
//**********************************************************************************
@RequestMapping(value = "/deleteFolder.ajax")
public @ResponseBody String deleteFolder(@RequestParam String fileName,
                                         @RequestParam String path,
                                         @RequestParam String username) {
    return Directory.deleteDirectory(userService,fileName,path,username);
}
//**********************************************************************************
    @RequestMapping(value = "/createFolder.ajax")
    public @ResponseBody String createFolder(@RequestParam String fileName,
                                           @RequestParam String path,
                                           @RequestParam String username) {
        return Directory.createDirectory(userService,fileName,path,username);
    }
//**********************************************************************************
    @RequestMapping(value = {"/dashboard/repositoryIterator.ajax"})
    public @ResponseBody String dashboard(String username,String path) {
        return Directory.repositoryIterator(userService,username,path);
    }
}



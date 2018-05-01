package com.tolunayguduk.controller;

import com.tolunayguduk.fuctions.Directory;
import com.tolunayguduk.fuctions.File;
import com.tolunayguduk.service.interfaces.FolderService;
import com.tolunayguduk.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Locale;

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
    public @ResponseBody String repositoryIterator(@RequestParam String username,
                                                   @RequestParam String path,
                                                   HttpServletRequest httpServletRequest,
                                                   HttpServletResponse httpServletResponse) {
       return Directory.repositoryIterator(userService,username,path);
    }
//**********************************************************************************
    @RequestMapping(value = {"/dashboard/renameFolder.ajax"})
    public @ResponseBody String renameFolder(@RequestParam String username,
                                        @RequestParam String oldName,
                                          @RequestParam String path,
                                          @RequestParam String newName) {
        return Directory.renameDirectory(userService,oldName,path,username,newName);
    }
//**********************************************************************************
    @RequestMapping(value = {"/dashboard/moveFolderTo.ajax"})
    public @ResponseBody String moveFolderTo() {
        return "HENUZ BAKIM ASAMASINDA";
    }
//**********************************************************************************
    @RequestMapping(value = {"/dashboard/createFile.ajax"})
    public @ResponseBody String createFile(@RequestParam String fileName,
                                           @RequestParam String path,
                                           @RequestParam String username,
                                             @RequestParam String suffix) {
        return File.createFile(userService,fileName,path,username,suffix);
    }
//**********************************************************************************
    @RequestMapping(value = {"/dashboard/deleteFile.ajax"})
    public @ResponseBody String deleteFile(@RequestParam String fileName,
                                           @RequestParam String path,
                                           @RequestParam String username,
                                           @RequestParam String suffix) {
        return File.deleteFile(userService,fileName,path,username,suffix);
    }
    @RequestMapping(value = {"/dashboard/renameFile.ajax"})
    public @ResponseBody String renameFile(@RequestParam String fileName,
                                           @RequestParam String path,
                                           @RequestParam String newName,
                                           @RequestParam String username,
                                           @RequestParam String suffix) {
        return File.renameFile(userService,fileName,path,username,newName,suffix);
    }
}



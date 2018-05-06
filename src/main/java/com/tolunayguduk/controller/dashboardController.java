package com.tolunayguduk.controller;

import com.tolunayguduk.functions.Directory;
import com.tolunayguduk.model.File;
import com.tolunayguduk.model.Folder;
import com.tolunayguduk.model.User;
import com.tolunayguduk.service.interfaces.FileService;
import com.tolunayguduk.service.interfaces.FolderService;
import com.tolunayguduk.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;
import java.util.Locale;

@Controller
public class DashboardController {

    @Autowired
    UserService userService;
    @Autowired
    FileService fileService;
    @Autowired
    FolderService folderService;

    @RequestMapping(value = {"/dashboard"}, method = RequestMethod.GET)
    public String dashboard(){

        return "dashboard";
    }

    @RequestMapping(value = {"/dashboard/path"}, method = RequestMethod.GET)
    public String iterator(@RequestParam("username") String username, @RequestParam("path") String path, Model model, Locale locale){

        model.addAttribute("folderList",Directory.repositoryIterator(userService,username,path));
        model.addAttribute("path", path);

        return "dashboard";
    }

    @RequestMapping(value = {"/dashboard/deleteDirectory"}, method = RequestMethod.GET)
    public String deleteDirectory(@RequestParam("username") String username, @RequestParam("path") String path, @RequestParam("fileName") String fileName, Model model){

        Folder folder = new Folder();
        folder.setName(fileName);
        folder.setOwnerID(userService.isExistSearchUserByUsername(username).get(0).getUserID());
        folder.setPath(path);
        String result = "error";
        if(Boolean.parseBoolean(Directory.deleteDirectory(userService,fileName,path,username))){
            model.addAttribute("folderList",Directory.repositoryIterator(userService,username,path));
            model.addAttribute("path", path);
            folderService.deleteFolder(folder);
            result = "dashboard";
        }
        return result;
    }

    @RequestMapping(value = {"/dashboard/deleteFile"}, method = RequestMethod.GET)
    public String deleteFile(@RequestParam("username") String username, @RequestParam("path") String path, @RequestParam("fileName") String fileName, Model model){

        File file = new File();
        file.setName(fileName);
        file.setOwnerID(userService.isExistSearchUserByUsername(username).get(0).getUserID());
        file.setPath(path);

        String result = "error";
        if(Boolean.parseBoolean(com.tolunayguduk.functions.File.deleteFile(userService,fileName,path,username))){
            model.addAttribute("folderList",Directory.repositoryIterator(userService,username,path));
            model.addAttribute("path", path);
            fileService.deleteFile(file);
            result = "dashboard";
        }
        return result;
    }

    @RequestMapping(value = {"/dashboard/renameFile"}, method = RequestMethod.GET)
    public String renameFile(@RequestParam("username") String username, @RequestParam("path") String path, @RequestParam("fileName") String fileName, @RequestParam("newName") String newName, Model model){

        File file = new File();
        file.setName(fileName);
        file.setOwnerID(userService.isExistSearchUserByUsername(username).get(0).getUserID());
        file.setPath(path);

        fileService.renameFile(file,newName);

        String result = "error";
        if(Boolean.parseBoolean(com.tolunayguduk.functions.File.renameFile(userService,fileName,path,username, newName))){
            model.addAttribute("folderList",Directory.repositoryIterator(userService,username,path));
            model.addAttribute("path", path);
            result = "dashboard";
        }
        return result;
    }

    @RequestMapping(value = {"/dashboard/renameDirectory"}, method = RequestMethod.GET)
    public String renameDirectory(@RequestParam("username") String username, @RequestParam("path") String path, @RequestParam("fileName") String fileName, @RequestParam("newName") String newName, Model model){

        Folder folder = new Folder();
        folder.setName(fileName);
        folder.setOwnerID(userService.isExistSearchUserByUsername(username).get(0).getUserID());
        folder.setPath(path);

        folderService.renameFolder(folder,newName);

        String result = "error";
        if(Boolean.parseBoolean(com.tolunayguduk.functions.File.renameFile(userService,fileName,path,username, newName))){
            model.addAttribute("folderList",Directory.repositoryIterator(userService,username,path));
            model.addAttribute("path", path);
            result = "dashboard";
        }
        return result;
    }

    @RequestMapping(value = {"/dashboard/createFile"}, method = RequestMethod.GET)
    public String createFile(@RequestParam("username") String username, @RequestParam("path") String path, @RequestParam("name") String name, Model model){

        File file = new File();
        file.setName(name);
        file.setOwnerID(userService.isExistSearchUserByUsername(username).get(0).getUserID());
        file.setPath(path);

        String result = "error";
        if(Boolean.parseBoolean(com.tolunayguduk.functions.File.createFile(userService,name,path,username))){
            model.addAttribute("folderList",Directory.repositoryIterator(userService,username,path));
            model.addAttribute("path", path);
            fileService.insertFile(file);
            result = "dashboard";
        }
        return result;
    }

    @RequestMapping(value = {"/dashboard/createDirectory"}, method = RequestMethod.GET)
    public String createDirectory(@RequestParam("username") String username, @RequestParam("path") String path, @RequestParam("name") String name, Model model){

        Folder folder = new Folder();
        folder.setName(name);
        folder.setOwnerID(userService.isExistSearchUserByUsername(username).get(0).getUserID());
        folder.setPath(path);

        String result = "error";
        if(Boolean.parseBoolean(Directory.createDirectory(userService,name,path,username))){
            model.addAttribute("folderList",Directory.repositoryIterator(userService,username,path));
            model.addAttribute("path", path);
            folderService.insertFolder(folder);
            result = "dashboard";
        }
        return result;
    }


    @RequestMapping(value = {"/dashboard/downloadDoc"}, method = RequestMethod.GET)
    public void downloadDoc(@RequestParam("fileName") String fileName, @RequestParam("path") String path, @RequestParam("username") String username, HttpServletResponse response) throws IOException {
        List<User> user =  userService.isExistSearchUserByUsername(username);
        java.io.File file = new java.io.File("C:\\tomcat\\bin\\cloud\\" + username + "_" + user.get(0).getEmail() + path);
        InputStream in = new FileInputStream(file);
        response.setContentType(String.valueOf(MediaType.APPLICATION_PDF));
        response.setHeader("Content-Disposition", "attachment; filename=" + fileName);
        response.setHeader("Content-Length", String.valueOf(file.length()));
        FileCopyUtils.copy(in, response.getOutputStream());
    }

    @RequestMapping(value = {"/dashboard/downloadDir"}, method = RequestMethod.GET)
    public void downloadDir(@RequestParam("fileName") String fileName,
                            @RequestParam("path") String path,
                            @RequestParam("username") String username,
                            HttpServletResponse response,
                            HttpServletRequest request) throws IOException {



    }


    @RequestMapping(value = {"/dashboard/uploadDoc"}, method = RequestMethod.POST)
    public @ResponseBody void uploadDoc(@RequestParam("file") MultipartFile file,
                          @RequestParam("path") String path,
                          @RequestParam("username") String username,
                            HttpServletResponse response) throws IOException {
            try {
                byte[] bytes = file.getBytes();

                // Creating the directory to store file
                String rootPath = "C:\\tomcat\\bin\\cloud\\" + username + "_" + userService.isExistSearchUserByUsername(username).get(0).getEmail() + path;
                java.io.File dir = new java.io.File(rootPath);
                if (!dir.exists())
                    dir.mkdirs();

                // Create the file on server
                java.io.File serverFile = new java.io.File(dir.getAbsolutePath() + "\\" + file.getOriginalFilename());
                BufferedOutputStream stream = new BufferedOutputStream(
                        new FileOutputStream(serverFile));
                stream.write(bytes);
                stream.close();
                response.sendRedirect("/dashboard/path?username=" + username + "&path=" + path);
            } catch (Exception e) {}
    }
}

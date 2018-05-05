package com.tolunayguduk.fuctions;

import com.tolunayguduk.model.User;
import com.tolunayguduk.service.interfaces.UserService;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class File {
    public static String createFile(UserService userService, String fileName, String path, String username,String suffix){
        List list = userService.isExistSearchUserByUsername(username);
        User user = (User) list.get(0);
        Boolean result = false;
        try{
            Path currentRelativePath = Paths.get("");
            String s = currentRelativePath.toAbsolutePath().toString();
            new java.io.File(s + "\\"+ "cloud\\" + user.getUsername() + "_" + user.getEmail() + "\\" + path + "\\" + fileName + "." + suffix).createNewFile();
            result = true;
        }catch (Exception e){
            System.out.println("ERROR = " + e.getMessage());
        }
        return result.toString();
    }
    public static String deleteFile(UserService userService,String fileName, String path, String username){
        List list = userService.isExistSearchUserByUsername(username);
        User user = (User) list.get(0);
        Boolean result = false;
        try{
            Path currentRelativePath = Paths.get("");
            String s = currentRelativePath.toAbsolutePath().toString();
            new java.io.File(s + "\\"+ "cloud\\" + user.getUsername() + "_" + user.getEmail() + "\\" + path + "\\" + fileName).delete();
            result = true;
        }catch (Exception e){
            System.out.println("ERROR = " + e.getMessage());
        }
        return result.toString();
    }
    public static String renameFile(UserService userService,String fileName, String path, String username, String newName){
        List list = userService.isExistSearchUserByUsername(username);
        User user = (User) list.get(0);
        Boolean result = false;
        try{
            Path currentRelativePath = Paths.get("");
            String s = currentRelativePath.toAbsolutePath().toString();
            new java.io.File(s + "\\"+ "cloud\\" + user.getUsername() + "_" + user.getEmail() + "\\" + path + "\\" + fileName)
                    .renameTo(new java.io.File(s + "\\"+ "cloud\\" + user.getUsername() + "_" + user.getEmail() + "\\" + path + "\\" + newName));
            result = true;
        }catch (Exception e){
            System.out.println("ERROR = " + e.getMessage());
        }
        return result.toString();
    }
    public static String uploadFile(UserService userService,String username, MultipartFile file, String name, String path){
        try {
            byte[] bytes = file.getBytes();
            List list = userService.isExistSearchUserByUsername(username);
            User user = (User) list.get(0);
            Path currentRelativePath = Paths.get("");
            String s = currentRelativePath.toAbsolutePath().toString();

            // Creating the directory to store file

            java.io.File dir =  new java.io.File(s + "\\"+ "cloud\\" + user.getUsername() + "_" + user.getEmail() + "\\" + path + "\\" + "tmpFile");

            if (!dir.exists())
                dir.mkdirs();

            // Create the file on server
            java.io.File serverFile = new java.io.File(dir.getAbsolutePath() + "\\" + name);
            BufferedOutputStream stream = new BufferedOutputStream(
                    new FileOutputStream(serverFile));
            stream.write(bytes);
            stream.close();


        } catch (Exception e) {
            return "You failed to upload " + name + " => " + e.getMessage();
        }
        return "true";
    }
}

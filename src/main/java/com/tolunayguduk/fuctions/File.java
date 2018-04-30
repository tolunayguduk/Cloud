package com.tolunayguduk.fuctions;

import com.tolunayguduk.model.User;
import com.tolunayguduk.service.interfaces.UserService;

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
    public static String deleteFile(UserService userService,String fileName, String path, String username, String suffix){
        List list = userService.isExistSearchUserByUsername(username);
        User user = (User) list.get(0);
        Boolean result = false;
        try{
            Path currentRelativePath = Paths.get("");
            String s = currentRelativePath.toAbsolutePath().toString();
            new java.io.File(s + "\\"+ "cloud\\" + user.getUsername() + "_" + user.getEmail() + "\\" + path + "\\" + fileName + "." + suffix).delete();
            result = true;
        }catch (Exception e){
            System.out.println("ERROR = " + e.getMessage());
        }
        return result.toString();
    }
    public static String renameFile(UserService userService,String fileName, String path, String username, String newName,String suffix){
        List list = userService.isExistSearchUserByUsername(username);
        User user = (User) list.get(0);
        Boolean result = false;
        try{
            Path currentRelativePath = Paths.get("");
            String s = currentRelativePath.toAbsolutePath().toString();
            new java.io.File(s + "\\"+ "cloud\\" + user.getUsername() + "_" + user.getEmail() + "\\" + path + "\\" + fileName + "." + suffix)
                    .renameTo(new java.io.File(s + "\\"+ "cloud\\" + user.getUsername() + "_" + user.getEmail() + "\\" + path + "\\" + newName + "." + suffix));
            result = true;
        }catch (Exception e){
            System.out.println("ERROR = " + e.getMessage());
        }
        return result.toString();
    }
}

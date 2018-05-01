package com.tolunayguduk.fuctions;

import com.tolunayguduk.model.User;
import com.tolunayguduk.service.interfaces.UserService;
import net.sf.json.JSONObject;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Directory {
    public static String deleteDirectory(UserService userService,String fileName, String path, String username){
        List list = userService.isExistSearchUserByUsername(username);
        User user = (User) list.get(0);
        Boolean result = false;
        try{
            Path currentRelativePath = Paths.get("");
            String s = currentRelativePath.toAbsolutePath().toString();
            new File(s + "\\"+ "cloud\\" + user.getUsername() + "_" + user.getEmail() + "\\" + path + fileName).delete();
            result = true;
        }catch (Exception e){
            System.out.println("ERROR = " + e.getMessage());
        }
        return result.toString();
    }
    public static String createDirectory(UserService userService,String fileName, String path, String username){
        List list = userService.isExistSearchUserByUsername(username);
        User user = (User) list.get(0);
        Boolean result = false;
        try{
            Path currentRelativePath = Paths.get("");
            String s = currentRelativePath.toAbsolutePath().toString();
            new File(s + "\\"+ "cloud\\" + user.getUsername() + "_" + user.getEmail() + "\\" + path + fileName).mkdir();
            result = true;
        }catch (Exception e){
            System.out.println("ERROR = " + e.getMessage());
        }
        return result.toString();
    }
    public static String repositoryIterator(UserService userService,String username,String path){
        List<User> userList = userService.isExistSearchUserByUsername(username);
        User user = userList.get(0);
        Path currentRelativePath = Paths.get("");
        String s = currentRelativePath.toAbsolutePath().toString();
        File file = new File(s + "\\" + "cloud" + "\\" + user.getUsername()+ "_" + user.getEmail() +"\\"+ path);
        ArrayList<File> files = new ArrayList<File>(Arrays.asList(file.listFiles()));

        JSONObject jsonObject = new JSONObject();
        int sayac = 0;
        for(File filex : files){
            jsonObject.put(sayac,filex.getName());
            sayac++;
        }
        return jsonObject.toString();
    }
    public static String renameDirectory(UserService userService,String fileName, String path, String username, String newName){
        List list = userService.isExistSearchUserByUsername(username);
        User user = (User) list.get(0);
        Boolean result = false;
        try{
            Path currentRelativePath = Paths.get("");
            String s = currentRelativePath.toAbsolutePath().toString();
            new File(s + "\\"+ "cloud\\" + user.getUsername() + "_" + user.getEmail() + "\\" + path + fileName)
                    .renameTo(new File(s + "\\"+ "cloud\\" + user.getUsername() + "_" + user.getEmail() + "\\" + path + newName));
            result = true;
        }catch (Exception e){
            System.out.println("ERROR = " + e.getMessage());
        }
        return result.toString();
    }
}

package com.tolunayguduk.fuctions;

import com.tolunayguduk.model.User;
import com.tolunayguduk.service.interfaces.UserService;
import net.sf.json.JSONObject;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Directory {

    public static boolean deleteDir(File dir) {
        if (dir.isDirectory()) {
            String[] children = dir.list();
            for (int i = 0; i < children.length; i++) {
                boolean success = deleteDir (new File(dir, children[i]));

                if (!success) {
                    return false;
                }
            }
        }
        return dir.delete();
    }

    public static String deleteDirectory(UserService userService,String fileName, String path, String username){
        List list = userService.isExistSearchUserByUsername(username);
        User user = (User) list.get(0);
        Boolean result = false;
        try{
            Path currentRelativePath = Paths.get("");
            String s = currentRelativePath.toAbsolutePath().toString();
            deleteDir(new File(s + "\\"+ "cloud\\" + user.getUsername() + "_" + user.getEmail() + "\\" + path + fileName));
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
            new File(s + "\\"+ "cloud\\" + user.getUsername() + "_" + user.getEmail() + "\\" + path +"\\"+ fileName).mkdir();
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

        JSONObject dosya = new JSONObject();
        JSONObject tum = new JSONObject();
        int sayac = 0;
        for(File filex : files){
            dosya.put("ad",filex.getName());
            if(filex.isDirectory()){
                dosya.put("tur","dizin");
            }else {
                dosya.put("tur","dosya");
            }
            dosya.put("sonDegisim", filex.lastModified());
            dosya.put("boyut",filex.length());


            tum.put(sayac,dosya);
            sayac++;
        }
        return tum.toString();
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

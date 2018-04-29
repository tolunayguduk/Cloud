package com.tolunayguduk.dao.interfaces;

import com.tolunayguduk.model.User;
import java.util.List;

public interface UserDAO {
    public void insertUser(User user);
    public List<User> isExistSearchUserByUsername(String username, String password);
    public List<User> isExistSearchUserByEmail(String username, String email);
    public List<User> isExistSearchUserByID(Long userID);
    public List<User> isExistSearchUserByUsername(String username);
}

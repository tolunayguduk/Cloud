package com.tolunayguduk.service.interfaces;

import com.tolunayguduk.model.User;

import java.util.List;

public interface UserService {
    public void insertUser(User user);
    public List<User> isExistSearchUserByUsername(String username, String password);
    public List<User> isExistSearchUserByEmail(String email, String password);
}

package com.tolunayguduk.service.classes;


import com.tolunayguduk.dao.interfaces.UserDAO;
import com.tolunayguduk.model.User;
import com.tolunayguduk.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional(propagation = Propagation.REQUIRED, readOnly = false,
        rollbackFor = Exception.class)

public class UserServiceImpl implements UserService {

    @Autowired
    UserDAO userdao;


    @Override
    public void insertUser(User user) {
        userdao.insertUser(user);
    }

    @Override
    public List<User> isExistSearchUserByUsername(String username, String password) {
        return userdao.isExistSearchUserByUsername(username, password);
    }

    @Override
    public List<User> isExistSearchUserByEmail(String email, String password) {
        return userdao.isExistSearchUserByEmail(email, password);
    }

    @Override
    public List<User> isExistSearchUserByID(Long userID) {
        return userdao.isExistSearchUserByID(userID);
    }

    @Override
    public List<User> isExistSearchUserByUsername(String username) {
        return userdao.isExistSearchUserByUsername(username);
    }
}

package com.moskitol.service;

import com.moskitol.dao.UserDao;
import com.moskitol.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

    private final UserDao USERDAO;
    @Autowired
    public UserServiceImpl(UserDao userDao) {
        USERDAO = userDao;
    }


    public List<User> findAll() {
        return USERDAO.findAll();
    }

    public User findById(int id) {
        return USERDAO.findById(id);
    }

    public void save(User user) {
        USERDAO.save(user);
    }

    public void delete(int id) {
        USERDAO.delete(id);
    }

    public User findUserByUsername(String username) {
        return USERDAO.findUserByUsername(username);
    }
}

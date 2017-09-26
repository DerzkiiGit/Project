package net.myProject.service;

import net.myProject.dao.UserDao;
import net.myProject.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Transactional
    public User getById(int id) {
        return userDao.getById(id);
    }
    @Transactional
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }
    @Transactional
    public List<User> getUserByName(String name) {
        return userDao.getUserByName(name);
    }
    @Transactional
    public void removeUser(int id) {
        userDao.removeUser(id);
    }
    @Transactional
    public void updateUser(User user) {
        userDao.updateUser(user);
    }
    @Transactional
    public void createUser(User user) {
        userDao.createUser(user);
    }



}

package net.myProject.service;

import net.myProject.model.User;

import java.util.List;

/**
 * Created by SpooN on 31.08.2017.
 */
public interface UserService {

    User getById(int id);

    List<User> getAllUsers();

    List<User> getUserByName(String name);

    void removeUser(int id);

    void updateUser(User user);

    void createUser(User user);
}

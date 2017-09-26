package net.myProject.dao;

import net.myProject.model.User;

import java.util.List;

/**
 * Created by SpooN on 30.08.2017.
 */
public interface UserDao {

    User getById(int id);

    List<User> getAllUsers();

    List<User> getUserByName(String name);

     void removeUser(int id);

    void updateUser(User user);

    void createUser(User user);
}

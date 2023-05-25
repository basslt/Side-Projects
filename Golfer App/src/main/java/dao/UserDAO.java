package dao;


import model.User;

import java.util.List;

public interface UserDAO {
    User getUserById(int userId);
    User getUserByUsername(String username);
    User getUserByEmail(String email);
    List<User> getAllUsers();
    void addUser(User user);
    void updateUser(User user);
    void deleteUser(User user);
}


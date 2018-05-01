package xyz.yaohwu.dao;

import xyz.yaohwu.entity.User;

public interface UserDAO {

    void save(User user);

    User findUserById(int id);
}

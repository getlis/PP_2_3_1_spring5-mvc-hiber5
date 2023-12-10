package org.example.dao;

import org.example.models.User;

import java.util.List;

public interface UserDao {
    void add( User user );
    void delete( int id );
    List<User> getAll();
    User get( int id );
    void uptdate( User user );
}

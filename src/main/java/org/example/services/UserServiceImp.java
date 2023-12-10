package org.example.services;

import org.example.dao.UserDao;
import org.example.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserDao userDao;
    @Override
    public void add(User user) {
        userDao.add( user );
    }

    @Override
    public void delete(int id) {
        userDao.delete( id );
    }

    @Override
    public List<User> getAll() {
        return userDao.getAll();
    }

    @Override
    public User get(int id) {
        return userDao.get( id );
    }

    @Override
    public void uptdate(User user) {
        userDao.uptdate( user );
    }
}

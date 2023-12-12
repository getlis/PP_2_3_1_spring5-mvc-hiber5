package org.example.services;

import org.example.dao.UserDao;
import org.example.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserDao userDao;

    @Transactional
    @Override
    public void add(User user) {
        userDao.add( user );
    }

    @Transactional
    @Override
    public void delete(int id) {
        userDao.delete( id );
    }

    @Transactional( readOnly = true )
    @Override
    public List<User> getAll() {
        return userDao.getAll();
    }

    @Override
    @Transactional(readOnly = true)
    public User get(int id) {
        return userDao.get( id );
    }

    @Override
    @Transactional
    public void uptdate(User user) {
        userDao.uptdate( user );
    }
}

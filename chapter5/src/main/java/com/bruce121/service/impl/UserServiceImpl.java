package com.bruce121.service.impl;

import com.bruce121.dao.UserDao;
import com.bruce121.entity.User;
import com.bruce121.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Author: Bruce121
 * Date: 2018-10-31
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public boolean save(User user) {
        return userDao.save(user) > 0 ;
    }

    @Override
    public User getByOriginal(Long id) {
        return userDao.getByOriginal(id);
    }

    @Override
    public List<User> batchGet(Long... ids) {
        return userDao.batchGet(ids);
    }

    @Override
    public User get(Long id) {
        return userDao.get(id);
    }

    @Override
    public boolean update(User user) {
        return userDao.update(user) > 0;
    }

    @Override
    public boolean delete(Long id) {
        return userDao.delete(id) > 0;
    }
}

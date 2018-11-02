package com.bruce121.service;

import com.bruce121.entity.User;

import java.util.List;

/**
 * Author: Bruce121
 * Date: 2018-10-31
 */
public interface UserService {
    /**
     * Create
     */
    boolean save(User user);

    /**
     * Read
     */
    User get(Long id);
    User getByOriginal(Long id);
    List<User> batchGet(Long ... ids);

    /**
     * Update
     */
    boolean update(User user);

    /**
     * Delete
     */
    boolean delete(Long id);

}

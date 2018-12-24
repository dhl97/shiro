package com.baizhi.service;

import com.baizhi.dao.UserDAO;
import com.baizhi.entity.Permission;
import com.baizhi.entity.Role;
import com.baizhi.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public User queryUserByUsername(String username) {
        return userDAO.findUserByUsername(username);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Set<Role> queryRolesByUsername(String username) {
        return userDAO.findRolesByUsername(username);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Set<Permission> queryPermissionByUsername(String username) {
        return userDAO.findPermissionsByUsername(username);
    }
}

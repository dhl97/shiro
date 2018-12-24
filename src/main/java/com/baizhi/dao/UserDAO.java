package com.baizhi.dao;

import com.baizhi.entity.Permission;
import com.baizhi.entity.Role;
import com.baizhi.entity.User;

import java.util.Set;

public interface UserDAO {
    User findUserByUsername(String username);

    Set<Role> findRolesByUsername(String username);

    Set<Permission> findPermissionsByUsername(String username);
}

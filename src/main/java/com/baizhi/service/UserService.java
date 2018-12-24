package com.baizhi.service;

import com.baizhi.entity.Permission;
import com.baizhi.entity.Role;
import com.baizhi.entity.User;

import java.util.Set;

public interface UserService {

    public User queryUserByUsername(String username);

    public Set<Role> queryRolesByUsername(String username);

    public Set<Permission> queryPermissionByUsername(String username);
}

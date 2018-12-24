package com.baizhi.realm;

import com.baizhi.entity.Permission;
import com.baizhi.entity.Role;
import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;
import java.util.UUID;

public class MyRealm2 extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    /**
     * 获取认证信息的方法
     *
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("-----------------------");
        UsernamePasswordToken upToken = (UsernamePasswordToken) authenticationToken;
        String username = upToken.getUsername();
        User user = userService.queryUserByUsername(username);
        if (user != null) {
            return new SimpleAccount(
                    user.getUsername(),
                    user.getPassword(),
                    ByteSource.Util.bytes(user.getSalt())
                    , UUID.randomUUID().toString()
            );
        }
        return null;
    }

    /**
     * 获取授权数据的方法
     *
     * @param principalCollection
     * @return
     */
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        System.out.println("================");

        String username = (String) principalCollection.getPrimaryPrincipal();

        // 查询角色和权限资源数据
        // zs 角色 root admin user 权限: user:*
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

        Set<Role> roles = userService.queryRolesByUsername(username);

        if (roles != null && roles.size() != 0) {
            roles.forEach(role -> {
                // zs ---> root
                // zs ---> admin
                info.addRole(role.getRoleTag());
            });
        }

        Set<Permission> permissions = userService.queryPermissionByUsername(username);

        if(permissions != null && permissions.size() != 0){
            permissions.forEach(permission -> {
                // 主体 绑定权限 数据
                info.addStringPermission(permission.getPermissionTag());
            });
        }
        return info;
    }
}

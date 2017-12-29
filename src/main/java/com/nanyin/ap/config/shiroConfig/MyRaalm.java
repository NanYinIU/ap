package com.nanyin.ap.config.shiroConfig;


import com.nanyin.ap.model.Users;
import com.nanyin.ap.service.PermissionService;
import com.nanyin.ap.service.RoleService;
import com.nanyin.ap.service.UsersService;
import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * Created by NanYin on 2017-09-23 下午10:28.
 * 包名： com.nanyin.config.shiroConfig
 * 类描述：
 */
public class MyRaalm extends AuthorizingRealm {
    @Autowired
    UsersService userService;
    @Autowired
    RoleService roleService;
    @Autowired
    PermissionService permissionService;

    Logger logger = Logger.getLogger(this.getClass());

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        Users users = (Users) SecurityUtils.getSubject().getPrincipal();

        String username = users.getUsername();

        logger.info(username);
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.setStringPermissions(permissionService.findPermissionByName(username));
        logger.info("permission"+permissionService.findPermissionByName(username));
        simpleAuthorizationInfo.setRoles(roleService.findRoleByName(username));
        logger.info("roles"+roleService.findRoleByName(username));
        return simpleAuthorizationInfo;
    }
    /*
    登录
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken)
            throws AuthenticationException {

        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        String name = token.getUsername();
        Users user = userService.findUserByName(name);
        String password = user.getPassword();

        return new SimpleAuthenticationInfo(user,password,this.getClass().getName());
    }
}

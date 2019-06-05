package com.aak.configuration;



import com.aak.entity.Authority;
import com.aak.entity.Credentials;
import com.aak.service.CredentialsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;

// UserDetails-提供用户核心信息
// 在Security提供的UserDetailsService默认实现JdbcDaoImpl中，角色和权限都存储在auhtorities表中。
// 而不是像Shiro那样，角色有个roles表，权限有个permissions表。以及相关的管理表等等。
public class JdbcUserDetails implements UserDetailsService {

    @Autowired
    private CredentialsService credentialsService;

    /**
     * 根据用户名获取登录用户信息
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Credentials credentials = credentialsService.selectByName(username);


        if(credentials==null){

            throw new UsernameNotFoundException("User"+username+"can not be found");
        }

        Authority authority = new Authority();
        authority.setAuthority("ROLE_OAUTH_ADMIN");
        List<Authority> authorityList = new ArrayList<>();
        authorityList.add(authority);
        credentials.setAuthorities(authorityList);
        User user = new User(credentials.getName(),credentials.getPassword(),credentials.isEnabled(),true,true,true,credentials.getAuthorities());

        System.out.println(credentials.getName()+" "+credentials.getPassword());
        return  user;


    }
}

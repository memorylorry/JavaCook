package cn.dectfix.service;

import cn.dectfix.dao.UserDAO;
import cn.dectfix.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Created by huqian on 2018/3/9.
 */
@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private UserDAO userDAO;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //find user
        User user = userDAO.load(username);
        return new MyUserDetails(user);
    }
}

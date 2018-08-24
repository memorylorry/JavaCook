package cn.dectfix.service;

import cn.dectfix.dto.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * Created by huqian on 2018/3/9.
 */
public class MyUserDetails implements UserDetails {

    private User user;

    public MyUserDetails(User user){
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return user.getAuthorities();
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return !user.isIs_exprie();
    }

    @Override
    public boolean isAccountNonLocked() {
        return !user.isIs_locked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return user.isIs_credential();
    }

    @Override
    public boolean isEnabled() {
        return user.isIs_enable();
    }

    @Override
    public String getName() {
        return user.getName();
    }
}

package cn.dectfix.dto;

import org.springframework.security.core.GrantedAuthority;

import java.util.List;

/**
 * Created by huqian on 2018/3/9.
 */
public class User {
    private String username;
    private String password;
    private boolean is_exprie;
    private boolean is_locked;
    private boolean is_credential;
    private boolean is_enable;
    private String name;
    private List<GrantedAuthority> authorities;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isIs_exprie() {
        return is_exprie;
    }

    public void setIs_exprie(boolean is_exprie) {
        this.is_exprie = is_exprie;
    }

    public boolean isIs_locked() {
        return is_locked;
    }

    public void setIs_locked(boolean is_locked) {
        this.is_locked = is_locked;
    }

    public boolean isIs_credential() {
        return is_credential;
    }

    public void setIs_credential(boolean is_credential) {
        this.is_credential = is_credential;
    }

    public boolean isIs_enable() {
        return is_enable;
    }

    public void setIs_enable(boolean is_enable) {
        this.is_enable = is_enable;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<GrantedAuthority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(List<GrantedAuthority> authorities) {
        this.authorities = authorities;
    }
}

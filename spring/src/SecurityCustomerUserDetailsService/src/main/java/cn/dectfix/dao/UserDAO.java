package cn.dectfix.dao;

import cn.dectfix.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by huqian on 2018/3/11.
 */
@Repository
public class UserDAO {
    @Autowired
    private DataSource dataSource;

    public User load(String name) {
        User user = new User();
        try {
            Connection con = dataSource.getConnection();
            Statement stm = con.createStatement();
            //query basic info
            ResultSet rs = stm.executeQuery("SELECT id,username,password,IF(exprie_date<NOW(),1,0) is_expire,is_locked,is_credential,is_enable,name FROM `user`;");
            rs.next();
            int user_id = rs.getInt("id");
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setIs_exprie(rs.getBoolean("is_expire"));
            user.setIs_locked(rs.getBoolean("is_locked"));
            user.setIs_credential(rs.getBoolean("is_credential"));
            user.setIs_enable(rs.getBoolean("is_enable"));
            user.setName(rs.getString("name"));
            //query authorities info
            String authorities = "SELECT role from role where id in(SELECT role_id from role_group WHERE group_id in (SELECT groups_id FROM user_group where user_id="+user_id+"));";
            ResultSet rs2 = stm.executeQuery(authorities);

            List<GrantedAuthority> list = new ArrayList<>();

            while (rs2.next()){
                String sa = rs2.getString("role");
                GrantedAuthority a = new GrantedAuthority() {
                    @Override
                    public String getAuthority() {
                        return sa;
                    }
                };
                list.add(a);
            }

            user.setAuthorities(list);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
}

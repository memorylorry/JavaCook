package cn.dectfix.conf;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

/**
 * Created by huqian on 2018/3/9.
 */
@PropertySource("classpath:app.properties")
public class BeanFactory {

    @Value("${spring.datasource.url}")
    private String url;

    @Value("${spring.datasource.username}")
    private String username;

    @Value("${spring.datasource.password}")
    private String password;


    @Bean
    public DataSource dataSource(){
        MysqlDataSource mysqlDataSource = new MysqlDataSource();
        mysqlDataSource.setUrl(url);
        mysqlDataSource.setUser(username);
        mysqlDataSource.setPassword(password);
        return mysqlDataSource;
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new PasswordEncoder(){
            public String encode(CharSequence charSequence) {
                //without any encode steps, this's just easy to use when developing.
                return charSequence.toString();
            }
            public boolean matches(CharSequence charSequence, String s) {
                return encode(charSequence).equals(s)?true:false;
            }
        };
    }

}

package cn.dectfix.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Created by huqian on 2017/12/17.
 * WebSecurity configuration
 */
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //config jdbc and memory datasource
        auth.
                jdbcAuthentication()
                    .dataSource(dataSource)
                    .usersByUsernameQuery("select username,password,enabled from users where username = ?")
                    .authoritiesByUsernameQuery("select username,role from user_roles where username = ?")
                .and()
                .inMemoryAuthentication().withUser("user").password("123").roles("USER");
    }

    /**
     * Define a fake password encoder.
     * What you input is what it outputs.
     * @return
     */
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

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                    .antMatchers("/admin").hasRole("ADMIN")
                    .antMatchers("/user").hasRole("USER")
                    .antMatchers("/index").permitAll()
                    .anyRequest().authenticated()
                    .and()
                .formLogin()
                    .loginPage("/login")
                    .permitAll()
                    .and()
                .csrf();
    }

}

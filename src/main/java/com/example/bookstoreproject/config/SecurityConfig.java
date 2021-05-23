package com.example.bookstoreproject.config;

import com.example.bookstoreproject.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.rememberme.InMemoryTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserService userService;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {

        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
        auth.setUserDetailsService(userService);
        auth.setPasswordEncoder(passwordEncoder());
        return auth;
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        super.configure(auth);
        auth.authenticationProvider(authenticationProvider());
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.authorizeRequests().antMatchers("/bookstore/**").permitAll();

        http.authorizeRequests().antMatchers("/bookstore/logout")
                .access("hasRole('ROLE_USER')  or hasRole('ROLE_ADMIN')");

        http.authorizeRequests().antMatchers("/admin/home/**", "/admin/adminUser/**",
                "/admin/adminPost/**", "/admin/adminFeedback/**", "/admin/adminUser/formAddUser/**",
                "/admin/adminUser/formEditUser/**", "/admin/adminPost/formEditPost/**")
                .access("hasRole('ROLE_ADMIN')");

        http.authorizeRequests().antMatchers("/pay/**")
                .access("hasRole('ROLE_USER')");


        http.authorizeRequests().and().exceptionHandling().accessDeniedPage("/bookstore/error404");

        // Cấu hình cho Login Form.
        http.authorizeRequests().and().formLogin()
                .loginProcessingUrl("/j_spring_security_check")
                .loginPage("/bookstore/login")
                .defaultSuccessUrl("/bookstore/home")
                .failureUrl("/bookstore/login?error=true")
                .usernameParameter("email")
                .passwordParameter("pass")
                .and().logout().logoutUrl("/bookstore/logout")
                .logoutSuccessUrl("/bookstore/login?logout");

    }

    @Bean
    public PersistentTokenRepository persistentTokenRepository() {
        InMemoryTokenRepositoryImpl memory = new InMemoryTokenRepositoryImpl();
        return memory;
    }


}

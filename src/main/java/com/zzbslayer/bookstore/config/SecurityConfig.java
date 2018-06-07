package com.zzbslayer.bookstore.config;

import com.zzbslayer.bookstore.service.UserService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    UserService userService;

    @Bean
    UserDetailsService customUserService(){ //注册UserDetailsService 的bean
        return new CustomUserService();
    }

    @Autowired
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customUserService()).passwordEncoder(new BCryptPasswordEncoder()); //user Details Service verification
    }

    // @formatter:off
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/api/categorys/**").permitAll()
                .antMatchers("/api/books/**").permitAll()
                .antMatchers("/api/register").permitAll()
                .antMatchers("/api/user/**").hasRole("USER")
                .antMatchers("/api/admin/**").hasRole("ADMIN")
                .and()
                .formLogin().loginPage("/login_page")
                .successHandler(new AuthenticationSuccessHandler() {
                    @Override
                    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
                        httpServletResponse.setContentType("application/json;charset=utf-8");
                        String username = authentication.getName();

                        logger.debug("Creating new  login for user : " + username);

                        List<String> authorities = new ArrayList<>();
                        for (GrantedAuthority authority :authentication.getAuthorities()) {
                            authorities.add(authority.getAuthority());
                        };
                        PrintWriter out = httpServletResponse.getWriter();
                        out.write("{\"status\":\"ok\",\"msg\":\"login success\",\"user\":"+ JSONObject.fromObject(userService.findByUsername(username)).toString()+ "}");
                        out.flush();
                        out.close();
                    }
                })
                .failureHandler(new AuthenticationFailureHandler() {
                    @Override
                    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
                        httpServletResponse.setContentType("application/json;charset=utf-8");
                        System.out.println("password:"+httpServletRequest.getParameter("password"));
                        logger.debug("Login failure");
                        logger.debug(e.getMessage());
                        PrintWriter out = httpServletResponse.getWriter();
                        out.write("{\"status\":\"error\",\"msg\":\"login fail\"}");
                        out.flush();
                        out.close();
                    }
                }).loginProcessingUrl("/api/login")
                .usernameParameter("username").passwordParameter("password").permitAll()
                .and()
                .logout().logoutUrl("/api/logout")
                .logoutSuccessHandler(new LogoutSuccessHandler() {
                    @Override
                    public void onLogoutSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
                        httpServletResponse.setContentType("application/json;charset=utf-8");
                        String username = authentication.getName();
                        logger.debug("Logout for user : " + username);

                        PrintWriter out = httpServletResponse.getWriter();
                        out.write("{\"status\":\"ok\",\"username\":\"" + username + "\",\"msg\":\"logout success\"}");
                        out.flush();
                        out.close();
                    }
                })
                .deleteCookies("JSESSIONID")
                .deleteCookies("login")
                .deleteCookies("role")
                .deleteCookies("username")
                .permitAll()
                .and().csrf().disable().cors()
                .and()
                .httpBasic();
    }
}
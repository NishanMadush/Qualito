package com.qualito.digiwork;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.qualito.digiwork.service.user.LoginAttemptService;

@EnableWebSecurity
@Configuration
public class WebSecConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private LoginAttemptService loginAttemptService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers("/login", "/vendors/**", "/css/**", "/js/**", "/fonts/**", "/images/**", "/app-assets/**").permitAll()
                .antMatchers("/admin/**").hasRole("ADMIN")  
                .anyRequest().authenticated()
                .and()
            .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/admin/loginAttempts")
                .permitAll()
                .successHandler((request, response, authentication) -> {
                    String username = authentication.getName();
                    loginAttemptService.logAttempt(username, true); // Log successful login
                    response.sendRedirect("/admin/loginAttempts");
                })
                .failureHandler((request, response, exception) -> {
                    String username = request.getParameter("username");
                    loginAttemptService.logAttempt(username, false); // Log failed login
                    response.sendRedirect("/login?error"); // Redirect back to login page with error
                })
                .and().csrf().disable()
            .logout()
                .permitAll();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
            .withUser("admin").password(passwordEncoder.encode("admin")).roles("ADMIN");
    }
}

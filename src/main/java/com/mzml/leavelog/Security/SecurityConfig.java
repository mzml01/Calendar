package com.mzml.leavelog.Security;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    @Value("${user1.username}")
    private String user1Username;

    @Value("${user1.password}")
    private String user1Password;

    @Value("${user1.roles}")
    private String user1Roles;

    @Value("${user2.username}")
    private String user2Username;

    @Value("${user2.password}")
    private String user2Password;

    @Value("${user2.roles}")
    private String user2Roles;
    @Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager(){
        UserDetails user1= User.builder().
                username(user1Username).
                password(user1Password).
                roles(user1Roles).
                build();
        UserDetails user2= User.builder().
                username(user2Username).
                password(user2Password).
                roles(user2Roles).
                build();
        return new InMemoryUserDetailsManager(user1,user2);
    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests(authoriseRequests->
                authoriseRequests.requestMatchers("/LeaveLog/showFormForUpdate")
                        .authenticated().anyRequest().permitAll())
                .formLogin(formLogin->
                        formLogin
                                .loginPage("/showMyLoginPage")
                                .loginProcessingUrl("/authenticateTheUser")
                                .permitAll())
                .logout(logout->
                        logout.permitAll());
        return http.build();
    }
}

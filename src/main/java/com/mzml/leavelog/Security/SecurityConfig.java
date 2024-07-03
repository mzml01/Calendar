package com.mzml.leavelog.Security;

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
    @Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager(){
        UserDetails user1= User.builder().
                username("388").
                password("{noop}test388").
                roles("ADMIN").
                build();
        UserDetails user2= User.builder().
                username("428").
                password("{noop}test428").
                roles("STUDENT").
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

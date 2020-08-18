package com.anr.config;

//public class BasicSecConfiguration {
//}

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class BasicSecConfiguration extends WebSecurityConfigurerAdapter {

    // @Override
    // protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    // PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
    // auth
    // .inMemoryAuthentication()
    // .withUser("user")
    // .password(encoder.encode("password"))
    // .roles("USER")
    // .and()
    // .withUser("admin")
    // .password(encoder.encode("admin"))
    // .roles("USER", "ADMIN");
    // }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // http.authorizeRequests().anyRequest().authenticated().and().httpBasic();

        http.csrf().disable().authorizeRequests().anyRequest().permitAll();
    }
}

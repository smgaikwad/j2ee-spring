package com.beanscope.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public SecurityConfig(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.
                csrf().disable().
                authorizeRequests() // please authorize request
                .antMatchers("/","index", "/css/*", "/js/*")// except this antMatchers
                .permitAll() // permit all antMatchers to use our website without authentication
                .antMatchers("/api/**").hasAnyRole("STUDENT", "EMPLOYEE") // allow only STUDENTS to access this api
//                .antMatchers(HttpMethod.POST,"/management/api/**").hasAnyAuthority(COURSE_WRITE.getPermission())
//                .antMatchers(HttpMethod.PUT,"/management/api/**").hasAnyAuthority(COURSE_WRITE.getPermission())
//                .antMatchers(HttpMethod.DELETE,"/management/api/**").hasAnyAuthority(COURSE_WRITE.getPermission())
//                .antMatchers(HttpMethod.GET,"/management/api/**").hasAnyRole(ADMIN.name(), ADMIN_TRAINEE.name())
                .anyRequest() // other than antMatchers any request you need to Authorize it
                .authenticated() // then authenticate every request by checking the permissions
                .and()  // and
                //.httpBasic()// i want to use basic authentication for same instead pf form based and JWT
                .httpBasic();
    }

    @Override
    @Bean
    protected UserDetailsService userDetailsService(){
        UserDetails sooraj = User.builder()
                .username("sooraj")
                .password(passwordEncoder.encode("password"))
                .roles("Student")
                .build();

        UserDetails dhiraj = User.builder()
                .username("dhiraj")
                .password(passwordEncoder.encode("password"))
                .roles("Student")
                .build();

        return  new InMemoryUserDetailsManager(
                sooraj,
                dhiraj
        );

    }
}

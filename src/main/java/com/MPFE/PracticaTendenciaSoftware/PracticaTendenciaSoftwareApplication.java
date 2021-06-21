package com.MPFE.PracticaTendenciaSoftware;

import com.MPFE.PracticaTendenciaSoftware.security.JWTAuthorizationFilter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@SpringBootApplication
public class PracticaTendenciaSoftwareApplication {

    public static void main(String[] args) {
        SpringApplication.run(PracticaTendenciaSoftwareApplication.class, args);
    }

    @EnableWebSecurity
    class WebSecurityConfig extends WebSecurityConfigurerAdapter {

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.cors().and().csrf().disable() 
            /*.addFilterAfter(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class)
            .authorizeRequests().antMatchers(HttpMethod.GET,"/").permitAll().and()
            antMatchers(HttpMethod.GET,"/login").permitAll()*/
            .antMatcher("/**").authorizeRequests().antMatchers("/","/index.html")
            .authenticated().anyRequest().authenticated().and()
            .oauth2Login().permitAll().and()
            .logout().logoutSuccessUrl("/");
        }
    }

    @Configuration
    class AppConfig {

        @Bean
        public PasswordEncoder passwordEncoder() {
            return new BCryptPasswordEncoder();
        }

    }

}

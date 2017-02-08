package com.mrin;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.util.matcher.RegexRequestMatcher;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.core.annotation.Order;

//Manually Added
import org.springframework.security.web.access.channel.ChannelProcessingFilter;

@EnableWebSecurity
@Order(1)
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
    protected void configure(HttpSecurity http) throws Exception {
      http
       .csrf().disable()
       .addFilterBefore(new CorsFilter(), ChannelProcessingFilter.class)
       .authorizeRequests()
       .antMatchers( "/**/*.html").permitAll()
       .anyRequest().authenticated()
      ;
    
    }
    
}

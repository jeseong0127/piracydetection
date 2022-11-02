package com.example.test.core.config;

import com.example.test.core.security.JwtAuthenticationFilter;
import com.example.test.core.security.JwtTokenProvider;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final JwtTokenProvider jwtTokenProvider;

    private final ObjectMapper objectMapper;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic().disable()
                .cors().and()
                .formLogin().disable()
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/swagger-ui/**").permitAll()
                .antMatchers("/api/auth/oauth", "/api/auth/app-version").permitAll()
                .antMatchers("/api/**").permitAll()
//                .anyRequest().hasRole("ROLE_MEMBER")
                .and()
                .addFilterBefore(new JwtAuthenticationFilter(jwtTokenProvider, objectMapper), UsernamePasswordAuthenticationFilter.class);
    }

    @Override
    public void configure(WebSecurity web) {
        web.ignoring().antMatchers(
                "/v3/api-docs", "/swagger-resources/**",
                "/swagger-ui/index.html", "/webjars/**", "/swagger/**"
        );
    }
}

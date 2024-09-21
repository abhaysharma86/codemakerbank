package com.codemakerbank.securityconfiguration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SecurityConfig {

  @Bean
  SecurityFilterChain defaultSecurityFilterChain(HttpSecurity security) throws Exception{
//        security.authorizeHttpRequests(request->request.anyRequest().permitAll());
//      security.authorizeHttpRequests(request->request.anyRequest().denyAll());
//      security.authorizeHttpRequests(request->request.anyRequest().authenticated());
        security.authorizeHttpRequests(request->request.requestMatchers("/api/v1/Account/open","/api/v1/Account/view/**").authenticated()
                .requestMatchers("/api/v1/loans","/api/v1/loans/**").authenticated()
                .requestMatchers("/api/v1/Account/contact/**").permitAll());
        security.formLogin(withDefaults());
        security.httpBasic(withDefaults());
        return security.build();
  }

}

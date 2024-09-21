package com.codemakerbank.securityconfiguration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.password.CompromisedPasswordChecker;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.password.HaveIBeenPwnedRestApiPasswordChecker;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SecurityConfig {

  @Bean
  SecurityFilterChain defaultSecurityFilterChain(HttpSecurity security) throws Exception{
//        security.authorizeHttpRequests(request->request.anyRequest().permitAll()); // Permit All request
//      security.authorizeHttpRequests(request->request.anyRequest().denyAll());    // deny All request
//      security.authorizeHttpRequests(request->request.anyRequest().authenticated()); // Authenticated all request
        security.authorizeHttpRequests(request->request.requestMatchers("/api/v1/Account/open","/api/v1/Account/view/**").authenticated()
                .requestMatchers("/api/v1/loans","/api/v1/loans/**").authenticated()
                .requestMatchers("/api/v1/Account/contact/**").permitAll());
        security.formLogin(withDefaults());
        security.httpBasic(withDefaults());
        return security.build();
  }

    @Bean
    public UserDetailsService userDetailsService()
    {
        UserDetails user = User.withUsername("user").password("{noop}codemakerbank").authorities("read").build();
        return new InMemoryUserDetailsManager(user);
    }

    @Bean
    public PasswordEncoder passwordEncoder()
    {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Bean
    public CompromisedPasswordChecker compromisedPasswordChecker()
    {
        return new HaveIBeenPwnedRestApiPasswordChecker();
    }

}

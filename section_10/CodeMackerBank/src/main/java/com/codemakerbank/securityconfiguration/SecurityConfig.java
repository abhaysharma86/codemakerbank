package com.codemakerbank.securityconfiguration;

import com.codemakerbank.exceptionHandling.CustomAccessDeniedHandler;
import com.codemakerbank.exceptionHandling.CustomBasicAuthenticationEntryPoint;
import com.codemakerbank.filter.AuthoritiesLoggingAfterFilter;
import com.codemakerbank.filter.AuthoritiesLoggingAtFilter;
import com.codemakerbank.filter.RequestValidationBeforeFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.authentication.password.CompromisedPasswordChecker;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.password.HaveIBeenPwnedRestApiPasswordChecker;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@Profile("!prod")
public class SecurityConfig {

  @Bean
  SecurityFilterChain defaultSecurityFilterChain(HttpSecurity security) throws Exception{
        security.sessionManagement(smc->smc.invalidSessionUrl("/invalidSession").maximumSessions(2).maxSessionsPreventsLogin(true))
                .requiresChannel(crm->crm.anyRequest().requiresInsecure()) // only for HTTP
                .addFilterBefore(new RequestValidationBeforeFilter(), BasicAuthenticationFilter.class)
                .addFilterAfter(new AuthoritiesLoggingAfterFilter(), BasicAuthenticationFilter.class)
                .addFilterAt(new AuthoritiesLoggingAtFilter(), BasicAuthenticationFilter.class)
                .authorizeHttpRequests(request->request
                .requestMatchers("/api/v1/Account/open").hasRole("ADMIN")
                .requestMatchers("/api/v1/Account/view/**").hasAnyRole("USER","ADMIN")
                .requestMatchers("/api/v1/loans").hasRole("ADMIN")
                .requestMatchers("/api/v1/loans/all/**").hasRole("USER")
                .requestMatchers("/api/v1/loans/**").hasRole("USER")
                .requestMatchers("/api/v1/Account/contact/**").permitAll());
        security.formLogin(withDefaults());
        security.httpBasic(hhc->hhc.authenticationEntryPoint(new CustomBasicAuthenticationEntryPoint()));
        security.exceptionHandling(ehc->ehc.accessDeniedHandler(new CustomAccessDeniedHandler()));
        return security.build();
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

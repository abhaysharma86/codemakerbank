package com.codemakerbank.securityconfiguration;

import com.codemakerbank.models.UserLogin;
import com.codemakerbank.repository.UserLoginRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CodeMakerBankUserDetailsService implements UserDetailsService {

    private final UserLoginRepo userLoginRepo;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserLogin userLogin = this.userLoginRepo.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException("User Not found with id: " + username));
//        List<SimpleGrantedAuthority> authorities = List.of(new SimpleGrantedAuthority(userLogin.getRole()));
        List<SimpleGrantedAuthority> authorities = userLogin.getAuthorities()
                    .stream()
                    .map(auth -> new SimpleGrantedAuthority(auth.getRole()))
                    .collect(Collectors.toList());
        return new User(userLogin.getEmail(), userLogin.getPwd(), authorities);
    }
}

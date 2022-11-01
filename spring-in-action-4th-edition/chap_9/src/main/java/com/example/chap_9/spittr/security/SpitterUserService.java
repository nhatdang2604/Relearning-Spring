package com.example.chap_9.spittr.security;

import com.example.chap_9.spittr.Spitter;
import com.example.chap_9.spittr.data.SpitterRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class SpitterUserService implements UserDetailsService {

    private final SpitterRepository spitterRepository;

    private final PasswordEncoder passwordEncoder;

    public static final String SPITTER_AUTHORITY = "ROLE_SPITTER";

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Spitter spitter = spitterRepository.findByUsername(username);
        if (null != spitter) {
            List<GrantedAuthority> authorities = new ArrayList<>();
            authorities.add(new SimpleGrantedAuthority(SPITTER_AUTHORITY ));

            return new User(
                    spitter.getUsername(),
                    passwordEncoder.encode(spitter.getPassword()),
                    authorities
            );
        }

        throw new UsernameNotFoundException(
                "User '" + username + "' not found."
        );
    }
}

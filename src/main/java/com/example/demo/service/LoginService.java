package com.example.demo.service;

import com.example.demo.configuration.ThreadLocalStorage;
import com.example.demo.model.sql.Account;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class LoginService implements UserDetailsService {
    private final static long validityInMilliseconds = 86400 * 1000L; // 1day
    private String secretKey = "secret";

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = new Account();
        account.setUserName("dung");
        account.setPassword(new BCryptPasswordEncoder().encode("dung"));
        Set<GrantedAuthority> grantedAuthority = new HashSet<>();
        grantedAuthority.add(new SimpleGrantedAuthority("giam doc"));
        User t = new User(account.getUserName(), account.getPassword(), grantedAuthority);

        HashMap<String, String> profile = new HashMap<>();
        profile.put("username", username);
        profile.put("display", "dung");
        ThreadLocalStorage.setProfile(profile);

        Claims claims = Jwts.claims().setSubject(username);
        claims.put("username", username);
        Date startTime = new Date();
        Date endTime = new Date(startTime.getTime() + validityInMilliseconds);
        String token = Jwts.builder()//
                .setClaims(claims)//
                .setIssuedAt(startTime)//
                .setExpiration(endTime)//
                .signWith(SignatureAlgorithm.HS512, secretKey)//
                .compact();

        HashMap<String, String> map = new HashMap<>();
        map.put("token", token);
        ThreadLocalStorage.setToken(map);

        return t;
    }
}
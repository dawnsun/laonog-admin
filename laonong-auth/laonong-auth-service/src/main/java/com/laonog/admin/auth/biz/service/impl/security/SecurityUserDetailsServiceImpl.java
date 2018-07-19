package com.laonog.admin.auth.biz.service.impl.security;

import com.laonog.admin.auth.config.LaonogUserDetails;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;

@Service
public class SecurityUserDetailsServiceImpl implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        String lowcaseUsername = userName.toLowerCase();
        Collection<GrantedAuthority> grantedAuthorities = new HashSet<>();
        grantedAuthorities.add(new SimpleGrantedAuthority("findclient"));
        LaonogUserDetails userDO = new LaonogUserDetails(1,"system",new BCryptPasswordEncoder().encode("123456"),grantedAuthorities,true);
        return userDO;
    }
}

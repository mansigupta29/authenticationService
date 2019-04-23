package com.mansi.serviceauth.security;

import com.mansi.serviceauth.models.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private BCryptPasswordEncoder encoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        // hard coding the users. All passwords must be encoded.
        final List<AppUser> users = Arrays.asList(
                new AppUser("mansi29", encoder.encode("12345"), "USER"),
                new AppUser( "abhinav12", encoder.encode("12345"), "USER"),
            new AppUser( "neha30", encoder.encode("12345"), "USER")
        );


        for(AppUser appUser: users) {
            if(appUser.getUsername().equals(username)) {


                List<GrantedAuthority> grantedAuthorities = AuthorityUtils
                        .commaSeparatedStringToAuthorityList("ROLE_" + appUser.getRole());


                return new User(appUser.getUsername(), appUser.getPassword(), grantedAuthorities);
            }
        }


        throw new UsernameNotFoundException("Username: " + username + " not found");
    }


}

/*package com.haufe.challenge.services;

import com.haufe.challenge.domains.User;
import com.haufe.challenge.models.LoggedUser;
import com.haufe.challenge.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findUserByUsername(username);
        if(user == null) {
            throw new UsernameNotFoundException(username);
        }

        LoggedUser loggedUser = new LoggedUser(username, user.getPassword(), Arrays.asList(new SimpleGrantedAuthority("ADMIN")));
        loggedUser.setPassword(user.getPassword());
        return loggedUser;
    }

}*/

package com.enotessa.SpringJavaChat.Security;

import com.enotessa.SpringJavaChat.Entity.UserEntity;
import com.enotessa.SpringJavaChat.Entity.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ChatUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Autowired
    public ChatUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = userRepository.findByUserName(username);
        if (user != null){
            return new ChatUserDetails(user);
        }
        else {
            throw new UsernameNotFoundException("User not found");
        }
    }
}

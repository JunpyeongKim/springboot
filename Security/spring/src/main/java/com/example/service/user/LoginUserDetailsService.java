package com.example.service.user;

///* dummy
public class LoginUserDetailsService {

}
//*/

/*
import com.example.domain.user.LoginUserDetails;
import com.example.domain.user.User;
import com.example.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
//@Transactional
public class LoginUserDetailsService implements UserDetailsService {
    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        LoginUserDetails loginUserDetails;

        User user = userRepository.findOneByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("Not found: " + username);
        }

        loginUserDetails = new LoginUserDetails(user);
        return loginUserDetails;
    }
}
//*/

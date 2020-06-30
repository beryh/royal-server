package io.devyang.royalserver.services;

import io.devyang.royalserver.dto.UserDto;
import io.devyang.royalserver.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public UserDto getDummyUser() {
        return userRepository.getDummyUser();
    }
}

package io.devyang.royalserver.services;

import io.devyang.royalserver.dto.UserDto;
import io.devyang.royalserver.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDto getDummyUser() {
        return userRepository.getDummyUser();
    }
}

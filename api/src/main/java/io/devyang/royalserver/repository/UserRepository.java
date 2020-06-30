package io.devyang.royalserver.repository;

import io.devyang.royalserver.dto.UserDto;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

@Component
public class UserRepository {
    UserDto userDto = new UserDto("tester", 1, (short) 5, new Timestamp(System.currentTimeMillis()));

    public UserDto getDummyUser() {
        return userDto;
    }
}

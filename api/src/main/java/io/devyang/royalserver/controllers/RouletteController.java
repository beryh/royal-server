package io.devyang.royalserver.controllers;

import io.devyang.royalserver.dto.UserDto;
import io.devyang.royalserver.services.RouletteService;
import io.devyang.royalserver.services.UserService;
import io.devyang.royalserver.vo.SpinResultVo;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController("/api/roulette")
public class RouletteController {
    private final RouletteService rouletteService;
    private final UserService userService;

    public RouletteController(RouletteService rouletteService, UserService userService) {
        this.rouletteService = rouletteService;
        this.userService = userService;
    }

    @GetMapping("/rewards")
    public List<String> getAllRewardsByLevel(@RequestParam("level") Integer level) {
        return rouletteService.getAllRewardByLevel(level);
    }

    @PostMapping("/spin")
    public SpinResultVo spin(@RequestBody(required = false) Integer level) {
        UserDto dummyUser = userService.getDummyUser();
        dummyUser.setRouletteLevel(Optional.ofNullable(level).orElse(1));
        return rouletteService.spin(dummyUser);
    }
}
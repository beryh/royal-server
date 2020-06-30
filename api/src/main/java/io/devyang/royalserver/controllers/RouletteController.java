package io.devyang.royalserver.controllers;

import io.devyang.royalserver.dto.UserDto;
import io.devyang.royalserver.services.RouletteService;
import io.devyang.royalserver.services.UserService;
import io.devyang.royalserver.vo.SpinResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RouletteController {
    @Autowired
    private RouletteService rouletteService;

    @Autowired
    private UserService userService;

    @GetMapping("/api/roulette/rewards")
    public List<String> getAllRewardsByLevel(@RequestParam("level") Integer level) {
        return rouletteService.getAllRewardByLevel(level);
    }

    @PostMapping("/api/roulette/spin")
    public SpinResultVo spin() {
        UserDto dummyUser = userService.getDummyUser();
        return rouletteService.spin(dummyUser);
    }
}
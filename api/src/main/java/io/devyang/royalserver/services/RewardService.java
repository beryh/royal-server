package io.devyang.royalserver.services;

import org.springframework.stereotype.Service;

import io.devyang.royalserver.dto.RewardDto;
import io.devyang.royalserver.dto.UserDto;
import io.devyang.royalserver.enums.RewardType;

@Service
public class RewardService {
    public RewardDto giveReward(UserDto user, String rewardId) {
        return new RewardDto(rewardId, RewardType.COIN, 1000);
    }
}
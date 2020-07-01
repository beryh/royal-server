package io.devyang.royalserver.services;

import io.devyang.royalserver.dto.RewardDto;
import io.devyang.royalserver.dto.UserDto;
import io.devyang.royalserver.enums.RewardType;
import io.devyang.royalserver.exceptions.ResourceNotFoundException;
import io.devyang.royalserver.repository.RewardRepository;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class RewardService {
    private final RewardRepository rewardRepository;

    public RewardService(RewardRepository rewardRepository) {
        this.rewardRepository = rewardRepository;
    }

    @PostConstruct
    public void init() {
        initDatabase();
    }

    public RewardDto giveReward(UserDto user, String rewardId) {
        return rewardRepository.findById(rewardId).orElseThrow(() -> new ResourceNotFoundException("cannot find reward: " + rewardId));
    }

    private void initDatabase() {
        if (!rewardRepository.existsById("Reward1-1")) {
            rewardRepository.saveAll(
                List.of(
                    new RewardDto("Reward1-1", RewardType.COIN, 1000),
                    new RewardDto("Reward1-2", RewardType.CARDPACK, 1),

                    new RewardDto("Reward2-1", RewardType.COIN, 1500),
                    new RewardDto("Reward2-2", RewardType.COIN, 2000),
                    new RewardDto("Reward2-3", RewardType.CARDPACK, 2),

                    new RewardDto("Reward3-1", RewardType.COIN, 2000),
                    new RewardDto("Reward3-2", RewardType.COIN, 4000),
                    new RewardDto("Reward3-3", RewardType.COIN, 10000),
                    new RewardDto("Reward3-4", RewardType.CARDPACK, 2),
                    new RewardDto("Reward3-5", RewardType.CARDPACK, 4)
                )
            );
        }
    }
}
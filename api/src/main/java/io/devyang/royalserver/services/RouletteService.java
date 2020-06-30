package io.devyang.royalserver.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.devyang.royalserver.dto.RewardDto;
import io.devyang.royalserver.dto.RouletteDto;
import io.devyang.royalserver.dto.UserDto;
import io.devyang.royalserver.repository.RouletteRepository;
import io.devyang.royalserver.vo.SpinResultVo;

@Service
public class RouletteService {

    private static final int REQUIRE_SPIN_COUNT = 1;

    @Autowired
    private RewardService rewardService;

    @Autowired
    private RouletteRepository rouletteRepository;

    private Random random = new Random();
    private Map<Integer/* Level */, List<String> /* Rewards*/> rewardByLevel = new HashMap<>();

    @PostConstruct
    public void init() {
        // Initialize slots from database
        List<RouletteDto> slots = rouletteRepository.findAll();
        
        // loop *chance* times of the reward -> make pick easy when requested
        slots.forEach(slotDto -> {
                List<String> rewards = Collections.nCopies(slotDto.getChance(), slotDto.getRewardId());

                rewardByLevel.putIfAbsent(slotDto.getLevel(), new ArrayList<>());
                rewardByLevel.get(slotDto.getLevel()).addAll(rewards);
            });
    }

    public List<String> getAllRewardByLevel(Integer level) {
        return Optional.ofNullable(rewardByLevel.get(level)).orElse(List.of())
                .stream()
                .distinct()
                .collect(Collectors.toList());
    }

    //@Transactional
    public SpinResultVo spin(UserDto userDto) {
        // update spin count
        // throw exception unless enough as requirement
        userDto.deductSpinCount(REQUIRE_SPIN_COUNT);

        // get reward id by user level
        String rewardId = pickRewardIdByLevel(userDto.getRouletteLevel());

        // give reward to user
        // return the information of given reward
        return new SpinResultVo(userDto.getRemainSpin(), userDto.getLatestSpinTimestamp(), rewardService.giveReward(userDto, rewardId));
    }

    private String pickRewardIdByLevel(Integer level) {
        return rewardByLevel.get(level).get(random.nextInt(rewardByLevel.get(level).size()));
    }
}
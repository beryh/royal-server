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
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import io.devyang.royalserver.dto.RewardDto;
import io.devyang.royalserver.dto.RouletteDto;
import io.devyang.royalserver.dto.UserDto;
import io.devyang.royalserver.repository.RouletteRepository;
import io.devyang.royalserver.vo.SpinResultVo;

@Service
public class RouletteService {
    private static final int REQUIRE_SPIN_COUNT = 1;

    private final RewardService rewardService;
    private final RouletteRepository rouletteRepository;

    private Random random = new Random();
    private Map<Integer/* Level */, List<String> /* Rewards*/> rewardByLevel = new HashMap<>();

    public RouletteService(RewardService rewardService, RouletteRepository rouletteRepository) {
        this.rewardService = rewardService;
        this.rouletteRepository = rouletteRepository;
    }

    @PostConstruct
    public void init() {
        // Initialize database if empty
        initDatabase();

        // Initialize slots from database
        List<RouletteDto> slots = rouletteRepository.findAll();
        
        // loop *chance* times of the reward -> make pick easy when requested
        slots.forEach(slotDto -> {
                List<String> rewards = Collections.nCopies(slotDto.getChance(), slotDto.getReward().getRewardId());

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

    @Transactional
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

    private void initDatabase() {
        if (rouletteRepository.count() == 0) {
            rouletteRepository.saveAll(
                List.of(
                    new RouletteDto(null, 1, 2, RewardDto.of("Reward1-1")),
                    new RouletteDto(null, 1, 1, RewardDto.of("Reward1-2")),

                    new RouletteDto(null, 2, 4, RewardDto.of("Reward2-1")),
                    new RouletteDto(null, 2, 2, RewardDto.of("Reward2-2")),
                    new RouletteDto(null, 2, 1, RewardDto.of("Reward2-3")),

                    new RouletteDto(null, 3, 5, RewardDto.of("Reward3-1")),
                    new RouletteDto(null, 3, 4, RewardDto.of("Reward3-2")),
                    new RouletteDto(null, 3, 1, RewardDto.of("Reward3-3")),
                    new RouletteDto(null, 3, 3, RewardDto.of("Reward3-4")),
                    new RouletteDto(null, 3, 1, RewardDto.of("Reward3-5"))
                )
            );
        }
    }
}
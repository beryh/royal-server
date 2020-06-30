package io.devyang.royalserver.repository;

import java.util.List;

import io.devyang.royalserver.dto.RouletteDto;
import org.springframework.stereotype.Component;

@Component
public class RouletteRepository {
    public List<RouletteDto> findAll() {
        return List.of(
            new RouletteDto(1, 1, "Reward1-1"),
            new RouletteDto(1, 1, "Reward1-2"),
            new RouletteDto(1, 1, "Reward1-3"),
            new RouletteDto(1, 1, "Reward1-4"),
            new RouletteDto(1, 1, "Reward1-5"),
            
            new RouletteDto(2, 1, "Reward2-1"),
            new RouletteDto(2, 1, "Reward2-2"),
            new RouletteDto(2, 1, "Reward2-3"),
            new RouletteDto(2, 1, "Reward2-4"),
            new RouletteDto(2, 1, "Reward2-5"),
            new RouletteDto(2, 1, "Reward2-6"),
            new RouletteDto(2, 1, "Reward2-7"),

            
            new RouletteDto(3, 1, "Reward3-1"),
            new RouletteDto(3, 1, "Reward3-2"),
            new RouletteDto(3, 1, "Reward3-3"),
            new RouletteDto(3, 1, "Reward3-4"),
            new RouletteDto(3, 1, "Reward3-5"),
            new RouletteDto(3, 1, "Reward3-6"),
            new RouletteDto(3, 1, "Reward3-7"),
            new RouletteDto(3, 1, "Reward3-8"),
            new RouletteDto(3, 1, "Reward3-9")
        );
    }
}
package io.devyang.royalserver.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
public class RouletteDto {
    private Integer level;
    private Integer chance;
    private String rewardId;
}
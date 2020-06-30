package io.devyang.royalserver.dto;

import io.devyang.royalserver.enums.RewardType;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
public class RewardDto {
    private String rewardId;
    private RewardType type;
    private Integer amount;
}
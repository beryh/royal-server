package io.devyang.royalserver.dto;

import io.devyang.royalserver.enums.RewardType;
import lombok.*;
import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Rewards")
public class RewardDto {
    @Id
    @Column(name = "reward_id", length = 20)
    private String rewardId;

    private RewardType type;
    private Integer amount;

    public static RewardDto of(String rewardId) {
        return new RewardDto(rewardId, null, null);
    }
}
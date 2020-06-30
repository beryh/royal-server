package io.devyang.royalserver.vo;

import java.sql.Timestamp;

import io.devyang.royalserver.dto.RewardDto;
import lombok.*;

@Getter
@AllArgsConstructor
public class SpinResultVo {
    private int remainSpinCount;
    private Timestamp latestSpinTimestamp;
    
    private RewardDto givenReward;
}
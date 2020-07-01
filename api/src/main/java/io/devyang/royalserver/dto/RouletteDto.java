package io.devyang.royalserver.dto;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Roulettes")
public class RouletteDto {
    @Id
    @Column(name = "roulette_id", length = 20)
    @GeneratedValue
    private Integer rouletteId;

    private Integer level;
    private Integer chance;

    @ManyToOne(targetEntity = RewardDto.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "reward_id")
 
    private RewardDto reward;
}
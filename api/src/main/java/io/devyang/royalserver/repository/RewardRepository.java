package io.devyang.royalserver.repository;

import io.devyang.royalserver.dto.RewardDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RewardRepository extends JpaRepository<RewardDto, String> {
        
}
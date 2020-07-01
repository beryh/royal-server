package io.devyang.royalserver.repository;

import io.devyang.royalserver.dto.RouletteDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RouletteRepository extends JpaRepository<RouletteDto, Integer> {

}
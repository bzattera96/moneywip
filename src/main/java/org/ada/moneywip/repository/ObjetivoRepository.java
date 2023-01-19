package org.ada.moneywip.repository;

import org.ada.moneywip.entity.Objetivo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ObjetivoRepository extends JpaRepository<Objetivo, Integer> {
    Boolean existsByObjetivo(String objetivo);
}
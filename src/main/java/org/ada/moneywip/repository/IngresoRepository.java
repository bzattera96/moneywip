package org.ada.moneywip.repository;

import org.ada.moneywip.entity.Ingreso;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IngresoRepository  extends JpaRepository <Ingreso, Integer> {
    Optional<Ingreso> findByPersona(String personaDni);
}

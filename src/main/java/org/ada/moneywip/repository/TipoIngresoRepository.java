package org.ada.moneywip.repository;

import org.ada.moneywip.entity.TipoIngreso;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TipoIngresoRepository extends JpaRepository<TipoIngreso, Integer> {

    Boolean existsByTipoIngreso(String tipoIngreso); //devuelve tipoingreso optional

    Optional<TipoIngreso> findByTipoIngreso(String tipoIngreso); //devuelve tipoingreso optional

    void deleteByTipoIngreso(String tipoIngreso);
}


package org.ada.moneywip.repository;

import org.ada.moneywip.entity.TipoEgreso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipoEgresoRepository extends JpaRepository <TipoEgreso, Integer> {
    Boolean existsByTipoEgreso(String tipoEgreso);
}

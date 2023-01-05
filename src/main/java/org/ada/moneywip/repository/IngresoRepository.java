package org.ada.moneywip.repository;

import org.ada.moneywip.entity.Ingreso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngresoRepository  extends JpaRepository <Ingreso, Integer> {
}

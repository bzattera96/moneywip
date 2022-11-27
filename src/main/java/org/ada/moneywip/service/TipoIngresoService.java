package org.ada.moneywip.service;

import org.ada.moneywip.dto.TipoIngresoDTO;
import org.ada.moneywip.entity.Ingreso;
import org.ada.moneywip.entity.TipoIngreso;
import org.ada.moneywip.exceptions.ExistingResourceException;
import org.ada.moneywip.exceptions.ResourceNotFoundException;
import org.ada.moneywip.repository.TipoIngresoRepository;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class TipoIngresoService {
    private final TipoIngresoRepository tipoIngresoRepository;

    public TipoIngresoService(TipoIngresoRepository tipoIngresoRepository) {
        this.tipoIngresoRepository = tipoIngresoRepository;
    }
    public TipoIngresoDTO create (TipoIngresoDTO tipoIngresoDTO) {
        TipoIngreso tipoIngreso = mapToEntity(tipoIngresoDTO);
        checkForExistingTipoIngreso(tipoIngreso.getTipoIngreso());
        tipoIngreso = tipoIngresoRepository.save(tipoIngreso);

        return tipoIngresoDTO;
    }

    private void checkForExistingTipoIngreso(String tipoIngreso) {
        if (tipoIngresoRepository.existsByTipoIngreso(tipoIngreso)) {
            throw new ExistingResourceException();
        }
    }

    private TipoIngreso mapToEntity(TipoIngresoDTO tipoIngresoDTO) {
        TipoIngreso tipoIngreso = new TipoIngreso(tipoIngresoDTO.getId(), tipoIngresoDTO.getTipoIngreso());
        return tipoIngreso;
    }

    private TipoIngresoDTO mapToDTO(TipoIngreso tipoIngreso) {
        TipoIngresoDTO tipoIngresoDTO = new TipoIngresoDTO(tipoIngreso.getId(), tipoIngreso.getTipoIngreso());
        return tipoIngresoDTO;
    }

    public TipoIngresoDTO retrieveByTipoIngreso(String tipoIngresoNombre) {
        Optional<TipoIngreso> tipoIngreso = tipoIngresoRepository.findByTipoIngreso(tipoIngresoNombre);
        if (tipoIngreso.isEmpty()) {
            throw new ResourceNotFoundException();
        }
        return mapToDTO(tipoIngreso.get());
    }

    public void delete(String tipoIngreso) {
        try {
            tipoIngresoRepository.deleteByTipoIngreso(tipoIngreso);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException();
        }
    }

    public void modify(Integer tipoIngresoId, Map<String,Object> camposAModificar) {
        Optional<TipoIngreso> tipoIngreso = tipoIngresoRepository.findById(tipoIngresoId);
        if (tipoIngreso.isEmpty()) {
            throw new ResourceNotFoundException();
        }
        TipoIngreso tipoIngresoAModificar = tipoIngreso.get();
        camposAModificar.forEach((key, value) -> tipoIngresoAModificar.modifyAttributeValue(key, value));
    }


}
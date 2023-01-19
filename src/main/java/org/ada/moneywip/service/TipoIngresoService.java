package org.ada.moneywip.service;

import org.ada.moneywip.dto.TipoIngresoDTO;
import org.ada.moneywip.entity.TipoIngreso;
import org.ada.moneywip.repository.exceptions.ExistingResourceException;
import org.ada.moneywip.repository.exceptions.ResourceNotFoundException;
import org.ada.moneywip.repository.TipoIngresoRepository;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

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

    public TipoIngresoDTO retrieveByTipoIngresoId(Integer tipoIngresoId) {
        Optional<TipoIngreso> tipoIngreso = tipoIngresoRepository.findById(tipoIngresoId);
        if (tipoIngreso.isEmpty()) {
            throw new ResourceNotFoundException();
        }
        return mapToDTO(tipoIngreso.get());
    }

    public void delete(Integer tipoIngresoId) {
        try {
            tipoIngresoRepository.deleteById(tipoIngresoId);
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
        tipoIngresoRepository.save(tipoIngresoAModificar);
    }
}
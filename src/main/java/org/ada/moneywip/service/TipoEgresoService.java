package org.ada.moneywip.service;

import org.ada.moneywip.dto.TipoEgresoDTO;
import org.ada.moneywip.entity.TipoEgreso;
import org.ada.moneywip.exceptions.ExistingResourceException;
import org.ada.moneywip.exceptions.ResourceNotFoundException;
import org.ada.moneywip.repository.TipoEgresoRepository;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

@Service
public class TipoEgresoService {
    private final TipoEgresoRepository tipoEgresoRepository;

    public TipoEgresoService(TipoEgresoRepository tipoEgresoRepository) {
        this.tipoEgresoRepository = tipoEgresoRepository;
    }

    public TipoEgresoDTO create (TipoEgresoDTO tipoEgresoDTO) {
        TipoEgreso tipoEgreso = mapToEntity(tipoEgresoDTO);
        checkForExistingTipoEgreso(tipoEgreso.getTipoEgreso());
        tipoEgreso = tipoEgresoRepository.save(tipoEgreso);

        return tipoEgresoDTO;
    }

    private void checkForExistingTipoEgreso(String tipoEgreso) {
        if (tipoEgresoRepository.existsByTipoEgreso(tipoEgreso)) {
            throw new ExistingResourceException();
        }
    }

    private TipoEgreso mapToEntity(TipoEgresoDTO tipoEgresoDTO) {
        TipoEgreso tipoEgreso = new TipoEgreso(tipoEgresoDTO.getId(), tipoEgresoDTO.getTipoEgreso());
        return tipoEgreso;
    }

    private TipoEgresoDTO mapToDTO(TipoEgreso tipoEgreso) {
        TipoEgresoDTO tipoEgresoDTO = new TipoEgresoDTO(tipoEgreso.getId(), tipoEgreso.getTipoEgreso());
        return tipoEgresoDTO;
    }

    public TipoEgresoDTO retrieveByTipoEgresoId(Integer tipoEgresoId) {
        Optional<TipoEgreso> tipoEgreso = tipoEgresoRepository.findById(tipoEgresoId);
        if (tipoEgreso.isEmpty()) {
            throw new ResourceNotFoundException();
        }
        return mapToDTO(tipoEgreso.get());
    }

    public void delete(Integer tipoEgresoId) {
        try {
            tipoEgresoRepository.deleteById(tipoEgresoId);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException();
        }
    }

    public void modify(Integer tipoEgresoId, Map<String,Object> camposAModificar) {
        Optional<TipoEgreso> tipoEgreso = tipoEgresoRepository.findById(tipoEgresoId);
        if (tipoEgreso.isEmpty()) {
            throw new ResourceNotFoundException();
        }
        TipoEgreso tipoEgresoAModificar = tipoEgreso.get();
        camposAModificar.forEach((key, value) -> tipoEgresoAModificar.modifyAttributeValue(key, value));
        tipoEgresoRepository.save(tipoEgresoAModificar);
    }
}

package com.vinicius.store.service;

import com.vinicius.store.model.Sunset;
import com.vinicius.store.repository.SunsetRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@AllArgsConstructor
@Service
public class SunsetService {

    private final SunsetRepository repository;

    public Sunset saveSunset(Sunset sunset) {
        return repository.save(sunset);
    }

    public List<Sunset> findAll(){
        return repository.findAll();
    }

    public Sunset updateSunsetById(Sunset sunset, String id) {
        Sunset sunsetAuxiliar = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "ID not found"));
        sunset.setId(sunsetAuxiliar.getId());
        return repository.save(sunset);
    }

    public Sunset patchPrice(Sunset sunset, String id){
       Sunset sunsetAuxiliar= repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND,"ID not found"));
        sunsetAuxiliar.setPrice(sunset.getPrice());
        return repository.save(sunsetAuxiliar);
    }

    public void deleteByID(String id) {
        repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "ID not found"));
        repository.deleteById(id);
    }

}

// trocar saveSunset para save
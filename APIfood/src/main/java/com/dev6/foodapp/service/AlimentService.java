package com.dev6.foodapp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dev6.foodapp.model.Aliment;
import com.dev6.foodapp.repository.AlimentRepository;

import lombok.Data;


@Data
@Service
public class AlimentService {

    @Autowired
    private AlimentRepository alimentRepository;

    public Iterable<Aliment> findAll() {
        return alimentRepository.findAll();
    }

    public Optional<Aliment> findAliment(final Long id) {
        return alimentRepository.findById(id);
    }

    public void deleteAliment(final Long id) {
        alimentRepository.deleteById(id);
    }

    public Aliment saveAliment(Aliment aliment) {
        Aliment saveAliment = alimentRepository.save(aliment);
        System.out.println("Aliment saved : "  + saveAliment);
        return saveAliment;
    }
}

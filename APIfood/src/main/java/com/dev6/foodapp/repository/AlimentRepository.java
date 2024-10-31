package com.dev6.foodapp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dev6.foodapp.model.Aliment;

@Repository
public interface AlimentRepository extends CrudRepository<Aliment, Long> {

}

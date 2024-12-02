package com.udg.proyect.repositories;

import com.udg.proyect.Models.MotorcycleModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MotorcycleRepository extends CrudRepository<MotorcycleModel, Long> {

    Optional<MotorcycleModel> findBySerialNumber(Integer serialNumber);

}

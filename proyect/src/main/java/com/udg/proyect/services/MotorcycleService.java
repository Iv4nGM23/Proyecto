package com.udg.proyect.services;

import com.udg.proyect.Models.MotorcycleModel;
import com.udg.proyect.repositories.MotorcycleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class MotorcycleService {
    @Autowired
    MotorcycleRepository motorcycleRepository;

    // Obtener todas las motocicletas
    public ArrayList<MotorcycleModel> findAllMotorcycles() {
        return (ArrayList<MotorcycleModel>) motorcycleRepository.findAll();
    }

    // Guardar motocicleta
    public MotorcycleModel saveMotorcycle(MotorcycleModel motorcycle) {
        return motorcycleRepository.save(motorcycle);
    }

    // Encontrar motocicleta por número de serie
    public Optional<MotorcycleModel> findMotorcycleBySerialNumber(Integer serialNumber) {
        return motorcycleRepository.findBySerialNumber(serialNumber);
    }

    // Eliminar motocicleta
    public String deleteMotorcycleBySerialNumber(Integer serialNumber) {
        String response = "";
        Optional<MotorcycleModel> foundMotorcycle = findMotorcycleBySerialNumber(serialNumber);
        if (foundMotorcycle.isPresent()) {
            motorcycleRepository.delete(foundMotorcycle.get());
            response = "Motocicleta eliminada correctamente";
        } else {
            response = "Motocicleta no encontrada";
        }
        return response;
    }

    // Editar motocicleta
    public MotorcycleModel updateMotorcycle(Integer serialNumber, MotorcycleModel motorcycleModel) {
        return findMotorcycleBySerialNumber(serialNumber).isPresent() ?
                motorcycleRepository.save(motorcycleModel) :
                new MotorcycleModel(0, "Motorcycle not found", "", 0, 0.0);
    }
}

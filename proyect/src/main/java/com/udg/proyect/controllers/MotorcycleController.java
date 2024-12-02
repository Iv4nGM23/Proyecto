package com.udg.proyect.controllers;

import com.udg.proyect.Models.MotorcycleModel;
import com.udg.proyect.services.MotorcycleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

        import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/motorcycles")
public class MotorcycleController {
    @Autowired
    MotorcycleService motorcycleService;

    // Obtener todas las motocicletas
    @GetMapping()
    public ArrayList<MotorcycleModel> findAllMotorcycles() {
        return motorcycleService.findAllMotorcycles();
    }

    // Guardar una motocicleta
    @PostMapping()
    public MotorcycleModel saveMotorcycle(@RequestBody MotorcycleModel motorcycle) {
        return motorcycleService.saveMotorcycle(motorcycle);
    }

    // Encontrar motocicleta por número de serie
    @GetMapping("/findBySerialNumber={serialNumber}")
    public Optional<MotorcycleModel> getMotorcycleBySerialNumber(@PathVariable Integer serialNumber) {
        return motorcycleService.findMotorcycleBySerialNumber(serialNumber);
    }

    // Eliminar motocicleta por número de serie
    @DeleteMapping("/deleteMotorcycleBySerialNumber={serialNumber}")
    public String deleteMotorcycleBySerialNumber(@PathVariable Integer serialNumber) {
        return motorcycleService.deleteMotorcycleBySerialNumber(serialNumber);
    }

    // Actualizar motocicleta por número de serie
    @PutMapping("/updateMotorcycleBySerialNumber={serialNumber}")
    public MotorcycleModel updateMotorcycle(@PathVariable Integer serialNumber, @RequestBody MotorcycleModel motorcycleModel) {
        return motorcycleService.updateMotorcycle(serialNumber, motorcycleModel);
    }
}

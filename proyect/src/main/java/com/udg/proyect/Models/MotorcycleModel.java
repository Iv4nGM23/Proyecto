package com.udg.proyect.Models;
import jakarta.persistence.*;

@Entity
@Table(name = "motorcycles")
public class MotorcycleModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true)
    private Long id;
    private Integer serialNumber; // Número de serie de la motocicleta
    private String model;         // Modelo de la motocicleta
    private String brand;         // Marca de la motocicleta
    private Integer engineSize;   // Cilindrada (cc)
    private Double price;         // Precio de la motocicleta

    public MotorcycleModel(Integer serialNumber, String model, String brand, Integer engineSize, Double price) {
        this.serialNumber = serialNumber;
        this.model = model;
        this.brand = brand;
        this.engineSize = engineSize;
        this.price = price;
    }
    public MotorcycleModel(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(Integer serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Integer getEngineSize() {
        return engineSize;
    }

    public void setEngineSize(Integer engineSize) {
        this.engineSize = engineSize;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}

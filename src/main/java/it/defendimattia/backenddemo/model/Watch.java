package it.defendimattia.backenddemo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "LuxuryWatches")
public class Watch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "brand cannot be empty")
    @Size(max = 250, message = "brand must be max 250 characters long")
    private String brand;

    private String caseMaterial;

    private String strapMaterial;

    private String movementType;

    private String waterResistance;

    private double caseDiameter;

    private double caseThickness;

    private double bandWidth;

    private String dialColor;

    private String cristalMaterial;

    private String complications;

    private String powerReserve;

    private String price;

}

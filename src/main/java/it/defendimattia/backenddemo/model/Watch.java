package it.defendimattia.backenddemo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "luxury_watches")
public class Watch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "brand cannot be empty")
    @Size(max = 250, message = "brand must be max 250 characters long")
    @Column(name = "\"Brand\"")
    private String brand;

    @NotBlank(message = "model cannot be empty")
    @Size(max = 250, message = "model must be max 250 characters long")
    @Column(name = "\"Model\"")
    private String model;

    @Size(max = 250, message = "case material must be max 250 characters long")
    @Column(name = "\"Case Material\"")
    private String caseMaterial;

    @Size(max = 250, message = "strap material must be max 250 characters long")
    @Column(name = "\"Strap Material\"")
    private String strapMaterial;

    @Size(max = 250, message = "movement type must be max 250 characters long")
    @Column(name = "\"Movement Type\"")
    private String movementType;

    @Column(name = "\"Water Resistance (meters)\"")
    private Short waterResistance;

    @Positive(message = "case diameter must be greater than 0")
    @Column(name = "\"Case Diameter (mm)\"")
    private double caseDiameter;

    @Positive(message = "case thickness must be greater than 0")
    @Column(name = "\"Case Thickness (mm)\"")
    private double caseThickness;

    @Positive(message = "band width must be greater than 0")
    @Column(name = "\"Band Width (mm)\"")
    private double bandWidth;

    @Size(max = 250, message = "dial color must be max 250 characters long")
    @Column(name = "\"Dial Color\"")
    private String dialColor;

    @Size(max = 250, message = "crystal material must be max 250 characters long")
    @Column(name = "\"Crystal Material\"")
    private String crystalMaterial;

    @Size(max = 400, message = "complications must be max 400 characters long")
    @Column(name = "\"Complications\"")
    private String complications;

    @Column(name = "\"Power Reserve (hours)\"")
    private Short powerReserve;

    @Column(name = "\"Price (USD)\"")
    private Integer price;

    public Watch() {
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBrand() {
        return this.brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return this.model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getCaseMaterial() {
        return this.caseMaterial;
    }

    public void setCaseMaterial(String caseMaterial) {
        this.caseMaterial = caseMaterial;
    }

    public String getStrapMaterial() {
        return this.strapMaterial;
    }

    public void setStrapMaterial(String strapMaterial) {
        this.strapMaterial = strapMaterial;
    }

    public String getMovementType() {
        return this.movementType;
    }

    public void setMovementType(String movementType) {
        this.movementType = movementType;
    }

    public Short getWaterResistance() {
        return this.waterResistance;
    }

    public void setWaterResistance(Short waterResistance) {
        this.waterResistance = waterResistance;
    }

    public double getCaseDiameter() {
        return this.caseDiameter;
    }

    public void setCaseDiameter(double caseDiameter) {
        this.caseDiameter = caseDiameter;
    }

    public double getCaseThickness() {
        return this.caseThickness;
    }

    public void setCaseThickness(double caseThickness) {
        this.caseThickness = caseThickness;
    }

    public double getBandWidth() {
        return this.bandWidth;
    }

    public void setBandWidth(double bandWidth) {
        this.bandWidth = bandWidth;
    }

    public String getDialColor() {
        return this.dialColor;
    }

    public void setDialColor(String dialColor) {
        this.dialColor = dialColor;
    }

    public String getCrystalMaterial() {
        return this.crystalMaterial;
    }

    public void setCrystalMaterial(String crystalMaterial) {
        this.crystalMaterial = crystalMaterial;
    }

    public String getComplications() {
        return this.complications;
    }

    public void setComplications(String complications) {
        this.complications = complications;
    }

    public Short getPowerReserve() {
        return this.powerReserve;
    }

    public void setPowerReserve(Short powerReserve) {
        this.powerReserve = powerReserve;
    }

    public Integer getPrice() {
        return this.price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

}

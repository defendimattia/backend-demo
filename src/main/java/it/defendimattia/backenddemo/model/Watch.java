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

    @Size(max = 250, message = "water resistance must be max 250 characters long")
    @Column(name = "\"Water Resistance\"")
    private String waterResistance;

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

    @Size(max = 250, message = "power reserve must be max 250 characters long")
    @Column(name = "\"Power Reserve\"")
    private String powerReserve;

    @Size(max = 12, message = "price must be max 12 characters long")
    @Column(name = "\"Price (USD)\"")
    private String price;

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

    public String getWaterResistance() {
        return this.waterResistance;
    }

    public void setWaterResistance(String waterResistance) {
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

    public String getPowerReserve() {
        return this.powerReserve;
    }

    public void setPowerReserve(String powerReserve) {
        this.powerReserve = powerReserve;
    }

    public String getPrice() {
        return this.price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

}

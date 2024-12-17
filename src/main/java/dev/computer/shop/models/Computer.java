package dev.computer.shop.models;

public class Computer extends Product{

    private String brand;
    private String amount;
    private String characterics;
    private String operatingSystem;

    public Computer(float price, String brand, String amount, String characterics, String operatingSystem) {
        super(price);
        this.brand = brand;
        this.amount = amount;
        this.characterics = characterics;
        this.operatingSystem = operatingSystem;
    }

    
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getCharacterics() {
        return characterics;
    }

    public void setCharacterics(String characterics) {
        this.characterics = characterics;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    


}

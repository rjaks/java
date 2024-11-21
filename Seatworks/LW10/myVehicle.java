package Seatworks.LW10;

import java.util.*;

class Vehicle{
  private String brand, tires, model;
  public Vehicle(){
    brand = "";
    tires = "";
    model = "";
  }
  public void setBrand(String inpBrand){ brand = inpBrand; }
  public void setTires(String inpTires){ tires = inpTires; }
  public void setModel(String inpModel){ model = inpModel; }
    
  public String getBrand(){ return brand; }
  public String getTires(){ return tires; }
  public String getModel(){ return model; }

  public void displayVehicle() {
    System.out.println(
      "Brand: " + getBrand() + "\nTires: " + getTires() + "\nModel: " + getModel()
    );
    System.out.println("==================");
  }
};

class Motorcycle extends Vehicle{
  private String[] engineTypes = {"Single Cylinder", "Parallel Twin", "Inline Triple", "V Twin", "Inline Four", "Inline Six",
    "Flat Four", "Flat Six", "L Twin", "Wrapping Up"};
  private String[] fuelSystems = {"Carburetor", "Fuel-injection"};
  private String engineType, fuelSystem, brand, model, tires;
  
  public Motorcycle(String inpBrand, String inpTires, String inpModel, String inpEngineType, String inpFuelSystem) {
    brand = inpBrand;
    tires = inpTires;
    model = inpModel;
    engineType = inpEngineType;
    fuelSystem = inpFuelSystem;
  }

  public void setEngineType(String inpEngineType){ 
    boolean valueExists = false;
    for (String value : engineTypes){
      if (value == inpEngineType) {
         valueExists = true;
        engineType = inpEngineType; 
      }
    }
    if (!valueExists) System.out.println("Invalid engine type.");
  }
  public void setFuelSystem(String inpFuelSystem){ 
    boolean valueExists = false;
    for (String value : fuelSystems){
      if (value == inpFuelSystem) {
         valueExists = true;
        fuelSystem = inpFuelSystem; 
      }
    }
    if (!valueExists) System.out.println("Invalid fuel system.");
  }
  
  public String getFuelSystem(){ return fuelSystem; }
  public String getEngineType(){ return engineType; }

  public void displayVehicle() {
    System.out.println(
      "Brand: " + getBrand() + "\nTires: " + getTires() + "\nModel: " + getModel() + "\nEngine Type: " + getEngineType() + "\nFuel System: " + getFuelSystem()
    );
    System.out.println("==================");
  }
};

class Bicycle extends Vehicle {
    private String chainType, shifter, brand, model, tires;

    public Bicycle(String inpBrand, String inpModel, String inpTires, String inpChainType, String inpShifter){
        brand = inpBrand;
        model = inpModel;
        tires = inpTires;
        chainType = inpChainType;
        shifter = inpShifter;
    }

    public void setChainType(String inpChainType) { chainType = inpChainType; }
    public void setShifter(String inpShifter) { shifter = inpShifter; }

    public String getChainType() { return chainType; }
    public String getShifter() { return shifter; }

    public void displayVehicle() {
        System.out.println(
          "Brand: " + getBrand() + "\nTires: " + getTires() + "\nModel: " + getModel() + "\nChain Type: " + getChainType() + "\nShifter: " + getShifter()
        );
        System.out.println("==================");
      }
};

public class myVehicle {
    
}

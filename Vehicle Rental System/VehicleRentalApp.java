// Understanding and Working with Interfaces
import textio.TextIO;
import java.util.Map;
import java.util.HashMap;

interface Vehicle {
    String getMake();
    String getModel();
    int getYear();
}

interface CarVehicle{
    void setNumberOfDoors(int doors);
    int getNumberOfDoors();
    void setFuelType(String type);
    String getFuelType();
}

interface MotorVehicle{
    void setNumberOfWheels(int wheels);
    int getNumberOfWheels();
    void setMotorType(String type);
    String getMotorType();
}

interface TruckVehicle{
    void setCargoCapacity(int tons);
    int getCargoCapacity();
    void setTransmissionType(String type);
    String getTransmissionType();
}

class Car implements Vehicle, CarVehicle{
    private String make, model, fuelType;
    private int year, doors;
private static Map<String, Car> carList = new HashMap<>();

    // Constructors
    public Car(String make, String model, int year){
        this.make = make;
        this.model = model;
        this.year = year;
    }
    
    // implementation of Vehicles Interface
    @Override
    public String getMake(){return make;}
    @Override
    public String getModel(){return model;}
    @Override
    public int getYear(){return year;}

    // implementation of CarVehicles
    @Override
    public void setNumberOfDoors(int doors){this.doors = doors;}
    @Override
    public int getNumberOfDoors(){return doors;}
    @Override
    public void setFuelType(String type){this.fuelType = type;}
    @Override
    public String getFuelType(){return fuelType;}

    // Setter
    public void setCarList(String model, Car car){
        carList.put(model, car);
    }
    // Getter
    public Map<String, Car> getCarList(){
        return carList;
    }
}

class Motor implements Vehicle, MotorVehicle{
    private String make, model, motorType;
    private int year, wheels;
    private static Map<String, Motor> motorList = new HashMap<>();

    // Constructors
    public Motor(String make, String model, int year){
        this.make = make;
        this.model = model;
        this.year = year;
    }

    // implementation of Vehicles Interface
    @Override
    public String getMake(){return make;}
    @Override
    public String getModel(){return model;}
    @Override
    public int getYear(){return year;}

    // Implementation of MotorVehicles
    @Override
    public void setNumberOfWheels(int wheels){this.wheels = wheels;}
    @Override
    public int getNumberOfWheels(){return wheels;}
    @Override
    public void setMotorType(String type){this.motorType = type;}
    @Override
    public String getMotorType(){return motorType;}

    // Setter
    public void setMotorList(String model, Motor motor){
        motorList.put(model, motor);
    }
    // Getter
    public Map<String, Motor> getMotorList(){
        return motorList;
    }
}

class Truck implements Vehicle, TruckVehicle{
    private String make, model, transmissionType;
    private int year, cargoCap;
    private static Map<String, Truck> truckList = new HashMap<>();

    // Constructor
    public Truck(String make, String model, int year){
        this.make = make;
        this.model = model;
        this.year = year;
    }

    // Implementation of Vehicles basic
    @Override
    public String getMake(){return make;}
    @Override
    public String getModel(){return model;}
    @Override
    public int getYear(){return year;}

    // Implementation of TruckVehicles
    @Override
    public void setCargoCapacity(int tons){this.cargoCap = tons;}
    @Override
    public int getCargoCapacity(){return cargoCap;}
    @Override
    public void setTransmissionType(String type){this.transmissionType = type;}
    @Override
    public String getTransmissionType(){return transmissionType;}
    
    // Setter
    public void setTruckList(String model, Truck truck){
        truckList.put(model, truck);
    }
    //Getter
    public Map<String, Truck> getTruckList(){return truckList;}
}

public class VehicleRentalApp {

    public static void main(String[] args) {
        // Admin interface
        Vehicle vehicle = null;
        System.out.println("Choose from the Options Below:");
        System.out.println("1. Add a Car");
        System.out.println("2. Add a MotorCycle");
        System.out.println("3. Add a Truck");
        int val = TextIO.getlnInt();
        switch (val) {
            case 1:
                System.out.println("Enter Car Make: ");
                String make = TextIO.getlnString();
                System.out.println("Enter Car Model: ");
                String model = TextIO.getlnString();
                System.out.println("Enter Car Year: ");
                int year = TextIO.getlnInt();
                System.out.println("Enter Number of Doors: ");
                int doorNum = TextIO.getlnInt();
                System.out.println("Enter Fuel Type(Electric/ Petrol/ Diesel): ");
                String fuel = TextIO.getlnString();
                Car newCar = new Car(make, model, year);
                newCar.setFuelType(fuel);
                newCar.setNumberOfDoors(doorNum);
                newCar.setCarList(model, newCar);
                vehicle = newCar;
                break;
        
            case 2:
                System.out.println("Enter Motorcycle Make: ");
                String mMake = TextIO.getlnString();
                System.out.println("Enter Motorcycle Model: ");
                String mModel = TextIO.getlnString();
                System.out.println("Enter Motorcycle Year: ");
                int mYear = TextIO.getlnInt();
                System.out.println("Enter Number of Wheels: ");
                int wheelNum = TextIO.getlnInt();
                System.out.println("Enter Motorcycle Type: ");
                String type = TextIO.getlnString();
                Motor newMotor = new Motor(mMake, mModel, mYear);
                newMotor.setMotorType(type);
                newMotor.setNumberOfWheels(wheelNum);
                newMotor.setMotorList(mModel, newMotor);
                vehicle = newMotor;
                break;
            
            case 3:
                System.out.println("Enter Truck Make: ");
                String tMake = TextIO.getlnString();
                System.out.println("Enter Truck Model: ");
                String tModel = TextIO.getlnString();
                System.out.println("Enter Truck Year: ");
                int tYear = TextIO.getlnInt();
                System.out.println("Enter Truck Cargo Capacity: ");
                int cargoCap = TextIO.getlnInt();
                System.out.println("Enter Truck Transmission Type: ");
                String tType = TextIO.getlnString();
                Truck newTruck = new Truck(tMake, tModel, tYear);
                newTruck.setCargoCapacity(cargoCap);
                newTruck.setTransmissionType(tType);
                newTruck.setTruckList(tModel, newTruck);
                vehicle = newTruck;
                break;
            default:
                System.out.println("Invalid Input");
                return;
        }
        if (vehicle != null) {
            if (vehicle instanceof Car) {
                Car carDetails = (Car) vehicle; // Casting from Vehicle to Car
                System.out.println("Car Number of Doors are: " + carDetails.getNumberOfDoors());
                System.out.println("Car Fuel Type is:" + carDetails.getFuelType());
            }
            else if (vehicle instanceof Motor) {
                Motor motorDetails = (Motor) vehicle; // casting
                System.out.println("Motorcycle Number of Wheels: " + motorDetails.getNumberOfWheels());
                System.out.println("Motorcycle Type: " + motorDetails.getMotorType());
            }
            else if (vehicle instanceof Truck) {
                Truck truckDetails = (Truck) vehicle; // casting
                System.out.println("Truck Cargo Capacity: " + truckDetails.getCargoCapacity() + " tons");
                System.out.println("Truck Transmission Type: " + truckDetails.getTransmissionType());
            }
        }
    }
}
import driver.*;
import mechanic.*;
import transport.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        Car opel = new Car("opel", "astra j", 1.6, Car.BodyType.HATCHBACK);
        Car kia = new Car("kia", "rio", 1.4, Car.BodyType.SEDAN);


        Bus liaz = new Bus("ЛИАЗ", "656765", 1.0, Bus.PeopleCapacity.SMALL);
        Bus bus = new Bus("Бус", "8774", 2.0, Bus.PeopleCapacity.BIG);


        Truck man = new Truck("МАН", "8768G", 4.0, Truck.LoadCapacity.N1);
        Truck mercedec = new Truck("Мерседес", "YHHFDF8", 5.0, Truck.LoadCapacity.N2);

        DriverCategoryB driver1 = new DriverCategoryB("Годзилова Годзила Годзиловна", true, 3);
        DriverCategoryC driver2 = new DriverCategoryC("Кротов Крот Кротович", true, 4);
        DriverCategoryD driver3 = new DriverCategoryD("Бакланоов Баклан Бакланович", true, 5);

        List<Transport> allCars = new ArrayList<>();
        Collections.addAll(allCars, opel, kia, liaz, bus, man, mercedec);

        List<Driver> driverList = new ArrayList<>();
        Collections.addAll(driverList, driver1, driver2, driver3);

        Mechanic mechanic1 = new Mechanic("Бульбаш", "БеларусьАвто", CarTypes.CAR);
        mechanic1.addCategoryCarType(CarTypes.BUS);

        Mechanic mechanic2 = new Mechanic("Шпунтик", "ИнтерАвто", CarTypes.TRUCK,CarTypes.BUS);
        Mechanic mechanic3 = new Mechanic("Винтик", "АвтоМастер",CarTypes.BUS);

//        List<Mechanic> mechanicList = new ArrayList<>();
//        Collections.addAll(mechanicList, mechanic1, mechanic2, mechanic3);
//
//        System.out.println(mechanic1);
//        mechanic1.addCategoryCarType(CarTypes.TRUCK);
//        mechanic1.doMaintenance(man);
//        mechanic1.fixCar(mercedec);
//
//        opel.addMechanic(mechanic3);
//        opel.addMechanic(mechanic1);
//        opel.setDriver(driver1);
//
//        opel.printDriverAndMechanics();
        Map<Transport,Mechanic> mechanicHashMap = new HashMap<>();
        mechanicHashMap.put(opel, mechanic1);
        Set <Driver> driverSet = new HashSet<>(driverList);
        Iterator <Driver> driverIterator = driverSet.iterator();
        while (driverIterator.hasNext()){
            System.out.println(driverIterator.next());
        }
    }
}

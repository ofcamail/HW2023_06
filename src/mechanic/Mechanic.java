package mechanic;

import driver.CarTypes;
import transport.Transport;

import java.util.*;

public class Mechanic {
    private String fullName;
    private String company;
    private final List<CarTypes> carTypes;

    public Mechanic(String fullName, String company, CarTypes... carTypes) {
        this.fullName = Objects.requireNonNullElse(fullName, "fullName");
        this.company = Objects.requireNonNullElse(company, "company");
        this.carTypes = new ArrayList<>();
        Collections.addAll(this.carTypes, carTypes);
    }

    public String getFullName() {
        return fullName;
    }

    public String getCompany() {
        return company;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setCompany(String company) {
        this.company = company;
    }


    public void doMaintenance(Transport transport) {
        if (this.carTypes.contains(transport.getCarType())) {
            System.out.println(fullName + " проводит тех.обслуживание у автомобиля " + transport.getBrand());
        } else {
            System.out.println("Механик не может работать с этим авто");
        }
    }

    public void fixCar(Transport transport) {
        if (this.carTypes.contains(transport.getCarType())) {
            System.out.println(fullName + " чинит автомобиль " + transport.getBrand());
        } else {
            System.out.println("Механик не может работать с этим авто");
        }
    }

    public List<CarTypes> getCarTypes() {
        return carTypes;
    }

    public void addCategoryCarType(CarTypes carTypes) {
        if (!this.carTypes.contains(carTypes)) {
            this.carTypes.add(carTypes);
        }
    }
    @Override
    public String toString() {
        return "Имя: " + fullName + '\'' +
                "Компания: " + company + '\'' +
                "Тип автомобилей: " + carTypes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mechanic mechanic = (Mechanic) o;
        return Objects.equals(fullName, mechanic.fullName) && Objects.equals(company, mechanic.company) && Objects.equals(carTypes, mechanic.carTypes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fullName, company, carTypes);
    }
}
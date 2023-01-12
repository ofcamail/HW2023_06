package transport;

import driver.CarTypes;
import driver.DriverCategoryD;

public class Bus extends Transport<DriverCategoryD> {
    public enum PeopleCapacity {
        EXTRA_SMALL(null, 10),
        SMALL(null, 25),
        AVERAGE(40, 50),
        BIG(60, 80),
        EXTRA_BIG(100, 120);
        private final Integer minPeopleCapacity;
        private final Integer maxPeopleCapacity;

        PeopleCapacity(Integer minPeopleCapacity, Integer maxPeopleCapacity) {
            this.minPeopleCapacity = minPeopleCapacity;
            this.maxPeopleCapacity = maxPeopleCapacity;
        }

        public Integer getMinPeopleCapacity() {
            return minPeopleCapacity;
        }

        public Integer getMaxPeopleCapacity() {
            return maxPeopleCapacity;
        }

        @Override
        public String toString() {
            if (minPeopleCapacity == null) {
                return "Вместимость: до " + maxPeopleCapacity + " мест";
            } else {
                return "Вместимость: " + minPeopleCapacity + " - " + maxPeopleCapacity + " мест";
            }
        }
    }

    private PeopleCapacity peopleCapacity;

    public Bus(String brand, String model, double engineVolume, PeopleCapacity peopleCapacity) {
        super(brand, model, engineVolume);
        this.peopleCapacity = peopleCapacity;
    }

    public PeopleCapacity getPeopleCapacity() {
        return peopleCapacity;
    }

    public void setPeopleCapacity(PeopleCapacity peopleCapacity) {
        this.peopleCapacity = peopleCapacity;
    }

    @Override
    public void printType() {
        if (peopleCapacity != null) {
            System.out.println(peopleCapacity);
        } else {
            System.out.println("Данных по транспортному средству недостаточно");
        }
    }

    @Override
    public void letsGo() {
        System.out.println("Водитель " + getDriver() + " управляет автомобилем " + getBrand() + " и будет участвовать в заезде");
    }

    @Override
    public void doDiagnostics(){
        throw new UnsupportedOperationException("Транспортное средство не может пройти диагностику");
    }

    @Override
    public String toString() {
        return super.toString() + " " + peopleCapacity;
    }

    @Override
    public CarTypes getCarType() {
        return CarTypes.BUS;
    }


}
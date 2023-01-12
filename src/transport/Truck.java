package transport;

import driver.DriverCategoryC;
import driver.CarTypes;

public class Truck extends Transport<DriverCategoryC> {

    public enum LoadCapacity {
        N1(null, 3.5f),
        N2(0f, 3.5f),
        N3(12f, null);
        private final Float minLoadCapacity;
        private final Float maxLoadCapacity;

        LoadCapacity(Float minLoadCapacity, Float maxLoadCapacity) {
            this.minLoadCapacity = minLoadCapacity;
            this.maxLoadCapacity = maxLoadCapacity;
        }

        public Float getMinLoadCapacity() {
            return minLoadCapacity;
        }

        public Float getMaxLoadCapacity() {
            return maxLoadCapacity;
        }

        @Override
        public String toString() {
            if (minLoadCapacity == null) {
                return "Грузоподъемность: до " + maxLoadCapacity + " тонн";
            } else if (maxLoadCapacity == null) {
                return "Грузоподъемность: от " + minLoadCapacity + " тонн";
            } else {
                return "Грузоподъемность: от " + minLoadCapacity + " тонн до " + maxLoadCapacity + " тонн";
            }
        }
    }

    private LoadCapacity loadCapacity;

    public Truck(String brand, String model, double engineVolume, LoadCapacity loadCapacity) {
        super(brand, model, engineVolume);
        this.loadCapacity = loadCapacity;
    }

    public LoadCapacity getLoadCapacityType() {
        return loadCapacity;
    }

    public void setLoadCapacity(LoadCapacity loadCapacity) {
        this.loadCapacity = loadCapacity;
    }


    @Override
    public void printType() {
        if (loadCapacity != null) {
            System.out.println(loadCapacity);
        } else {
            System.out.println("Данных по транспортному средству недостаточно");
        }
    }

    @Override
    protected void doDiagnostics() throws WrongDriverException {
        if (getDriver().getDriverLicense() == null) {
            throw new NullPointerException("Необходимо указать тип прав!");
        }
        if (!getDriver().getDriverLicense().equals(CarTypes.TRUCK)) {
            throw new WrongDriverException("Неверный тип прав!");
        }
    }

    @Override
    public void letsGo() {
        System.out.println("Водитель " + getDriver() + " управляет автомобилем " + getBrand() + " и будет участвовать в заезде");
    }

    @Override
    public String toString() {
        return super.toString() + " " + loadCapacity;
    }
    @Override
    public CarTypes getCarType() {
        return CarTypes.TRUCK;
    }
}
package transport;
import driver.*;
import mechanic.Mechanic;
import java.util.ArrayList;
import java.util.List;

public abstract class Transport<T extends Driver> implements Competing {
    private String brand;
    private String model;
    private double engineVolume;
    private final List<Mechanic> mechanics = new ArrayList<>();
    private T driver;

    public Transport(String brand, String model, double engineVolume) {
        if (brand == null || brand.isEmpty() || brand.isBlank()) {
            this.brand = "default";
        } else {
            this.brand = brand;
        }
        if (model == null || model.isEmpty() || model.isBlank()) {
            this.model = "default";
        } else {
            this.model = model;
        }
        if (engineVolume <= 0) {
            this.engineVolume = 0.5;
        } else {
            this.engineVolume = engineVolume;
        }
    }

    public String getBrand() {
        return brand;
    }

    public final void setBrand(String brand) {
        if (brand == null || brand.isEmpty() || brand.isBlank()) {
           this.brand = "default";
        } else {
            this.brand = brand;
        }
    }

    public String getModel() {
        return model;
    }

    public final void setModel(String model) {
        if (model == null || model.isEmpty() || model.isBlank()) {
            this.model = "default";
        } else {
            this.model = model;
        }
    }

    public double getEngineVolume() {
        return engineVolume;
    }

    public final void setEngineVolume(int engineVolume) {
        if (engineVolume > 0) {
            this.engineVolume = 1.5;
        } else {
            this.engineVolume = engineVolume;
        }
    }

    public final T getDriver() {
        return driver;
    }

    public final void setDriver(T driver) {
        this.driver = driver;
    }

    public abstract void printType();

    @Override
    public void getPitStop() {
        System.out.println("Пит-стоп");
    }

    @Override
    public void getBestLapTime() {
        System.out.println("Лучшее время круга");
    }

    @Override
    public void getMaxSpeed() {
        System.out.println("Максимальная скорость");
    }

    public abstract void letsGo();

    public void checkExceptionsDiagnostics() {
        try {
            doDiagnostics();
        } catch (WrongDriverException | NullPointerException e) {
            RuntimeException runtimeException = new RuntimeException("Ехать нельзя", e);
            runtimeException.printStackTrace();
        }
    }

    protected abstract void doDiagnostics() throws WrongDriverException, NullPointerException;

    @Override
    public String toString() {
        return "Марка: " + brand +
                " Модель: " + model +
                " Объем двигателя: " + engineVolume;
    }

    public void addMechanic(Mechanic mechanic) {
        if (mechanic.getCarTypes().contains(getCarType())) {
            mechanics.add(mechanic);
            System.out.println(mechanic.getFullName() + " работает с автомобилем " + getBrand());
        } else {
            System.out.println(mechanic.getFullName() + " не умеет работать с" + getCarType());
        }
    }

    public void printDriverAndMechanics() {
        System.out.println("Автомобиль: " + getModel());
        if (getDriver() != null) {
            System.out.println("Водитель: " + getDriver());
        }
        if (getMechanics() != null) {
            System.out.println("Механники: " + getMechanics());
        }
    }
    public abstract CarTypes getCarType();

    public List<Mechanic> getMechanics() {
        return mechanics;
    }
}
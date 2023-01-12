package transport;

import driver.DriverCategoryB;
import driver.CarTypes;

public class Car extends Transport<DriverCategoryB> {

    public enum BodyType {
        SEDAN("Седан"),
        HATCHBACK("Хетчбек"),
        COUPE("Купе"),
        UNIVERSAL("Универсал"),
        SUV("Внедорожник"),
        CROSSOVER("Кроссовер"),
        PICKUP("Пикап"),
        VAN("Фургон"),
        MINIVAN("Минивэн");

        private final String russianName;

        BodyType(String russianName) {
            this.russianName = russianName;
        }

        public String getRussianName() {
            return russianName;
        }

        @Override
        public String toString() {
            return "Тип кузова: " + russianName;
        }
    }

    private BodyType bodyType;

    public Car(String brand, String model, double engineVolume, BodyType bodyType) {
        super(brand, model, engineVolume);
        this.bodyType = bodyType;
    }

    public BodyType getBodyType() {
        return bodyType;
    }

    public void setBodyType(BodyType bodyType) {
        this.bodyType = bodyType;
    }

    @Override
    protected void doDiagnostics() throws WrongDriverException {
        if (getDriver().getDriverLicense() == null) {
            throw new NullPointerException("Необходимо указать тип прав!");
        }
        if (!getDriver().getDriverLicense().equals(CarTypes.CAR)) {
            throw new WrongDriverException("Неверный тип прав!");
        }
    }

    @Override
    public void printType() {
        if (bodyType != null) {
            System.out.println(bodyType);
        } else {
            System.out.println("Данных по транспортному средству недостаточно");
        }
    }

    @Override
    public void letsGo() {
        System.out.println("Водитель " + getDriver() + " управляет автомобилем " + getBrand() + " и будет участвовать в заезде");
    }

    @Override
    public String toString() {
        return super.toString() + " " + bodyType;
    }
    @Override
    public CarTypes getCarType() {
        return CarTypes.CAR;
    }
}
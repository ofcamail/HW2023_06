package driver;

public class DriverCategoryB extends Driver {
    CarTypes carTypes;
    public DriverCategoryB(String fullName, boolean haveDriverLicense, int experience) {
        super(fullName, haveDriverLicense, experience);
    }
    public CarTypes getDriverLicense() {
        return carTypes;
    }

    public void setDriverLicense(CarTypes carTypes) {
        this.carTypes = carTypes;
    }
}
package driver;

public class DriverCategoryD extends Driver {
    CarTypes carTypes;
    public DriverCategoryD(String fullName, boolean haveDriverLicense, int experience) {
        super(fullName, haveDriverLicense, experience);
    }

    public CarTypes getDriverLicense() {
        return carTypes;
    }
    public void setDriverLicense(CarTypes carTypes) {
        this.carTypes = carTypes;
    }
}
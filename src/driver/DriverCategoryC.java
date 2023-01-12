package driver;

public class DriverCategoryC extends Driver{
    CarTypes carTypes;
    public DriverCategoryC(String fullName, boolean haveDriverLicense, int experience) {
        super(fullName, haveDriverLicense, experience);
    }

    public CarTypes getDriverLicense() {
        return carTypes;
    }
    public void setDriverLicense(CarTypes carTypes) {
        this.carTypes = carTypes;
    }
}
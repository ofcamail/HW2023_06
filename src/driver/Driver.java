package driver;

import java.util.Objects;

public abstract class Driver {
    private String fullName;
    private boolean haveDriverLicense;
    private final int experience;

    public Driver(String fullName, boolean haveDriverLicense, int experience) {
        if (fullName == null || fullName.isEmpty() || fullName.isBlank()) {
            this.fullName = "driver";
        } else {
            this.fullName = fullName;
        }
        this.haveDriverLicense = haveDriverLicense;
        this.experience = Math.max(experience, 0);

    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        if (fullName == null || fullName.isEmpty() || fullName.isBlank()) {
            System.out.println("Вы задали неверное значение! Попробуйте еще раз.");
        } else {
            this.fullName = fullName;
        }
    }

    public boolean isHaveDriverLicense() {
        return haveDriverLicense;
    }

    public void setHaveDriverLicense(boolean haveDriverLicense) {
        this.haveDriverLicense = haveDriverLicense;
    }

    public int getExperience() {
        return experience;
    }
    public void startDriving() {
        System.out.println("начинает движение");
    }

    public void stopDriving() {
        System.out.println("останавливается");
    }

    public void refuelCar() {
        System.out.println("заправляет авто");
    }

    public String toString() {
        return fullName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Driver driver = (Driver) o;
        return haveDriverLicense == driver.haveDriverLicense && experience == driver.experience && Objects.equals(fullName, driver.fullName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fullName, haveDriverLicense, experience);
    }
}
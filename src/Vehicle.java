public class Vehicle {
    private String type;
    private String manufacturer;
    private String model;
    private int year;
    private int mileage;
    private String vinNumber;

    public Vehicle() {
    }

    public Vehicle(String type, String manufacturer, String model, int year, int mileage, String vinNumber) {
        this.type = type;
        this.manufacturer = manufacturer;
        this.model = model;
        this.year = year;
        this.mileage = mileage;
        this.vinNumber = vinNumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public String getVinNumber() {
        return vinNumber;
    }

    public void setVinNumber(String vinNumber) {
        this.vinNumber = vinNumber;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "type='" + type + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", mileage=" + mileage +
                ", vinNumber='" + vinNumber + '\'' +
                '}';
    }
}

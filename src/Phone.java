public class Phone extends ProductCategory{
    private String color;
    private int battery;

    public Phone(int id, double price, String name, Brand brand, int ram, double screen, int discountRate, int capacity, int stock,String color,int battery) {
        super(id, price, name, brand, ram, screen, discountRate, capacity, stock);
        this.color=color;
        this.battery=battery;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getBattery() {
        return battery;
    }

    public void setBattery(int battery) {
        this.battery = battery;
    }
}

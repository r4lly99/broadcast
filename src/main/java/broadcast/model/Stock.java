package broadcast.model;

public class Stock {

    public String time;
    public String code;
    public String price;

    public Stock() {
    }

    public Stock(String time, String code, String price) {
        this.time = time;
        this.code = code;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Stock{" +
                "time='" + time + '\'' +
                ", code='" + code + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}

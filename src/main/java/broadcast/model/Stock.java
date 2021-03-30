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

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}

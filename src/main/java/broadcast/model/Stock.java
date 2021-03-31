package broadcast.model;

import broadcast.dto.StockDTO;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Stock {

    private LocalDateTime time;
    private String code;
    private int price;

    public Stock() {
    }

    public Stock(LocalDateTime time, String code, int price) {
        this.time = time;
        this.code = code;
        this.price = price;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public LocalDateTime getDateTime(String time){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MMM-dd HH:mm:ss");
        return LocalDateTime.parse(time, formatter);
    }

    public Stock convertToEntity(StockDTO stockDTO){
        Stock stock = new Stock();
        int price = Integer.parseInt(stockDTO.getPrice());
        stock.setTime(getDateTime(stockDTO.getTime()));
        stock.setCode(stockDTO.getCode());
        stock.setPrice(price);
        return stock;
    }


    @Override
    public String toString() {
        return "Stock{" +
                "time=" + time +
                ", code='" + code + '\'' +
                ", price=" + price +
                '}';
    }
}

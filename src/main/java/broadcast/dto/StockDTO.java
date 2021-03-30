package broadcast.dto;

public class StockDTO {

    private String time;
    private String code;
    private String price;

    public StockDTO() {
    }

    public StockDTO(String time, String code, String price) {
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

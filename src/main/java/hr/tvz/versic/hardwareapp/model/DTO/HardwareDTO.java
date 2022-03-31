package hr.tvz.versic.hardwareapp.model.DTO;

import java.io.Serializable;

public class HardwareDTO implements Serializable {
    private String name;
    private Double price;

    public HardwareDTO(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    public HardwareDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }


}

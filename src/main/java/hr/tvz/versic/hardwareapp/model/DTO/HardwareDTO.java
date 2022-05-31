package hr.tvz.versic.hardwareapp.model.DTO;

import hr.tvz.versic.hardwareapp.command.HardwareCommand;
import hr.tvz.versic.hardwareapp.enums.HardwareType;

import java.io.Serializable;

public class HardwareDTO implements Serializable {
    private String name;
    private Double price;
    private String code;
    private HardwareType type;
    private Integer stock;

    public HardwareDTO(String name, Double price, String code, HardwareType type, Integer stock) {
        this.name = name;
        this.price = price;
        this.code = code;
        this.type = type;
        this.stock = stock;
    }

    public HardwareDTO() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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

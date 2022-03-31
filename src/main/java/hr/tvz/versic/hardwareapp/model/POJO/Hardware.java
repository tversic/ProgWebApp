package hr.tvz.versic.hardwareapp.model.POJO;

import hr.tvz.versic.hardwareapp.enums.HardwareType;

import java.io.Serializable;

public class Hardware implements Serializable {
    private String name;
    private String code;
    private Double price;
    private HardwareType hardwareType;

    public Hardware() {
    }

    public Hardware(String name, String code, Double price, HardwareType hardwareType) {
        this.name = name;
        this.code = code;
        this.price = price;
        this.hardwareType = hardwareType;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public HardwareType getHardwareType() {
        return hardwareType;
    }

    public void setHardwareType(HardwareType hardwareType) {
        this.hardwareType = hardwareType;
    }

}

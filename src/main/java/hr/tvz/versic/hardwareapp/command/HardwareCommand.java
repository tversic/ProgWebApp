package hr.tvz.versic.hardwareapp.command;

import hr.tvz.versic.hardwareapp.enums.HardwareType;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

public class HardwareCommand {

    @NotEmpty(message = "name can't be left empty")
    private String name;

    @NotEmpty(message = "code can't be left empty")
    private String code;

    @NotNull(message = "price can't be left empty")
    @PositiveOrZero(message = "price cant be negative")
    private Double price;

    @NotNull
    private HardwareType hardwareType;

    @NotNull(message = "stock can't be left empty")
    @PositiveOrZero(message = "stock cant be negative")
    private Integer stock;

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

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }
}

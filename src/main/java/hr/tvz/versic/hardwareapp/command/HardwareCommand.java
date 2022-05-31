package hr.tvz.versic.hardwareapp.command;

import hr.tvz.versic.hardwareapp.enums.HardwareType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HardwareCommand {


    @NotEmpty(message = "name can't be left empty")
    private String name;

    @NotEmpty(message = "code can't be left empty")
    private String code;

    @NotNull(message = "price can't be left empty")
    @PositiveOrZero(message = "price cant be negative")
    private Double price;

    @NotNull(message = "type musnt be left empty")
    private HardwareType type;

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

    public HardwareType getType() {
        return type;
    }

    public void setHardwareType(HardwareType hardwareType) {
        this.type = hardwareType;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }
}

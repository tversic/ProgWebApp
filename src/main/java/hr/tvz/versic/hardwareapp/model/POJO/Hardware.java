package hr.tvz.versic.hardwareapp.model.POJO;

import hr.tvz.versic.hardwareapp.enums.HardwareType;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "hardware")
public class Hardware implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "code")
    private String code;

    @Column(name= "price")
    private Double price;

    @Column(name = "type")
    private String type;

    @Column(name = "stock")
    private Integer stock;

    @OneToMany(mappedBy = "hardware", fetch = FetchType.EAGER)
    private List<Review> review;

    private HardwareType hardwareType;
    public Hardware() {
    }

    public Hardware(String name, String code, Double price, String hardwareType, Integer stock) {
        this.name = name;
        this.code = code;
        this.price = price;
        this.type = hardwareType;
        this.stock = stock;
    }
    public Hardware(Long id, String name, String code, Double price, String hardwareType, Integer stock) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.price = price;
        this.type = hardwareType;
        this.stock = stock;
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

    public HardwareType getType() {
        return hardwareType;
    }

    public void setType(String type) {
        hardwareType = HardwareType.valueOf(type) ;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Integer getStock() {
        return stock;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Review> getReview() {
        return review;
    }

    public void setReview(List<Review> review) {
        this.review = review;
    }


}

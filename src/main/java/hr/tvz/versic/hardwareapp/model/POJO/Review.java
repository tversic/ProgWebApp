package hr.tvz.versic.hardwareapp.model.POJO;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "review")
public class Review implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "tekst")
    private String tekst;

    @Column(name = "ocjena")
    private Integer grade;

    @ManyToOne
    @JoinColumn(name = "id_hardware")
    private Hardware hardware;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String naslov) {
        this.name = naslov;
    }

    public String getTekst() {
        return tekst;
    }

    public void setTekst(String tekst) {
        this.tekst = tekst;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setOcjena(Integer ocjena) {
        this.grade = ocjena;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Review review = (Review) o;
        return Objects.equals(id, review.id) && Objects.equals(name, review.name) && Objects.equals(tekst, review.tekst) && Objects.equals(grade, review.grade) && Objects.equals(hardware, review.hardware);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, tekst, grade, hardware);
    }
}

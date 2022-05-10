package hr.tvz.versic.hardwareapp.model.POJO;

import hr.tvz.versic.hardwareapp.enums.StarsGrade;

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
    private String ocjena;

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

    public String getOcjena() {
        return ocjena;
    }

    public void setOcjena(String ocjena) {
        this.ocjena = ocjena;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Review review = (Review) o;
        return Objects.equals(id, review.id) && Objects.equals(name, review.name) && Objects.equals(tekst, review.tekst) && Objects.equals(ocjena, review.ocjena) && Objects.equals(hardware, review.hardware);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, tekst, ocjena, hardware);
    }
}

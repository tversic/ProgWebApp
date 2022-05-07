package hr.tvz.versic.hardwareapp.model.POJO;

import hr.tvz.versic.hardwareapp.enums.StarsGrade;

import javax.persistence.*;
import java.io.Serializable;

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
}

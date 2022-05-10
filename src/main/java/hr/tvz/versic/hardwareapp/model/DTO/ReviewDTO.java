package hr.tvz.versic.hardwareapp.model.DTO;

public class ReviewDTO {

    private String name;
    private String tekst;
    private String ocjena;

    public ReviewDTO() {
    }

    public ReviewDTO(String name, String tekst, String ocjena) {
        this.name = name;
        this.tekst = tekst;
        this.ocjena = ocjena;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

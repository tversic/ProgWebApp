package hr.tvz.versic.hardwareapp.model.DTO;

public class ReviewDTO {

    private String title;
    private String text;
    private Integer rating;

    public ReviewDTO() {
    }

    public ReviewDTO(String name, String tekst, Integer ocjena) {
        this.title = name;
        this.text = tekst;
        this.rating = ocjena;
    }

    public String getTitle() {
        return title;
    }

    public void setName(String name) {
        this.title = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String tekst) {
        this.text = tekst;
    }

    public Integer getRating() {
        return rating;
    }

    public void setOcjena(Integer ocjena) {
        this.rating = ocjena;
    }
}

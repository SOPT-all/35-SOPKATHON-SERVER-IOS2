package jungleEscape.member.entity;

import jakarta.persistence.*;

@Entity
@Table(name="images")
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column
    Integer level;

    @Column
    String image;

    public Image(Integer level, String image){
        this.level = level;
        this.image = image;
    }

    public Image(){}

    public Long getId(){
        return id;
    }

    public Integer getLevel(){
        return level;
    }

    public String getImage(){
        return image;
    }

}

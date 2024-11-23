package jungleEscape.member.entity;

import jakarta.persistence.*;

@Entity
@Table(name="members")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column
    Integer exp=70;

    @Column
    Integer level=1;

    String imgUrl;

    public Member(
            Integer exp,
            Integer level
    ){
        this.exp = exp;
        this.level = level;
    }

    public Member(){}

    public Long getId(){
        return id;
    }

    public Integer getExp(){
        return exp;
    }

    public Integer getLevel(){
        return level;
    }
    public String getImgUrl(){
        return imgUrl;
    }
    public void setImgUrl(String imgUrl){
        this.imgUrl = imgUrl;
    }
}



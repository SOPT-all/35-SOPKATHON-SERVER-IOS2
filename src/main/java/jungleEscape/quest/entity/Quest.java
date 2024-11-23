package jungleEscape.quest.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "quests")
public class Quest {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String summary;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private int level;

    @Column(nullable = false)
    private int exp;

}

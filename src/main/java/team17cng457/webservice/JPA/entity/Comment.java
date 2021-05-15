package team17cng457.webservice.JPA.entity;

import javax.persistence.*;


@Table(name = "comment")

@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "comment_id")
    private int comment_id;

    @Column(name = "star_rating")
    private int starRating;

    @Column(name = "star_comment")
    private String starComment;

    @ManyToOne(targetEntity = Device.class)
    private Device device;
}

package team17cng457.webservice.JPA.entity;

import javax.persistence.Column;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;


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

}

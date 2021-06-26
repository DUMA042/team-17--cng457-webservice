package team17cng457.webservice.JPA.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * JPA representation of a comment
 */
@Table(name = "comment")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Comment {

    /**
     *  unique integer id for comment
     */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "comment_id")
    private long commentid;

    /**
     *  star rating for the comment. 1 to 5
     */
    @Column(name = "star_rating")
    private int starRating;

    /**
     *  comment string for the review
     */
    @Column(name = "star_comment")
    private String starComment;

    /**
     *  m2o relation for comments and devices
     */
    @ManyToOne(targetEntity = Device.class)
    @JoinColumn(name="device_id")
    private Device device;
}

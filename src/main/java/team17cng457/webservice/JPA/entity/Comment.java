package team17cng457.webservice.JPA.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Table(name = "comment")

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "comment_id")
    private long commentID;

    @Column(name = "star_rating")
    private int starRating;

    @Column(name = "star_comment")
    private String starComment;

    @ManyToOne(targetEntity = Device.class)
    @JoinColumn(name="device_id")
    private Device device;
}

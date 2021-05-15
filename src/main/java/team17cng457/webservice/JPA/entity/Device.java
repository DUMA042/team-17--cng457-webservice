package team17cng457.webservice.JPA.entity;

import javax.persistence.*;

@Entity
@Table(name = "device")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "device_type", discriminatorType = DiscriminatorType.INTEGER)
public class Device {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "device_id")
    private int computer_id;

    //0 = unknown, 1 = computer, 2 = phone
    @Column(name = "device_type", insertable = false, updatable = false)
    private int device_type = 0;

    @Column(name = "brand")
    private String brand;

    @Column(name = "model")
    private String model;

    @Column(name = "screen_size")
    private String screenSize;

    @Column(name = "price")
    private float price;

    @OneToMany
    private List<Comment> comments;

}

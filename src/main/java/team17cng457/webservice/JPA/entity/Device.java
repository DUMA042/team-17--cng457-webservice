package team17cng457.webservice.JPA.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;



@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "device")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "device_type", discriminatorType = DiscriminatorType.INTEGER)
public class Device {

    public static final int COMPUTER_TYPE = 0;
    public static final int PHONE_TYPE = 1;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "device ID")
    private long device_id;

    //0 = unknown, 1 = computer, 2 = phone
    @Column(name = "device_type", insertable = false, updatable = false)
    private int device_type = COMPUTER_TYPE;

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
    @ManyToMany
    private List<AdditionalFeature> features;

}

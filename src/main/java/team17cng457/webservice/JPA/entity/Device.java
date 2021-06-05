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
@DiscriminatorColumn(name = "device_type", discriminatorType = DiscriminatorType.INTEGER, columnDefinition = "INTEGER")
public class Device {

    public static final int COMPUTER_TYPE = 0;
    public static final int PHONE_TYPE = 1;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "device_id")
    private long deviceid;

    //0 = computer, 1 = phone
    @Column(name = "device_type", insertable = false, updatable = false)
    private int devicetype;

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

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
    protected long deviceid;

    //0 = computer, 1 = phone
    @Column(name = "device_type", insertable = false, updatable = false)
    protected int devicetype;

    @Column(name = "brand")
    protected String brand;

    @Column(name = "model")
    protected String model;

    @Column(name = "screen_size")
    protected String screenSize;

    @Column(name = "price")
    protected float price;

    @OneToMany
    protected List<Comment> comments;
    @ManyToMany
    protected List<AdditionalFeature> features;

}

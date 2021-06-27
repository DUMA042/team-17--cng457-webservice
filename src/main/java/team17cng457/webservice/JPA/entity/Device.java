package team17cng457.webservice.JPA.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;


/**
 *  JPA representation of a device.
 *
 * Contains shared attributes between computer and phone
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "device")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "device_type", discriminatorType = DiscriminatorType.INTEGER, columnDefinition = "INTEGER")
public class Device {

    /**
     *  static value for computer identifier. Used for joined device table.
     */
    public static final int COMPUTER_TYPE = 0;

    /**
     *  static value for phone identifier. Used for joined device table.
     */
    public static final int PHONE_TYPE = 1;

    /**
     *  unique integer identifier for device id.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "device_id")
    protected long deviceid;


    /**
     *  device type in the database. Device.PHONE_TYPE or Device.COMPUTER_TYPE
     */
    @Column(name = "device_type", insertable = false, updatable = false)
    protected int devicetype;

    /**
     *  brand name for the device
     */
    @Column(name = "brand")
    protected String brand;

    /**
     *  device model
     */
    @Column(name = "model")
    protected String model;

    /**
     *  screen size. Format: 16", 18", 21"
     */
    @Column(name = "screen_size")
    protected String screensize;

    /**
     *  price for the dveice
     */
    @Column(name = "price")
    protected float price;

    /**
     *  mapping for comments on this device
     */
    @OneToMany(cascade = CascadeType.ALL,
            orphanRemoval = true)
    protected List<Comment> comments;

    public void addComment(Comment c){
        comments.add(c);
    }

    /**
     *  mapping for any additional features this device might have
     */
    @ManyToMany
    protected List<AdditionalFeature> features;

}

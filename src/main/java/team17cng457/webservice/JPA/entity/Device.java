package team17cng457.webservice.JPA.entity;

import javax.persistence.*;

@MappedSuperclass
public class Device {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "device_id")
    private int computer_id;

    @Column(name = "brand")
    private String brand;

    @Column(name = "model")
    private String model;

    @Column(name = "screen_size")
    private String screenSize;

    @Column(name = "price")
    private float price;

}

package team17cng457.webservice.JPA.entity;

import javax.persistence.Column;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

@Table(name = "computer")

@Entity
public class Computer {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "computer_id")
    private int computer_id;

    @Column(name = "brand")
    private String brand;

    @Column(name = "model")
    private String model;

    @Column(name = "screen_size")
    private String screenSize;

    @Column(name = "price")
    private float price;

    @Column(name = "storage_capacity")
    private int storageCapacity;

    @Column(name = "processor")
    private String processor;

    @Column(name = "screen_resolution")
    private String screenResolution;

    @Column(name = "memory")
    private int memory;
}

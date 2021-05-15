package team17cng457.webservice.JPA.entity;


import javax.persistence.*;

@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Entity
public class Computer extends Device{

    @Column(name = "device_type", insertable = false, updatable = false)
    private int device_type = 1;

    @Column(name = "storage_capacity")
    private int storageCapacity;

    @Column(name = "processor")
    private String processor;

    @Column(name = "screen_resolution")
    private String screenResolution;

    @Column(name = "memory")
    private int memory;
}

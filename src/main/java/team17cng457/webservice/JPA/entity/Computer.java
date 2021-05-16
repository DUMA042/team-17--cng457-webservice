package team17cng457.webservice.JPA.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
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

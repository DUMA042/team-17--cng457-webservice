package team17cng457.webservice.JPA.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@DiscriminatorValue("0")
public class Computer extends Device{

    @Column(name = "storage_capacity")
    private int storagecapacity;

    @Column(name = "processor")
    private String processor;

    @Column(name = "screen_resolution")
    private String screenResolution;

    @Column(name = "memory")
    private int memory;
}

package team17cng457.webservice.JPA.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 *  JPA representation of a computer. Extended from device
 */
@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@DiscriminatorValue("0")
public class Computer extends Device{
    /**
     *  internal constructor for computer
     * @param brand brand name
     * @param model device model
     * @param screenSize screen size, 16", 18", 21"
     * @param price Price in USD$
     * @param storagecapacity storage capacity in GB's
     * @param processor Full name of the processor.
     * @param screenResolution Screen resolution, like 1920x1080
     * @param memory Device RAM in MB's
     */
    public Computer(String brand, String model, String screenSize,float price, int storagecapacity, String processor, String screenResolution, int memory){
        super(0, COMPUTER_TYPE,brand,model,screenSize,price,null,null);
        this.storagecapacity=storagecapacity;
        this.processor=processor;
        this.screenresolution=screenResolution;
        this.memory=memory;
    }

    /**
     *  storage capacity in GB's
     */
    @Column(name = "storage_capacity")
    private int storagecapacity;

    /**
     *  processor name
     */
    @Column(name = "processor")
    private String processor;

    /**
     *  Screen resolution, widthxheight format. 1920x1080
     */
    @Column(name = "screen_resolution")
    private String screenresolution;

    /**
     *  memory in MB's
     */
    @Column(name = "memory")
    private int memory;
}

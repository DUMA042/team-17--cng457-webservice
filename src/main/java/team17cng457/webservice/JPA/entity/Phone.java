package team17cng457.webservice.JPA.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 *  JPA representation of a phone. Extended from device.
 */
@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@DiscriminatorValue("1")
public class Phone extends Device{
    /**
     *  internal constructor for the phone class
     * @param brand phone brand
     * @param model device model
     * @param screenSize screen size. 5", 6", 8" etc.
     * @param price price for the phone
     * @param Internal_memory devices internal memory
     */
    public Phone(String brand, String model, String screenSize,float price, int Internal_memory){
        super(0, COMPUTER_TYPE,brand,model,screenSize,price,null,null);
        this.internalmemory = Internal_memory;
    }

    /**
     *  device specific attribute of internal memory
     */
    @Column(name = "internal_memory")
    private int internalmemory;
}

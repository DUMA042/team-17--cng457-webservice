package team17cng457.webservice.JPA.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@DiscriminatorValue("1")
public class Phone extends Device{
    public Phone(String brand, String model, String screenSize,float price, int Internal_memory){
        super(0,Device.COMPUTER_TYPE,brand,model,screenSize,price,null,null);
        this.internalmemory = Internal_memory;
    }
    @Column(name = "internal_memory")
    private int internalmemory;
}

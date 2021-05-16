package team17cng457.webservice.Service;

import org.springframework.beans.factory.annotation.Autowired;
import team17cng457.webservice.JPA.entity.Device;
import team17cng457.webservice.Repository.DeviceRepository;

import java.util.List;

public class Device_Service {
    @Autowired
    private DeviceRepository devicerep;

    public Device saveDevice(Device device){
        return devicerep.save(device);
    }
    public List<Device> getdevices(){
        return devicerep.findAll();
    }
    public List<Device> getdevices_order(long number){
        /*gets all the number from 0 to n(Number)*/
        return devicerep.findAll(0,number);
    }

}

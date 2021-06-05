package team17cng457.webservice.Service;

import org.springframework.beans.factory.annotation.Autowired;
import team17cng457.webservice.JPA.entity.Device;
import team17cng457.webservice.Repository.DeviceRepository;

import java.util.List;

public abstract class Device_Service {
    @Autowired
    private DeviceRepository devicerep;

    public Device saveDevice(Device device){
        return devicerep.save(device);
    }
    public List<Device> getdevices(){
       return devicerep.findAll();
    }

    public List<Device> FindDevice(int device_type){return devicerep.findBydevice_type(device_type);}

    public List<Device> FindDeviceById(int id){return devicerep.findBydevice_id(id);}

    public List<Device> FindDevice(int type, String brand){return devicerep.findBydevice_typeAndbrand(type,brand);}

}

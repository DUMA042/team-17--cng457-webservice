package team17cng457.webservice.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team17cng457.webservice.JPA.entity.Computer;
import team17cng457.webservice.JPA.entity.Device;
import team17cng457.webservice.JPA.entity.Phone;
import team17cng457.webservice.Repository.DeviceRepository;

import java.util.List;

@Service
public class DeviceService {
    @Autowired
    private DeviceRepository devicerep;

    public Device saveDevice(Device device){
        return devicerep.save(device);
    }
    public List<Device> getdevices(){
       return devicerep.findAll();
    }

    public List<Device> FindDevice(int device_type){return devicerep.findBydevicetype(device_type);}

    public List<Device> FindDeviceById(long id){return devicerep.findBydeviceid(id);}

    public List<Device> FindDevice(int type, String brand){return devicerep.findByDevicetypeAndBrand(type,brand);}


    /*public List<Device> SearchComputers(String brand,
                                          String model,
                                          String screensize,
                                          float price,
                                          int storagecapacity,
                                          String processor,
                                          String screenResolution,
                                          int memory){
        return devicerep.findByDevicetypeAndBrandStartsWithAndModelStartsWithAndScreensizeStartsWithAndPriceStartsWithAndStoragecapacityStartsWithAndProcessorstartswithStartsWithAndScreenresolutionStartsWithAndMemoryStartsWith(
                Device.COMPUTER_TYPE,
                brand,
                model,
                screensize,
                price,
                storagecapacity,
                processor,
                screenResolution,
                memory);
    }*/

}

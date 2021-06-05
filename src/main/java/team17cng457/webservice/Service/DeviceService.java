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

    public List<Phone> SearchPhones(String brand,
                                    String model,
                                    String screensize,
                                    float minprice,
                                    float maxprice,
                                    int mininternalmemory,
                                    int maxinternalmemory){
        //I hate that this is possible and that it works.
        //While i'm having so much fun because of this, im sure i saw way, way worse stuff in production.
        //IT JUST WORKS
        return devicerep.findByDevicetypeAndBrandStartsWithAndModelStartsWithAndScreensizeStartsWithAndPriceGreaterThanAndPriceLessThanAndInternalmemoryGreaterThanAndInternalmemoryLessThan(
                Device.PHONE_TYPE,
                brand,
                model,
                screensize,
                minprice,
                maxprice,
                mininternalmemory,
                maxinternalmemory);
    }
    public List<Computer> SearchComputers(String brand,
                                          String model,
                                          String screenSize,
                                          float minprice,
                                          float maxprice,
                                          int minstoragecapacity,
                                          int maxstoragecapacity,
                                          String processor,
                                          String screenResolution,
                                          int minmemory,
                                          int maxmemory){
        //I hate that this is possible and that it works.
        //While i'm having so much fun because of this, im sure i saw way, way worse stuff in production.
        //IT JUST WORKS
        return devicerep.findByDevicetypeAndBrandStartsWithAndModelStartsWithAndScreensizeStartsWithAndPriceGreaterThanAndPriceLessThanAndStoragecapacityGreaterThanAndStoragecapacityLessThanAndProcessorStartsWithAndScreenresolutionStartsWithAndMemoryGreaterThanAndMemoryLessThan(
                Device.COMPUTER_TYPE,
                brand,
                model,
                screenSize,
                minprice,
                maxprice,
                minstoragecapacity,
                maxstoragecapacity,
                processor,
                screenResolution,
                minmemory,
                maxmemory);
    }

}

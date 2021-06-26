package team17cng457.webservice.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team17cng457.webservice.JPA.entity.Computer;
import team17cng457.webservice.JPA.entity.Device;
import team17cng457.webservice.JPA.entity.Phone;
import team17cng457.webservice.Repository.DeviceRepository;

import java.util.List;

/**
 *  Spring Service for devices
 */
@Service
public class DeviceService {
    /**
     *  autowired spring device repository
     */
    @Autowired
    private DeviceRepository devicerep;

    /**
     *  Save a device to the repository
     * @param device device object
     * @return saved device
     */
    public Device saveDevice(Device device){
        return devicerep.save(device);
    }

    /**
     *  get all the devices from the repository
     * @return List of all the devices in the repository
     */
    public List<Device> getdevices(){
       return devicerep.findAll();
    }

    /**
     *  find device with device type.
     * @param device_type  Device.PHONE_TYPE or Device.COMPUTER_TYPE
     * @return list of matching devices
     */
    public List<Device> FindDevice(int device_type){return devicerep.findBydevicetype(device_type);}

    /**
     *  find device with the matching id
     * @param id ID of the device to find
     * @return requested device
     */
    public List<Device> FindDeviceById(long id){return devicerep.findBydeviceid(id);}

    /**
     *  Find a device with its type and brand
     * @param type Device.PHONE_TYPE or Device.COMPUTER_TYPE
     * @param brand Brand name
     * @return list of matching devices
     */
    public List<Device> FindDevice(int type, String brand){return devicerep.findByDevicetypeAndBrand(type,brand);}

    /**
     *  delete all the devices in the repository. Used by tests.
     */
    public void DeleteAll(){devicerep.deleteAll();}

    /**
     *  search phones for matching criterias
     * @param brand optional brand name to check
     * @param model optional model name to check
     * @param screensize optional screen size to match
     * @param minprice minimum price for the dveice
     * @param maxprice maximum price for the device
     * @param mininternalmemory minimum memory for the device
     * @param maxinternalmemory maxiumum memory for the device
     * @return list of all matching devices
     */
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

    /**
     /**
     *
     * @param brand Optional brand name to match.
     * @param model Optional device model
     * @param screenSize Optional screensize for the device.
     * @param minprice minimum price for the devices to find
     * @param maxprice maximum price for the devices to find
     * @param minstoragecapacity minimum hard disk space for devices to find
     * @param maxstoragecapacity maximum hard disk space for devices to find
     * @param processor Optional processor name
     * @param screenResolution Screem resolution, like 1920x1080
     * @param minmemory minimum memory for devices to find
     * @param maxmemory maximum memory for devices to find.
     * @return List of all matching devices
     */
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

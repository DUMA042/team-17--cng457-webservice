package team17cng457.webservice.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.transaction.annotation.Transactional;
import team17cng457.webservice.JPA.entity.Computer;
import team17cng457.webservice.JPA.entity.Device;
import team17cng457.webservice.JPA.entity.Phone;

import javax.persistence.LockModeType;
import java.util.List;
import java.util.Optional;

/**
 *  JPA repository for devices
 */
public interface DeviceRepository extends JpaRepository<Device,Long> {

    /**
     * Save a device
     * @param d Device to save
     * @return saved devicez
     */
    @Lock(LockModeType.PESSIMISTIC_WRITE)
    public Device save(Device d);
    /**
     *  find all computers or phones
     * @param device_type type of the device to find. Device.PHONE_TYPE or Device.COMPUTER_TYPE.
     * @return JSONArray of all the devices of that type
     */
    public List<Device> findBydevicetype(int device_type);

    /**
     *  find specific device (phone or computer)
     * @param device_id id of the device to find
     * @return Requested device
     */
    public List<Device> findBydeviceid(long device_id);

    /**
     *  find phone or computer by brand
     * @param devicetype type of the device to find. Device.PHONE_TYPE or Device.COMPUTER_TYPE.
     * @param brand Brand of the phone to find
     * @return List of all the devices with given brand
     */
    public List<Device> findByDevicetypeAndBrand(int devicetype, String brand);

    //I hate that this is possible and that it works.
    //While i'm having so much fun because of this, im sure i saw way, way worse stuff in production.
    //IT JUST WORKS

    /**
     *  Search. With all optional parameters
     *
     * IT JUST WORKS
     * I was hoping i wouldn't need to document this one
     * @param devicetype type of the device to find. Device.PHONE_TYPE or Device.COMPUTER_TYPE.
     * @param brand Optional brand name to match.
     * @param model Optional device model
     * @param screensize Optional screensize for the device.
     * @param minprice minimum price for the devices to find
     * @param maxprice maximum price for the devices to find
     * @param mininternalmemory minimum memory for devices to find
     * @param maxinternalmemory maximum memory for devices to find.
     * @return List of all matching phones
     */
    public List<Phone> findByDevicetypeAndBrandStartsWithAndModelStartsWithAndScreensizeStartsWithAndPriceGreaterThanAndPriceLessThanAndInternalmemoryGreaterThanAndInternalmemoryLessThan(
            int devicetype,
            String brand,
            String model,
            String screensize,
            float minprice,
            float maxprice,
            int mininternalmemory,
            int maxinternalmemory);

    /**
     *
     * @param devicetype type of the device to find. Device.PHONE_TYPE or Device.COMPUTER_TYPE.
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
    public List<Computer> findByDevicetypeAndBrandStartsWithAndModelStartsWithAndScreensizeStartsWithAndPriceGreaterThanAndPriceLessThanAndStoragecapacityGreaterThanAndStoragecapacityLessThanAndProcessorStartsWithAndScreenresolutionStartsWithAndMemoryGreaterThanAndMemoryLessThan(
            int devicetype,
            String brand,
            String model,
            String screenSize,
            float minprice,
            float maxprice,
            int minstoragecapacity,
            int maxstoragecapacity,
            String processor,
            String screenResolution,
            int minmemory,
            int maxmemory
    );

}

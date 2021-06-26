package team17cng457.webservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import team17cng457.webservice.JPA.entity.Phone;
import team17cng457.webservice.Service.DeviceService;
import team17cng457.webservice.JPA.entity.Computer;
import team17cng457.webservice.JPA.entity.Device;

import java.util.List;

/**
 *  Spring Controller class for Devices
 */
@RestController
public class DeviceController {

    /**
     *  Autowired Spring service for devices
     */
    @Autowired
    DeviceService device_service;

    /**
     *  Post request mapping for devices
     * @param r JSON Serialized device from post request body
     * @return added device
     */
    @PostMapping("/device/add")
    public Device Save(@RequestBody Device r){
        return device_service.saveDevice(r);
    }

    /**
     *  Post request mapping for phones
     * @param r JSON Serialized phone from post request body
     * @return added phone
     */
    @PostMapping("/phone/add")
    public Device Save(@RequestBody Phone r){
        return device_service.saveDevice(r);
    }

    /**
     *  Post request mapping for computers
     * @param r JSON Serialized computer from post request body
     * @return added computer
     */
    @PostMapping("/computer/add")
    public Device Save(@RequestBody Computer r){
        return device_service.saveDevice(r);
    }

    /**
     *  Get all computers in JSONArray
     * @return JSONArray of all the computers in the system
     */
    @GetMapping("/computer/get")
    public List<Device> GetComputers(){
        return device_service.FindDevice(Device.COMPUTER_TYPE);
    }

    /**
     *  Get all phones in JSONArray
     * @return JSONArray of all the phones in the system
     */
    @GetMapping("/phone/get")
    public List<Device> GetPhones() {
        return device_service.FindDevice(Device.PHONE_TYPE);
    }

    /**
     *  Get all devices in JSONArray
     * @return JSONArray of all the devices in the system
     */
    @GetMapping("/device/get")
    public List<Device> GetDeviceByID(long id){
        return device_service.FindDeviceById(id);
    }


    /**
     *  Search through computers with optional parameters
     * @param brand Optional URL parameter for computer brand
     * @param model Optional URL parameter for computer model
     * @param screenSize Optional URL parameter for computer screen size
     * @param minprice Optional URL parameter for minimum price. Default is 0
     * @param maxprice Optional URL parameter for maximum price. Default is 9999999
     * @param minstoragecapacity Optional URL parameter for minimum storage capacity. Default is 0
     * @param maxstoragecapacity Optional URL parameter for maximum storage capacity. Default is 9999999
     * @param processor Optional URL parameter for processor model
     * @param screenResolution Optional URL parameter for screenResolution
     * @param minmemory optional URL parameter for minimum device memory. Default is 0
     * @param maxmemory optional URL parameter for maximum device memory. Default is 9999999
     * @return JSONArray of requested computers
     */
    @GetMapping("/computer/search")
    public List<Computer> SearchComputer(   @RequestParam(defaultValue = "") String brand,
                                            @RequestParam(defaultValue = "") String model,
                                            @RequestParam(defaultValue = "") String screenSize,
                                            @RequestParam(defaultValue = "0") float minprice,
                                            @RequestParam(defaultValue = "9999999") float maxprice,
                                            @RequestParam(defaultValue = "0") int minstoragecapacity,
                                            @RequestParam(defaultValue = "9999999") int maxstoragecapacity,
                                            @RequestParam(defaultValue = "") String processor,
                                            @RequestParam(defaultValue = "") String screenResolution,
                                            @RequestParam(defaultValue = "0") int minmemory,
                                            @RequestParam(defaultValue = "9999999") int maxmemory

    ){
        return device_service.SearchComputers(  brand,
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

    /**
     *  Search through phones with optional parameters
     *
     * @param brand Optional URL parameter for phone brand
     * @param model Optional URL parameter for phone model
     * @param screensize Optional URL parameter for phone screen size
     * @param minprice Optional URL parameter for minimum price. Default is 0
     * @param maxprice Optional URL parameter for maximum price. Default is 9999999
     * @param minmem optional URL parameter for minimum device memory. Default is 0
     * @param maxmem optional URL parameter for maximum device memory. Default is 9999999
     * @return JSONArray of requested computers
     */
    @GetMapping("/phone/search")
    public List<Phone> SearchPhone(@RequestParam(defaultValue = "") String brand,
                                   @RequestParam(defaultValue = "") String model,
                                   @RequestParam(defaultValue = "") String screensize,
                                   @RequestParam(defaultValue = "0") float minprice,
                                   @RequestParam(defaultValue = "9999999") float maxprice,
                                   @RequestParam(defaultValue = "0") int minmem,
                                   @RequestParam(defaultValue = "9999999") int maxmem){
        return device_service.SearchPhones( brand,
                model,
                screensize,
                minprice,
                maxprice,
                minmem,
                maxmem);
    }







    /*
    //populate db with test devices
    @GetMapping("/test/populate")
    public Device PopulateWithTestData(){
        Computer c1 = new Computer("Dell","D1239", "1920x1080",12941,2048,"Intel 1234", "1920x1080",16900);
        Computer c2 = new Computer("Tell","D1239", "1920x1080",12941,2048,"Intel 1234", "1920x1080",16900);
        Computer c3 = new Computer("Apple","D1239", "1920x1080",12941,2048,"Intel 1234", "1920x1080",16900);
        //Comment cm1 = new Comment(1,12,"12334",c1);
        device_service.saveDevice(c1);
        device_service.saveDevice(c2);
        device_service.saveDevice(c3);

        Phone p1 = new Phone("Apple", "Iphone 123", "1920x1080", 12312, 4096);
        Phone p2 = new Phone("Samsung", "sam 123", "1920x1080", 12312, 4096);
        Phone p3 = new Phone("Xiaomi", "xi 123", "1920x1080", 12312, 4096);

        device_service.saveDevice(p1);
        device_service.saveDevice(p2);
        return device_service.saveDevice(p3);
    }
    */

}

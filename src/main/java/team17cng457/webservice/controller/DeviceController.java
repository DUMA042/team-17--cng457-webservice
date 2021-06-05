package team17cng457.webservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import team17cng457.webservice.JPA.entity.Comment;
import team17cng457.webservice.JPA.entity.Computer;
import team17cng457.webservice.JPA.entity.Device;
import team17cng457.webservice.JPA.entity.Phone;
import team17cng457.webservice.Service.DeviceService;

import java.util.List;

@RestController
public class DeviceController {
    @Autowired
    DeviceService device_service;

    @PostMapping("/device/add")
    public Device Save(@RequestBody Device r){
        return device_service.saveDevice(r);
    }

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

    /*@GetMapping("/computer/get")
    public List<Device> GetComputers(){
        return device_service.FindDevice(Device.COMPUTER_TYPE);
    }*/



    @GetMapping("/device/get")
    public List<Device> GetDeviceByID(long id){
        return device_service.FindDeviceById(id);
    }

    /*@GetMapping("/computer/search")
    public List<Device> SearchComputer(@RequestParam(defaultValue = "") String brand,
                                       @RequestParam(defaultValue = "") String model,
                                       @RequestParam(defaultValue = "") String screenSize,float price,
                                       @RequestParam(defaultValue = "") int storagecapacity,
                                       @RequestParam(defaultValue = "") String processor,
                                       @RequestParam(defaultValue = "") String screenResolution,
                                       @RequestParam(defaultValue = "") int memory){
        return device_service.SearchComputers(brand,
                                         model,
                                         screenSize,
                                         price,
                                         storagecapacity,
                                         processor,
                                         screenResolution,
                                         memory);
    }*/


}

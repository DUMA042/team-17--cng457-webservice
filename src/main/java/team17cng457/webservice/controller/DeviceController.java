package team17cng457.webservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import team17cng457.webservice.JPA.entity.Computer;
import team17cng457.webservice.JPA.entity.Device;
import team17cng457.webservice.JPA.entity.Phone;
import team17cng457.webservice.Service.DeviceService;

import java.util.List;

@RestController
public class DeviceController {
    @Autowired
    DeviceService device_service;

    @PostMapping("/")
    public String index(@RequestBody Device r){
        return "Hello";
    }

    @PostMapping("/error")
    public String error(@RequestBody Device r){
        return "Hello";
    }

    @PostMapping("/device/add")
    public Device Save(@RequestBody Device r){
        return device_service.saveDevice(r);
    }

    @GetMapping("/computer/test")
    public Device testcomputer(){
        Computer c = new Computer();

        return device_service.saveDevice(c);
    }

    @GetMapping("/phone/test")
    public Device testphone(){
        Phone p = new Phone();

        return device_service.saveDevice(p);
    }

    @GetMapping("/computer/get")
    public List<Device> GetComputers(){
        return device_service.FindDevice(Device.COMPUTER_TYPE);
    }

    @GetMapping("/phone/get")
    public List<Device> GetPhones(){
        return device_service.FindDevice(Device.PHONE_TYPE);
    }

    @GetMapping("/device/get")
    public List<Device> GetDeviceByID(long id){
        return device_service.FindDeviceById(id);
    }

    @GetMapping("/computer/get/{brand}")
    public List<Device> GetComputerByBrand(String brand){
        return device_service.FindDevice(Device.COMPUTER_TYPE, brand);
    }

    @GetMapping("/phone/get/{brand}")
    public List<Device> GetPhoneByBrand(String brand){
        return device_service.FindDevice(Device.PHONE_TYPE, brand);
    }
}

package team17cng457.webservice.JPA.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import team17cng457.webservice.JPA.entity.Computer;
import team17cng457.webservice.JPA.entity.Device;
import team17cng457.webservice.Service.Device_Service;

import java.util.List;

public class DeviceController {
    @Autowired
    Device_Service device_service;

    @PostMapping("/device/add")
    public Device Save(@RequestBody Device r){
        return device_service.saveDevice(r);
    }

    @PostMapping("/computer/get")
    public List<Device> GetComputers(@RequestBody Device r){
        return device_service.FindDevice(Device.COMPUTER_TYPE);
    }

    @PostMapping("/phone/get")
    public List<Device> get(@RequestBody Device r){
        return device_service.FindDevice(Device.PHONE_TYPE);
    }


    @PostMapping("/device/get/{id}")
    public List<Device> GetComputerByID(@RequestBody Device r){
        return device_service.FindDevice(Device.COMPUTER_TYPE);
    }

}

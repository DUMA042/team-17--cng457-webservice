package team17cng457.webservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import team17cng457.webservice.JPA.entity.Computer;
import team17cng457.webservice.JPA.entity.Device;
import team17cng457.webservice.JPA.entity.Phone;
import team17cng457.webservice.Service.DeviceService;
import team17cng457.webservice.Service.PhoneService;

import java.util.List;

@RestController
public class PhoneController {
    @Autowired
    PhoneService phone_service;

    @PostMapping("/phone/add")
    public Phone Save(@RequestBody Phone r){
        return phone_service.saveDevice(r);
    }

    @GetMapping("/phone/get")
    public List<Phone> GetPhones() {
        return phone_service.GetPhones();
    }

    @GetMapping("/phone/byid")
    public List<Phone> GetPhones(int id) {
        return phone_service.GetPhones();
    }

    @GetMapping("/phone/search")
    public List<Phone> SearchPhone(@RequestParam(defaultValue = "") String brand,
                                    @RequestParam(defaultValue = "") String model,
                                    @RequestParam(defaultValue = "") String screensize,
                                    @RequestParam(defaultValue = "0") float minprice,
                                    @RequestParam(defaultValue = "9999999") float maxprice,
                                    @RequestParam(defaultValue = "0") int minmem,
                                    @RequestParam(defaultValue = "9999999") int maxmem){
        return phone_service.SearchPhones( brand,
                model,
                screensize,
                minprice,
                maxprice,
                minmem,
                maxmem);
    }
}

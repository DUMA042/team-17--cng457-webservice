package team17cng457.webservice.service;


import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.event.annotation.BeforeTestClass;
import team17cng457.webservice.JPA.entity.Computer;
import team17cng457.webservice.JPA.entity.Device;
import team17cng457.webservice.JPA.entity.Phone;
import team17cng457.webservice.Repository.DeviceRepository;
import team17cng457.webservice.Service.DeviceService;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DeviceServiceTest {

    @InjectMocks
    DeviceService deviceService;

    @Mock
    DeviceRepository mockDeviceRepository;
    

    @BeforeEach
    void initMockDeviceRepo(){
        Device d1 = new Computer("Dell","d1","16",1200,1024,"Intel i7-6969","1920x1080",16000);

        Device d2 = new Computer("Tell","d2","18",2200,512,"Intel i7-7979","1920x1080",24000);


        Device d3 = new Phone("Samsung", "d3", "5\"", 800, 4096);

        Device d4 = new Phone("Apple", "d4", "6\"", 1800, 2096);

        List<Device> phones = new ArrayList<>();
        List<Device> computers = new ArrayList<>();
        computers.add(d1);
        computers.add(d2);
        phones.add(d3);
        phones.add(d4);

        List<Device> devices = new ArrayList<>();
        devices.add(d1);
        //devices.add(d2);
        //devices.add(d3);
        //devices.add(d4);

        deviceRepository.saveAll(computers);
        deviceRepository.saveAll(phones);
        lenient().when(deviceRepository.findBydevicetype(Device.COMPUTER_TYPE)).thenReturn(new ArrayList<Device>(computers));

        lenient().when(deviceRepository.findBydevicetype(Device.PHONE_TYPE)).thenReturn(new ArrayList<Device>(phones));

        lenient().when(deviceRepository.findBydeviceid(any(Integer.class))).thenReturn(new ArrayList<Device>(devices));
    }

    @Test
    void findPhones(){
        List<Device> phones = deviceRepository.findBydevicetype(Device.PHONE_TYPE);
        Assertions.assertEquals(phones.get(0).getBrand(), "Samsung");
        Assertions.assertEquals(phones.get(0).getModel(), "d3");
        Assertions.assertEquals(phones.get(1).getBrand(), "Apple");
        Assertions.assertEquals(phones.get(1).getModel(), "d4");
    }

    @Test
    void findComputers(){
        List<Device> computers = deviceRepository.findBydevicetype(Device.COMPUTER_TYPE);
        Assertions.assertEquals(computers.get(0).getBrand(), "Dell");
        Assertions.assertEquals(computers.get(0).getModel(), "d1");
        Assertions.assertEquals(computers.get(1).getBrand(), "Tell");
        Assertions.assertEquals(computers.get(1).getModel(), "d2");

    }

    @Test
    void findDeviceById(){
        Device d1 = deviceRepository.findBydeviceid(0).get(0);

        Assertions.assertEquals(d1.getModel(), "d1");
    }

    @Test
    void searchPhone(){

    }

    @Test
    void searchComputer(){

    }


}

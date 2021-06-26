package team17cng457.webservice.Service;


import org.junit.jupiter.api.*;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import team17cng457.webservice.JPA.entity.Computer;
import team17cng457.webservice.JPA.entity.Device;
import team17cng457.webservice.JPA.entity.Phone;

import java.util.List;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;


/**
 *  Test class for testing Device Controller
 *  Uses the application-test.properties file for staging environment.
 *
 *  DOES NOT work on the production data
 */
@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@SpringBootTest
class DeviceServiceTest extends DeviceService{

    // I don't like mockito. Too cumbersome to mock the whole JPA repository.
    // I feel like staging database with seperate environment is much more preferable
    // (Controlled by seperate application.properties file via @ActiveProfiles)
    /*@InjectMocks
    DeviceService mockDeviceService;
    @Mock
    DeviceRepository mockDeviceRepository;*/


    /**
     * Reinitialize staging database before each test case
     * (so no false positive/negatives from test cases influencing each other)
     */
    @BeforeEach
    void initStagingDB(){
        System.out.println("Initializing staging database");
        Device d1 = new Computer("Dell","d1","16",1200,1024,"Intel i7-6969","1920x1080",16000);
        Device d2 = new Computer("Tell","d2","18",2200,124,"AMD r7979","1920x1080",24000);
        Device d3 = new Phone("Samsung", "d3", "5\"", 700, 4096);
        Device d4 = new Phone("Apple", "d4", "6\"", 1800, 2096);
        Device d5 = new Phone("Xiaomi", "d5", "6\"", 512, 400);

        this.saveDevice(d1);
        this.saveDevice(d2);
        this.saveDevice(d3);
        this.saveDevice(d4);
        this.saveDevice(d5);

        // OLD MOCKITO STYLE TESTING (I DONT LIKE THIS SORRY)
        /*
        List<Device> phones = new ArrayList<>();
        List<Device> computers = new ArrayList<>();
        computers.add(d1);
        computers.add(d2);
        phones.add(d3);
        phones.add(d4);
        List<Device> devices = new ArrayList<>();

        mockDeviceRepository.saveAll(computers);
        mockDeviceRepository.saveAll(phones);
        lenient().when(mockDeviceRepository.findBydevicetype(Device.COMPUTER_TYPE)).thenReturn(new ArrayList<Device>(computers));
        lenient().when(mockDeviceRepository.findBydevicetype(Device.PHONE_TYPE)).thenReturn(new ArrayList<Device>(phones));*/

    }

    /**
     * Cleanup the staging database after each run
     */
    @AfterEach
    void cleanupStagingDB(){
        this.DeleteAll();
    }


    /**
     * Test if init staging db was successful
     */
    @Test
    void TestFindPhones(){
        List<Device> phones = this.FindDevice(Device.PHONE_TYPE);
        Assertions.assertEquals(phones.get(0).getBrand(), "Samsung");
        Assertions.assertEquals(phones.get(0).getModel(), "d3");
        Assertions.assertEquals(phones.get(1).getBrand(), "Apple");
        Assertions.assertEquals(phones.get(1).getModel(), "d4");
    }

    /**
     * Test if init staging db was successful
     */
    @Test
    void TestFindComputers(){
        List<Device> computers = this.FindDevice(Device.COMPUTER_TYPE);
        Assertions.assertEquals(computers.get(0).getBrand(), "Dell");
        Assertions.assertEquals(computers.get(0).getModel(), "d1");
        Assertions.assertEquals(computers.get(1).getBrand(), "Tell");
        Assertions.assertEquals(computers.get(1).getModel(), "d2");

    }

    /**
     * Generate a random device and save it in the repository. Check if it exists.
     */
    @Test
    void TestSaveDevice(){
        UUID uuid = java.util.UUID.randomUUID();
        Device d1 = new Computer(uuid.toString(), uuid.toString(),"16",1200,1024,"Intel i7-6969","1920x1080",16000);
        this.saveDevice(d1);
        Device d2 = this.SearchComputers(uuid.toString(), uuid.toString(), "",0,999999,0,999999,"", "", 0,9999999).get(0);

        Assertions.assertEquals(d1.getBrand(), d2.getBrand());
        Assertions.assertEquals(uuid.toString(), d2.getBrand());
    }

    /**
     * Test search by price range
     */
    @Test 
    void TestSearchPhonePriceLimit(){
        Device d1 = this.SearchPhones("", "", "",500,1500,0,999999).get(0);
        Assertions.assertTrue(d1.getPrice() > 500);
        Assertions.assertTrue(d1.getPrice() < 1500);
    }

    /**
     * Test impossible query and assert result size as 0 (min price larger than maxprice)
     */
    @Test 
    void TestBadSearchPhonePriceLimit(){
        List<Phone> phones = this.SearchPhones("", "", "",1500,1000,0,999999);
        Assertions.assertEquals(phones.size(), 0);
    }

    /**
     * Search phone by brand
     */
    @Test 
    void searchPhoneBrand(){
        Device d1 = this.SearchPhones("Apple", "", "",0,999999,0,999999).get(0);
        Assertions.assertEquals(d1.getBrand(), "Apple");
    }

    /**
     * Search phone by memory
     */
    @Test 
    void searchPhoneMemory(){
        Phone p1 = this.SearchPhones("", "", "",0,999999,0,500).get(0);
        Assertions.assertTrue(p1.getInternalmemory() < 500);
    }

    /**
     * Search computer by screensize
     */
    @Test 
    void searchComputerScreensize(){
        Computer c1 = this.SearchComputers("", "", "",0,999999,0,999999,"", "1920x1080", 0,9999999).get(0);
        Assertions.assertEquals(c1.getScreenresolution(), "1920x1080");
    }

    /**
     * Search computer by storage
     */
    @Test 
    void searchComputerStorage(){
        Computer c1 = this.SearchComputers("", "", "",0,999999,0,500,"", "", 0,9999999).get(0);
        Assertions.assertTrue(c1.getStoragecapacity() < 500);
    }

    /**
     * Search computer by processor
     */
    @Test 
    void searchComputerProcessor(){
        Computer c1 = this.SearchComputers("", "", "",0,999999,0,999999,"AMD", "", 0,9999999).get(0);
        Assertions.assertTrue(c1.getProcessor().startsWith("AMD"));
    }
}

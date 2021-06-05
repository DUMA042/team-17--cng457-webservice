package team17cng457.webservice.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team17cng457.webservice.JPA.entity.Computer;
import team17cng457.webservice.JPA.entity.Device;
import team17cng457.webservice.JPA.entity.Phone;
import team17cng457.webservice.Repository.PhoneRepository;

import java.util.List;

@Service
public class PhoneService {
    @Autowired
    private PhoneRepository phonerepository;

    public Phone saveDevice(Phone phone){
        return phonerepository.save(phone);
    }
    public List<Phone> GetPhones(){
        return phonerepository.findAll();
    }



    public List<Phone> SearchPhones(String brand,
                                    String model,
                                    String screensize,
                                    float minprice,
                                    float maxprice,
                                    int mininternalmemory,
                                    int maxinternalmemory){
        return phonerepository.findByDevicetypeAndBrandStartsWithAndModelStartsWithAndScreensizeStartsWithAndPriceGreaterThanAndPriceLessThanAndInternalmemoryGreaterThanAndInternalmemoryLessThan(
                Device.PHONE_TYPE,
                brand,
                model,
                screensize,
                minprice,
                maxprice,
                mininternalmemory,
                maxinternalmemory);
    }


}

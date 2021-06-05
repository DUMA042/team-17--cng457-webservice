package team17cng457.webservice.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import team17cng457.webservice.JPA.entity.Computer;
import team17cng457.webservice.JPA.entity.Device;
import team17cng457.webservice.JPA.entity.Phone;

import java.util.List;


public interface PhoneRepository extends JpaRepository<Phone,Long> {

    //find all computers or phones
    public List<Phone> findBydevicetype(int device_type);



    public List<Phone> findByDevicetypeAndBrandStartsWithAndModelStartsWithAndScreensizeStartsWithAndPriceGreaterThanAndPriceLessThanAndInternalmemoryGreaterThanAndInternalmemoryLessThan(
            int devicetype,
            String brand,
            String model,
            String screensize,
            float minprice,
            float maxprice,
            int mininternalmemory,
            int maxinternalmemory);

}

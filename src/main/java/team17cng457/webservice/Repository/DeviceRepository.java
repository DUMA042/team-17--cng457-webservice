package team17cng457.webservice.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import team17cng457.webservice.JPA.entity.Device;

import java.util.List;


public interface DeviceRepository extends JpaRepository<Device,Long> {

    //find all computers or phones
    public List<Device> findBydevicetype(int device_type);

    //find specific device (phone or computer)
    public List<Device> findBydeviceid(long device_id);

    //find phone or computer by brand
    public List<Device> findByDevicetypeAndBrand(int devicetype, String brand);

}

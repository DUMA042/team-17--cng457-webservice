package team17cng457.webservice.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import team17cng457.webservice.JPA.entity.Device;

import java.util.List;


public interface DeviceRepository extends JpaRepository<Device,Long> {

    //find all computers or phones
    public List<Device> findBydevice_type(int device_type);

    //find specific device (phone or computer)
    public List<Device> findBydevice_id(int device_id);

    //find phone or computer by brand
    public List<Device> findBydevice_typeAndbrand(int device_type, String brand);

    //find by AdditionalFeature
    //public List<Device> findBydevice_typeAdditionalfeature(AdditionalFeature feature);

}

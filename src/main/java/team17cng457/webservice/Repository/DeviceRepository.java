package team17cng457.webservice.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import team17cng457.webservice.JPA.entity.Device;

import java.util.List;

public interface DeviceRepository extends JpaRepository<Device,Long> {


}

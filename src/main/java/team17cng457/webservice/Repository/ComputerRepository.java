package team17cng457.webservice.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import team17cng457.webservice.JPA.entity.Computer;

public interface ComputerRepository extends JpaRepository<Computer,Long> {
}

package team17cng457.webservice.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import team17cng457.webservice.JPA.entity.Comment;
import team17cng457.webservice.JPA.entity.Device;

public interface CommentRepository extends JpaRepository<Comment,Long> {
}

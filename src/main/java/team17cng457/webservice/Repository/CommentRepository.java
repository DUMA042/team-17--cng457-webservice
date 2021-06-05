package team17cng457.webservice.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import team17cng457.webservice.JPA.entity.Comment;
import team17cng457.webservice.JPA.entity.Device;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment,Long> {

    //find comment with ID
    public Comment findCommentBycommentid(long comment_id);

}

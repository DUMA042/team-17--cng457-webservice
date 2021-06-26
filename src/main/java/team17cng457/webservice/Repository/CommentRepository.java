package team17cng457.webservice.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import team17cng457.webservice.JPA.entity.Comment;

/**
 *  JPA repository for comments
 */
public interface CommentRepository extends JpaRepository<Comment,Long> {

    /**
     *  find comment with a given ID
     * @param comment_id id of the comment to find
     * @return Requested comment
     */
    public Comment findCommentBycommentid(long comment_id);

}

package team17cng457.webservice.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.transaction.annotation.Transactional;
import team17cng457.webservice.JPA.entity.Comment;

import javax.persistence.LockModeType;

/**
 *  JPA repository for comments
 */
public interface CommentRepository extends JpaRepository<Comment,Long> {

    /**
     * Save a comment. Locks for both read and write
     * @param c comment to save
     * @return saved comment
     */
    @Lock(LockModeType.PESSIMISTIC_WRITE)
    public Comment save(Comment c);

    /**
     *  find comment with a given ID
     * @param comment_id id of the comment to find
     * @return Requested comment
     */
    public Comment findCommentBycommentid(long comment_id);

}

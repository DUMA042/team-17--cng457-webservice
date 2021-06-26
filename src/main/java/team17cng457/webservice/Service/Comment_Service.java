package team17cng457.webservice.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team17cng457.webservice.JPA.entity.Comment;
import team17cng457.webservice.Repository.CommentRepository;

/**
 *  Spring Service for comments
 */
@Service
public class Comment_Service {
    /**
     *  autowired Spring comment repository
     */
    @Autowired
    private CommentRepository Commentrep;

    /**
     *  Save a comment in the database
     * @param comment comment object
     * @return saved object
     */
    public Comment saveComment(Comment comment){
        return Commentrep.save(comment);
    }

    /**
     *  get a comment with given id
     * @param comment_id id of the comment
     * @return Requetsed comment
     */
    public Comment getComment(long comment_id){
        return  Commentrep.findCommentBycommentid(comment_id);
    }
}

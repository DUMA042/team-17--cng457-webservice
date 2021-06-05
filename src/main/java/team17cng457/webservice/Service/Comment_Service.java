package team17cng457.webservice.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team17cng457.webservice.JPA.entity.Comment;
import team17cng457.webservice.JPA.entity.Device;
import team17cng457.webservice.Repository.CommentRepository;
import team17cng457.webservice.Repository.DeviceRepository;

@Service
public class Comment_Service {
    @Autowired
    private CommentRepository Commentrep;

    public  Comment saveComment(Comment comment){
        return Commentrep.save(comment);
    }

    public Comment getComment(long comment_id){
        return  Commentrep.findCommentBycommentid(comment_id);
    }
}

package team17cng457.webservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import team17cng457.webservice.JPA.entity.Comment;
import team17cng457.webservice.Service.Comment_Service;


/**
 *  Spring Controller class for Comments
 */
@RestController
public class CommentController {
    /**
     *  Autowired Spring service for features
     */
    @Autowired
    Comment_Service comment_service;

    /**
     *  Post request mapping for adding a comment.
     * @param comment JSON Serialized comment from post request body
     * @return created comment
     */
    @PostMapping("/Comment/add")
    public Comment Save(@RequestBody Comment comment){
        return comment_service.saveComment(comment);
    }

    /**
     *  Get request mapping for comments
     * @param id ID of the comment to return
     * @return Requested comment
     */
    @GetMapping("/Comment/get")
    public Comment getComment(int id){
        return comment_service.getComment(id);
    }



}

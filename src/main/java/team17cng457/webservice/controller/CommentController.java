package team17cng457.webservice.controller;

import org.hibernate.annotations.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import team17cng457.webservice.JPA.entity.Comment;
import team17cng457.webservice.Service.Comment_Service;




@RestController
public class CommentController {
    @Autowired
    Comment_Service comment_service;

    @PostMapping("/Comment/add")
    public Comment Save(@RequestBody Comment comment){
        return comment_service.saveComment(comment);
    }

    @GetMapping("/Comment/get")
    public Comment getComment(int id){
        return comment_service.getComment(id);
    }



}

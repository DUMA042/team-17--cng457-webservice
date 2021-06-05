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
/*
    @GetMapping("/test/populate")
    public Comment PopulateWithTestData(){
        Computer c1 = new Computer("Dell","D1239", "1920x1080",12941,2048,"Intel 1234", "1920x1080",16900);

        Comment cm1 = new Comment(1,12,"12334",c1);
        comment_service.saveComment(cm1);
        return cm1;
    }*/


}

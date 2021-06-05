package team17cng457.webservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import team17cng457.webservice.JPA.entity.AdditionalFeature;
import team17cng457.webservice.Service.AddfeatureService;

@RestController
public class AddfeatureController {
    @Autowired
    AddfeatureService addfeature_service;

    @PostMapping("/AdditionalFeature/add")
    public AdditionalFeature Save(@RequestBody AdditionalFeature comment){
        return addfeature_service.savefeature(comment);
    }
}

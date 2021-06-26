package team17cng457.webservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import team17cng457.webservice.JPA.entity.AdditionalFeature;
import team17cng457.webservice.Service.AddfeatureService;

/**
 *  Spring Controller class for features
 */
@RestController
public class AddfeatureController {
    /**
     *  Autowired Spring service for features
     */
    @Autowired
    AddfeatureService addfeature_service;

    /**
     *  Post Request Mapping for saving a feature
     * @param feature Feature to be saved, in JSON serialized form. From Post body
     * @return Added feature
     */
    @PostMapping("/AdditionalFeature/add")
    public AdditionalFeature Save(@RequestBody AdditionalFeature feature){
        return addfeature_service.savefeature(feature);
    }

    /**
     *  Get a specific feature with its id
     * @param id id of the feature to return
     * @return Requested feature
     */
    @GetMapping("/feature/get")
    public AdditionalFeature getFeature(int id){
        return addfeature_service.getFeature(id);
    }

}

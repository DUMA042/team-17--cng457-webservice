package team17cng457.webservice.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team17cng457.webservice.JPA.entity.AdditionalFeature;
import team17cng457.webservice.Repository.AddfeatureRepository;

@Service
public class AddfeatureService {
    @Autowired
    private AddfeatureRepository featurerep;

    public AdditionalFeature savefeature(AdditionalFeature feature){
        return  featurerep.save(feature);
    }

}

package team17cng457.webservice.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team17cng457.webservice.Repository.AddfeatureRepository;
import team17cng457.webservice.JPA.entity.AdditionalFeature;

/**
 *  Spring Service for Additional Features
 */
@Service
public class AddfeatureService {
    /**
     *  autowired Spring feature repository
     */
    @Autowired
    private AddfeatureRepository featurerep;

    /**
     *  save a feature to the repository
     * @param feature feature to save
     * @return saved feature
     */
    public AdditionalFeature savefeature(AdditionalFeature feature){
        return  featurerep.save(feature);
    }

    /**
     *  get a feature with ID
     * @param feature_id ID of feature to return
     * @return Requested feature
     */
    public AdditionalFeature getFeature(long feature_id){
        return  featurerep.findByFeatureid(feature_id);
    }

}

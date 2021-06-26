package team17cng457.webservice.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import team17cng457.webservice.JPA.entity.AdditionalFeature;

/**
 *  JPA repository for Features
 */
public interface AddfeatureRepository extends JpaRepository<AdditionalFeature,Long> {

    /**
     *  find a feature by its ID
     * @param feature_id id of the feature to return
     * @return Requested feature
     */
    public AdditionalFeature findByFeatureid(long feature_id);

}

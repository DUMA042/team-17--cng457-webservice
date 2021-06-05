package team17cng457.webservice.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import team17cng457.webservice.JPA.entity.AdditionalFeature;
import team17cng457.webservice.JPA.entity.Comment;

public interface AddfeatureRepository extends JpaRepository<AdditionalFeature,Long> {

    //find comment with ID
    public AdditionalFeature findByFeatureid(long feature_id);

}

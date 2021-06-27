package team17cng457.webservice.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.transaction.annotation.Transactional;
import team17cng457.webservice.JPA.entity.AdditionalFeature;

import javax.persistence.LockModeType;

/**
 *  JPA repository for Features
 */
public interface AddfeatureRepository extends JpaRepository<AdditionalFeature,Long> {

    /**
     * Save a feature. Feature is locked for both read and write
     * @param af feature to save
     * @return saved feature
     */
    @Lock(LockModeType.PESSIMISTIC_WRITE)
    public AdditionalFeature save(AdditionalFeature af);

    /**
     *  find a feature by its ID
     * @param feature_id id of the feature to return
     * @return Requested feature
     */
    public AdditionalFeature findByFeatureid(long feature_id);

}

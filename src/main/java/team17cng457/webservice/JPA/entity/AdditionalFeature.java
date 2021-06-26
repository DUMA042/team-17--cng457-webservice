package team17cng457.webservice.JPA.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

/**
 *  JPA representation of a feature
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdditionalFeature {
    /**
     *  unique integer id for feature
     */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "Feature_id")
    private long featureid;

    /**
     *  name of the feature
     */
    @Column(name = "Feature_name")
    String featurename;

    /**
     *  value of the feature
     */
    @Column(name = "feature_value")
    String featurevalue;

    /**
     *  m2m relation for devices and features
     */
    @ManyToMany
    List<Device> devicesfeature;
}

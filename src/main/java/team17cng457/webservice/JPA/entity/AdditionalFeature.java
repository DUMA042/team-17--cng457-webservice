package team17cng457.webservice.JPA.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdditionalFeature {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "Feature_id")
    private long featureid;
    @Column(name = "Feature_name")
    String featurename;
    @Column(name = "feature_value")
    String featurevalue;
    @ManyToMany
    List<Device> devicesfeature;
}

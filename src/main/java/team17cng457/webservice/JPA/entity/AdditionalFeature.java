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
    @Column(name = "Feature ID")
    private long feature_id;
    @Column(name = "Feature Name")
    String Added_feature;
    @ManyToMany
    List<Device> devices_feature;
}

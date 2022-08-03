package be.digitalcity.springrest.model.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.Set;

@Entity
@Getter @Setter
@NoArgsConstructor
public class Tuteur extends Personne {

    @Column(nullable = false)
    private String num_tel;

    @Column(nullable = false)
    private String adresse;

    @ManyToMany(mappedBy = "tuteurs")
    private Set<Enfant> enfants;

}

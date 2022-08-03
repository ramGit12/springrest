package be.digitalcity.springrest.model.entity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Personne {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;
    @Column(nullable = false)
    private String prenom;
    @Column(nullable = false)
    private String nom;




    public Personne(String prenom, String nom) {
        this.prenom = prenom;
        this.nom = nom;
    }


}

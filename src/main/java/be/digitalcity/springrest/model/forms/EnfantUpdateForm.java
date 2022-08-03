package be.digitalcity.springrest.model.forms;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Data
public class EnfantUpdateForm {

    private String nom;
    private String prenom;
    private LocalDate dateNaiss;
    private boolean propre;
    private List<String> allergies;
    private Set<Long> tuteursId;

    // 2e manière d'envisager le mappage
    // A remarque que l'id et les tuteurs ne sont pas setté
//    public Enfant toEntity(){
//
//        Enfant entity = new Enfant();
//
//        entity.setPrenom(prenom);
//        entity.setNom(nom);
//        entity.setDateNaissance(dateNaiss);
//        entity.setPropre(propre);
//        entity.setAllergies(allergies);
//
//        return entity;
//
//    }

}

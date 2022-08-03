package be.digitalcity.springrest.model.forms;

import lombok.Data;

import java.util.Set;

@Data
public class TuteurUpdateForm {
    private String nom;
    private String prenom;
    private String adresse;
    private String num_tel;
    private Set<Long> enfantId;

}

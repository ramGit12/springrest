package be.digitalcity.springrest.model.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Data
@Builder
public class TuteurDTO {
    private long id;
    private String nom;
    private String prenom;
    private String adresse;
    private String num_tel;
    private Set<EnfantDTO> enfants;
}

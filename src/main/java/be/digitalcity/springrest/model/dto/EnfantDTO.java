package be.digitalcity.springrest.model.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Data
@Builder
public class EnfantDTO {

    private long id;
    private String nom;
    private String prenom;
    private LocalDate dateNaiss;
    private String proprete;
    private List<String> allergies;
    private Set<TuteurDTO> tuteurs;


}

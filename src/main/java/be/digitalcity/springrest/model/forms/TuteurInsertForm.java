package be.digitalcity.springrest.model.forms;

import be.digitalcity.springrest.model.entity.Tuteur;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Data

public class TuteurInsertForm {

    @NotBlank
    @Size(max = 50)
    private String nom;
    private String prenom;
    private String adresse;
    private String num_tel;

    Set<Long> enfantsId = new HashSet<>();

}

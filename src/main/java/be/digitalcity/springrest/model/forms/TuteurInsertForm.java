package be.digitalcity.springrest.model.forms;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data

public class TuteurInsertForm {

    @NotBlank
    @Size(max = 50)
    private String nom;
    private String prenom;
    private String adresse;
    private String num_tel;


}

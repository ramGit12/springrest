package be.digitalcity.springrest.mapper;


import be.digitalcity.springrest.model.dto.TuteurDTO;
import be.digitalcity.springrest.model.entity.Tuteur;
import be.digitalcity.springrest.model.forms.TuteurInsertForm;
import be.digitalcity.springrest.model.forms.TuteurUpdateForm;
import org.springframework.stereotype.Component;

@Component
public class TuteurMapper {

    public TuteurDTO toDto(Tuteur entity){
        if(entity == null)
            return null;

        return TuteurDTO.builder()
                .id(entity.getId())
                .prenom(entity.getPrenom())
                .nom(entity.getNom())
                .adresse(entity.getAdresse())
                .num_tel(entity.getNum_tel())
                .build();

    }

    public Tuteur toEntity(TuteurInsertForm form){
        if(form == null )
            return null;

        Tuteur tuteur = new Tuteur();
        tuteur.setPrenom(form.getPrenom());
        tuteur.setNom(form.getNom());
        tuteur.setAdresse(form.getAdresse());
        tuteur.setNum_tel(form.getNum_tel());

        return tuteur;
    }

    public Tuteur toEntity(TuteurUpdateForm form){
        Tuteur tuteur = new Tuteur();

        tuteur.setPrenom(form.getPrenom());
        tuteur.setNom(form.getNom());
        tuteur.setAdresse(form.getAdresse());
        tuteur.setNum_tel(form.getNum_tel());

        return tuteur;

    }
}

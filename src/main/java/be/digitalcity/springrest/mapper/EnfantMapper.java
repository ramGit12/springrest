package be.digitalcity.springrest.mapper;

import be.digitalcity.springrest.model.dto.EnfantDTO;
import be.digitalcity.springrest.model.entity.Enfant;
import be.digitalcity.springrest.model.entity.Personne;
import be.digitalcity.springrest.model.forms.EnfantInsertForm;
import be.digitalcity.springrest.model.forms.EnfantUpdateForm;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class EnfantMapper {

    public EnfantDTO toDto(Enfant entity){

        if( entity == null )
            return null;
        Set<Long> list = entity.getTuteurs().stream().map(Personne::getId).collect(Collectors.toSet());
        return EnfantDTO.builder()
                .id( entity.getId() )
                .prenom( entity.getPrenom() )
                .nom( entity.getNom() )
                .dateNaiss( entity.getDateNaissance() )
                .allergies( entity.getAllergies() )
                .proprete( entity.isPropre() ? "propre" : "non-propre" ) // propre / non-propre
                .tuteurs( list)
                .build();

    }

    public Enfant toEntity(EnfantInsertForm form){

        if( form == null )
            return null;

        Enfant enfant = new Enfant();

        enfant.setPrenom( form.getPrenom() );
        enfant.setNom( form.getNom() );
        enfant.setDateNaissance( form.getDateNaiss() );
        enfant.setPropre( form.isPropre() );

        return enfant;

    }

    // Il est a remarquer qu'on ne mappe pas l'id ou les tuteurs
    public Enfant toEntity(EnfantUpdateForm form){

        Enfant entity = new Enfant();

        entity.setPrenom(form.getPrenom());
        entity.setNom(form.getNom());
        entity.setDateNaissance(form.getDateNaiss());
        entity.setPropre(form.isPropre());
        entity.setAllergies(form.getAllergies());

        return entity;

    }

}

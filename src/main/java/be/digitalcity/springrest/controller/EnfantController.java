package be.digitalcity.springrest.controller;

import be.digitalcity.springrest.mapper.EnfantMapper;
import be.digitalcity.springrest.model.dto.EnfantDTO;
import be.digitalcity.springrest.model.entity.Enfant;
import be.digitalcity.springrest.model.entity.Tuteur;
import be.digitalcity.springrest.model.forms.EnfantInsertForm;
import be.digitalcity.springrest.model.forms.EnfantUpdateForm;
import be.digitalcity.springrest.service.EnfantService;
//import be.digitalcity.springrest.service.impl.EnfantServiceMock;
import be.digitalcity.springrest.service.TuteurService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/enfant")
public class EnfantController {

    private final EnfantService service;
    private final EnfantMapper mapper;

    private  final TuteurService tuteurService;

    public EnfantController(EnfantService service, EnfantMapper mapper, TuteurService tuteurService) {
        this.service = service;
        this.mapper = mapper;
        this.tuteurService = tuteurService;
    }

    @GetMapping("/{id:[0-9]+}")
    public EnfantDTO getOne(@PathVariable long id){
        return mapper.toDto( service.getOne(id) );
    }

    @GetMapping({"", "/all"})
    public List<EnfantDTO> getAll(){
        return service.getAll().stream()
                .map( mapper::toDto )
                .toList();
    }

    @PostMapping
    public EnfantDTO insert(@RequestBody EnfantInsertForm form){
        Enfant entity = mapper.toEntity(form);
        entity.setTuteurs(tuteurService.getAllById(form.getTuteursId()));
        return mapper.toDto( service.create( entity ) );
    }

    @DeleteMapping("/{id}")
    public EnfantDTO delete(@PathVariable long id){
        return mapper.toDto( service.delete(id) );
    }

    @PutMapping("/{id}")
    public EnfantDTO update(@PathVariable long id, @RequestBody EnfantUpdateForm form ){


        Enfant entity = mapper.toEntity(form);
        return mapper.toDto( service.update( id, entity ) );

    }



}


package be.digitalcity.springrest.controller;


import be.digitalcity.springrest.mapper.TuteurMapper;
import be.digitalcity.springrest.model.dto.TuteurDTO;
import be.digitalcity.springrest.model.entity.Tuteur;
import be.digitalcity.springrest.model.forms.TuteurInsertForm;
import be.digitalcity.springrest.model.forms.TuteurUpdateForm;
import be.digitalcity.springrest.service.EnfantService;
import be.digitalcity.springrest.service.TuteurService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tuteur")
public class TuteurController {

    private final TuteurService service;
    private final TuteurMapper mapper;

    private final EnfantService enfantService;


    public TuteurController(TuteurService service, TuteurMapper mapper, EnfantService enfantService) {
        this.service = service;
        this.mapper = mapper;
        this.enfantService = enfantService;
    }

    @GetMapping("{id}")
    public TuteurDTO getOne(@PathVariable long id){
        return mapper.toDto(service.getOne(id));
    }

    @GetMapping({ "/all"})
    public List<TuteurDTO> getAll(){
        return service.getAll().stream()
                .map( mapper::toDto )
                .toList();
    }


    @PostMapping
    public TuteurDTO insert(@RequestBody TuteurInsertForm form){
        Tuteur entity = mapper.toEntity(form);
       // entity.setEnfants(enfantService.getAllById(form.getEnfantsId()));
        return mapper.toDto( service.create( entity ) );
    }

    @DeleteMapping("/{id}")
    public TuteurDTO delete(@PathVariable long id){
        return mapper.toDto( service.delete(id) );
    }

    @PutMapping("/{id}")
    public TuteurDTO update(@PathVariable long id, @RequestBody TuteurUpdateForm form ){

        Tuteur entity = mapper.toEntity(form);
        return mapper.toDto( service.update( id, entity ) );

    }

}

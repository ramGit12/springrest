package be.digitalcity.springrest.controller;

import be.digitalcity.springrest.model.entity.Enfant;
import be.digitalcity.springrest.model.entity.Personne;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//import java.net.http.HttpHeaders;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDate;
import java.util.Map;


@RestController
@RequestMapping("/demo")
public class DemoController {

    @GetMapping("/personne")
    @ResponseBody
    @ResponseStatus(HttpStatus.I_AM_A_TEAPOT)
    public Personne getPersonne(){
        return  new Enfant("alex","kim", LocalDate.now(),true);

    }

    @PostMapping("/personne")
    public void writePerson(@RequestBody Personne personne, @RequestParam("repetition") int iter){
        for (int i = 0; i < iter; i++) {
            System.out.println(personne);
        }

    }

    @GetMapping("/params")
    public void writeParams(@RequestParam Map<String,Object> params){
        for(String key : params.keySet()){
            System.out.println(key + " - " + params.get(key));
        }


    }

    @GetMapping("/headers")
    public void writeArtificialHeader(@RequestHeader String artificial){
        System.out.println(artificial);
    }

    @GetMapping("/headers/all")
    public void writeAllHeader(@RequestHeader HttpHeaders headers){
        for(String key : headers.keySet()){
            System.out.println(key + " - " + headers.get(key));
        }
    }

    @GetMapping("/demo/{id}")
    public void demoPathVar(@PathVariable int id){
        System.out.println("L'id selctionné est : " + id);
    }


    @GetMapping("/request")
    public void recupRequest(HttpServletRequest request, HttpServletResponse response){
        System.out.println(request);
        System.out.println(response);


    }
    @GetMapping("/personne/new")
    public ResponseEntity<Personne> getPersonne(@RequestParam ("name") String nom,@RequestParam("firstname") String prenom){
        Enfant body = new Enfant("alexx","kimm", LocalDate.now(),true);
        HttpHeaders headers = new HttpHeaders();
        headers.add("artificial","ma valeur");
        HttpStatus status = HttpStatus.OK;
        //return new ResponseEntity<>(body, headers,status);

        return ResponseEntity.status(status)
                //.header("artificial","ma valeur ","2e valeur")
                .headers(headers)
                .body(body);
    }



}

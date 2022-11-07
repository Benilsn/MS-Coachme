package br.com.coachme.controllers;

import br.com.coachme.dtos.DisponibilityDto;
import br.com.coachme.exceptions.DisponibilityNotFoundException;
import br.com.coachme.models.Disponibility;
import br.com.coachme.services.DisponibilityService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/disponibility")
public class DisponibilityController {

    @Autowired
    private DisponibilityService disponibilityService;

    @PostMapping("/save")
    public ResponseEntity<Disponibility> saveDisponibility(@RequestBody DisponibilityDto disponibilityDto) {

        Disponibility disponibility = new Disponibility();
        BeanUtils.copyProperties(disponibilityDto, disponibility);

        return ResponseEntity.ok(disponibilityService.save(disponibility));
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") Long id) {
        try {
            return new ResponseEntity<>(disponibilityService.getById(id), HttpStatus.OK);

        } catch (DisponibilityNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);

        }
    }

    @GetMapping
    public ResponseEntity<List<Disponibility>> getAll(){
        return new ResponseEntity<>(disponibilityService.getAll(), HttpStatus.OK);
    }
}

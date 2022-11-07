package br.com.coachme.services;

import br.com.coachme.dtos.DisponibilityDto;
import br.com.coachme.exceptions.DisponibilityNotFoundException;
import br.com.coachme.models.Disponibility;
import br.com.coachme.repositories.DisponibilityRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

@Service
public class DisponibilityService {

    @Autowired
    private DisponibilityRepository disponibilityRepository;


    public Disponibility save(Disponibility disponibility) {
        return disponibilityRepository.save(disponibility);
    }

    public Disponibility getById(Long id){
        return disponibilityRepository.findById(id).orElseThrow(() -> new DisponibilityNotFoundException("Disponibility not found!"));
    }

    public List<Disponibility> getAll(){
        return disponibilityRepository.findAll();
    }

}






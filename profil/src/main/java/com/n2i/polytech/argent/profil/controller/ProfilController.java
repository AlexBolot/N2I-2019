package com.n2i.polytech.argent.profil.controller;

import com.n2i.polytech.argent.profil.model.Profil;
import com.n2i.polytech.argent.profil.repository.ProfilRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/profil")
public class ProfilController {

    private final ProfilRepository profilRepository;

    public ProfilController(ProfilRepository profilRepository) {
        this.profilRepository = profilRepository;
    }

    @GetMapping("/{email}")
    public ResponseEntity<Profil> view(@PathVariable(value = "email")String email){
        Optional<Profil> p = profilRepository.findById(email);
        if(p.isPresent())
            return new ResponseEntity<>(p.get(),HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping(value = "/login", consumes = "text/plain")
    public ResponseEntity<Profil> login(@RequestBody String email){
        Optional<Profil> p = profilRepository.findById(email);
        if(p.isPresent())
            return new ResponseEntity<>(p.get(),HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/")
    public ResponseEntity<String> create(@RequestBody Profil profil){
        profilRepository.save(profil);
        return new ResponseEntity<String>("Created "+profil.toString(),HttpStatus.OK);
    }
}

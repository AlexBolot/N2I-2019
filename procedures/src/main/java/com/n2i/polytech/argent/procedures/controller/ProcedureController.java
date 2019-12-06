package com.n2i.polytech.argent.procedures.controller;

import com.n2i.polytech.argent.procedures.model.Procedure;
import com.n2i.polytech.argent.procedures.repo.ProceduresRepo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/procedure", consumes = "application/json")
public class ProcedureController {

    private final ProceduresRepo proceduresRepo;

    public ProcedureController(ProceduresRepo proceduresRepo) {
        this.proceduresRepo = proceduresRepo;
    }

    @GetMapping(value = "/{email}")
    public ResponseEntity<List<Procedure>> access(@PathVariable("email") String email) {
        List<Procedure> result = new ArrayList<>();
        proceduresRepo.findAllByOwnerEmail(email).forEach(result::add);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping(value = "/")
    public ResponseEntity<List<Procedure>> getAll() {
        List<Procedure> result = new ArrayList<>();
        proceduresRepo.findAll().forEach(result::add);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping(value = "/")
    public ResponseEntity<String> create(@RequestBody Procedure procedure) {

        proceduresRepo.save(procedure);
        return new ResponseEntity<>("Created " + procedure.toString(), HttpStatus.OK);


    }

}

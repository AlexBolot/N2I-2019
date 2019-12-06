package com.n2i.polytech.argent.procedures.controller;

import com.n2i.polytech.argent.procedures.model.Procedure;
import com.n2i.polytech.argent.procedures.repo.ProceduresRepo;
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
    public List<Procedure> access(@PathVariable("email") String email) {
        List<Procedure> result = new ArrayList<>();
        proceduresRepo.findAllByOwnerEmail(email).forEach(result::add);
        return result;
    }

    @GetMapping(value = "/")
    public List<Procedure> getAll() {
        List<Procedure> result = new ArrayList<>();
        proceduresRepo.findAll().forEach(result::add);
        return result;
    }

    @PostMapping(value = "/")
    public String create(@RequestBody Procedure procedure) {
        if (!proceduresRepo.existsById(procedure.getId())) {
            proceduresRepo.save(procedure);
            return "OK";
        }
        return "KO";
    }

}

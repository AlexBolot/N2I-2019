package com.n2i.polytech.argent.matching.controller;

import com.n2i.polytech.argent.matching.model.Procedure;
import com.n2i.polytech.argent.matching.repo.ProceduresRepo;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/procedure", consumes = "application/json")
public class ProceduresController {

    private final ProceduresRepo proceduresRepo;

    public ProceduresController(ProceduresRepo proceduresRepo) {
        this.proceduresRepo = proceduresRepo;
    }

    @PostMapping(value = "/")
    public String create(@RequestBody Procedure procedure) {
        if (!proceduresRepo.existsById(procedure.getId())) {
            proceduresRepo.save(procedure);
            return "OK";
        }
        return "KO";
    }

    @GetMapping(value = "/{email}")
    public List<Procedure> access(@PathVariable("email") String email) {
        List<Procedure> result = new ArrayList<>();
        proceduresRepo.findAllByOwnerEmail(email).forEach(result::add);
        return result;
    }
}

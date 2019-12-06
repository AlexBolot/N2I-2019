package com.n2i.polytech.argent.matching.controller;

import com.n2i.polytech.argent.matching.model.Procedure;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/matching", consumes = "application/json")
public class MatchingController {

    @GetMapping(value = "/{email}")
    public ResponseEntity<List<Procedure>> access(@PathVariable("email") String email) {
        List<Procedure> myProcedures = getMyProcedures(email);
        List<Procedure> allProcedures = getAllProcedures();
        List<Procedure> result = new ArrayList<>();
        myProcedures.forEach(procedure -> result.addAll(allProcedures.stream().filter(p -> procedure.getClass() == p.getClass()).collect(Collectors.toList())));
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    private List<Procedure> getMyProcedures(String email) {
        return new RestTemplate().getForEntity("http://localhost:8082/procedure/theos.mariani@gmail.com", List.class).getBody();
    }

    private List<Procedure> getAllProcedures() {
        return new RestTemplate().getForEntity("http://localhost:8082/procedure/", List.class).getBody();
    }
}

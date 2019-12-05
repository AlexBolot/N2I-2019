package com.n2i.polytech.argent.matching.repo;

import com.n2i.polytech.argent.matching.model.Procedure;
import org.springframework.data.repository.CrudRepository;

public interface ProceduresRepo extends CrudRepository<Procedure, Integer> {

    Iterable<Procedure> findAllByOwnerEmail(String email);
}

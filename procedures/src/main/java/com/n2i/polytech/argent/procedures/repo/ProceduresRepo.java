package com.n2i.polytech.argent.procedures.repo;

import com.n2i.polytech.argent.procedures.model.Procedure;
import org.springframework.data.repository.CrudRepository;

public interface ProceduresRepo extends CrudRepository<Procedure, Integer> {

    Iterable<Procedure> findAllByOwnerEmail(String email);
    boolean existsByOwnerEmail(String email);
}

package com.n2i.polytech.argent.profil.repository;

import com.n2i.polytech.argent.profil.model.Profil;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


public interface ProfilRepository extends CrudRepository<Profil, String> {

}

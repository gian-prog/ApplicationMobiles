package org.benedetti.calculMethodes.repos;

import org.benedetti.calculMethodes.model.Truc;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrucRepo extends JpaRepository<Truc, Long> {

    // ajouter une fonction pour trouver par un chose
    Truc findByChose(String chose);
}
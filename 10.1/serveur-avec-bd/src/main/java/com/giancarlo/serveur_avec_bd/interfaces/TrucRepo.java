package com.giancarlo.serveur_avec_bd.interfaces;

import com.giancarlo.serveur_avec_bd.models.Truc;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrucRepo extends JpaRepository<Truc, Long> {

    // ajouter une fonction pour trouver par un chose
    Truc findByChose(String chose);
}
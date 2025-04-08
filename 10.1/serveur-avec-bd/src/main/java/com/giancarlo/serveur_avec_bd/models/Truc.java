package com.giancarlo.serveur_avec_bd.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Truc {

    @Id  @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;

    public String chose;

}
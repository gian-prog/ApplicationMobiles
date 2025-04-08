package com.giancarlo.serveur_avec_bd.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

// Sera automatiquement détecté au démarrage du serveur
@Controller
public class Controlleur {

	//ExercicePost+Postman
	@PostMapping("/prout/envoyer")
	public @ResponseBody String sendHeight(
			@RequestParam(value = "taille", required = false) Integer taille,
			@RequestBody String texte) throws PasBonneChoseException {
		if (taille == null || taille <= 0 || texte == null || texte.isEmpty()) {
			throw new PasBonneChoseException();
		}
		// Répète le texte et tronque à la longueur exacte de "taille"
		return texte.repeat((taille / texte.length()) + 1).substring(0, taille);
	}

}
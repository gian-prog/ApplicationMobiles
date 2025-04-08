package com.giancarlo.serveur_avec_bd.controller;

import com.giancarlo.serveur_avec_bd.interfaces.TrucService;
import com.giancarlo.serveur_avec_bd.models.Truc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Sera automatiquement détecté au démarrage du serveur
@Controller
public class Controlleur {

	@Autowired
	public TrucService trucService;

	@GetMapping("/trucs")
	public @ResponseBody List<Truc> trucs()  {
		return trucService.listerTrucs();
	}

	@GetMapping("/ajouterTruc/{chose}")
	public @ResponseBody String ajouterEnGet(
			@PathVariable String chose) throws PasBonneChoseException {
		trucService.ajouterUnTruc(chose);
		return "ok";
	}

	@PostMapping("/ajouterTrucPost")
	public @ResponseBody String ajouterEnPost(
			@RequestBody String chose) throws PasBonneChoseException {
		trucService.ajouterUnTruc(chose);
		return "ok";
	}

	@PutMapping("/ajouterTrucPut")
	public @ResponseBody String ajouterEnPut(
			@RequestBody String chose) throws PasBonneChoseException {
		trucService.ajouterUnTruc(chose);
		return "ok";
	}
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
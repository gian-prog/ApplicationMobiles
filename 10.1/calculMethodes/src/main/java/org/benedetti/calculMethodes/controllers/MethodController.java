package org.benedetti.calculMethodes.controllers;

import org.benedetti.calculMethodes.model.Truc;
import org.benedetti.calculMethodes.service.TrucService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MethodController {
    //SDK: Use the right SDK version, Oracle could work

    // Le service est injecté ici
    @Autowired
    private TrucService trucService;

    // Add your methods here
    // For example, you can create a method to handle a specific request
    // and return a view or perform some logic.

    // Example method
    @RequestMapping("/example")
    public @ResponseBody String  exampleMethod() {
        // Your logic here
        // For example, you can return a simple string response
        return "exampleView"; // Return the name of the view to be rendered
    }
    // You can add more methods to handle different requests
    // Cette méthode gère une requête GET sur l'URL "/api/chose"
    // Elle retourne la liste des trucs stockés dans la base de données
    @GetMapping("/api/chose")
    public @ResponseBody List<Truc> getChose() {
        // Retourne la liste des truc depuis le service
        return trucService.listerTrucs();
    }
    // Cette méthode gère une requête POST sur l'URL "/api/chose"
// Elle ajoute un nouvel objet Truc à la base de données
    @PostMapping("/api/chose")
    public @ResponseBody List<Truc> postChose(@RequestBody Truc truc) throws Exception {
        // Ajoute un nouvel objet Truc via le service
        trucService.ajouterUnTruc(truc.chose);
        // Retourne la liste mise à jour des Trucs
        System.out.println("Un nouveau truc a été ajouté : " + truc.chose);
        return trucService.listerTrucs();
    }
    @PutMapping("/api/chose/{id}")
    public void putChose(@PathVariable Long id) {
        // Cette méthode ne fait rien
    }
    @DeleteMapping("/api/chose")
    public ResponseEntity<String> nukeList() {
        trucService.EmptyList();
        System.out.println("La liste a bien été vidée");
        return ResponseEntity.ok("La liste a bien été vidée");
    }
// <editor-fold desc="EXERCICE FORMATIF FINAL">
    //FORMATIF FINAL:
    // Gère les requêtes GET sur /exam/h25/{x}
    @GetMapping("/exam/h25/{x}")
    public ResponseEntity<String>  name(@PathVariable String x) {
        // Si x fait 2 lettres ou moins, renvoie une erreur 400
        if (x.length() <= 2) {
            //Gestion de l'erreur personnalisée
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("Erreur : le nom doit contenir plus de 2 lettres.");
        }
        return ResponseEntity.ok("Bonjour " + x);
    }
    // </editor-fold>

}

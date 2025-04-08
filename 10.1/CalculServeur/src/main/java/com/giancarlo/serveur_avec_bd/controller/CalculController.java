package com.giancarlo.serveur_avec_bd.controller;

import com.giancarlo.serveur_avec_bd.service.CalculService;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;

// Annotation @RestController pour indiquer que cette classe gère les requêtes REST.
@RestController
@RequestMapping("/fibo") // Préfixe pour toutes les routes de ce contrôleur.
public class CalculController {

    // Injection de la classe de service CalculService.
    private final CalculService calculService;

    // Constructeur pour injecter le service via Spring.
    public CalculController(CalculService calculService) {
        this.calculService = calculService;
    }

    /**
     * Endpoint pour calculer le n-ième nombre de Fibonacci.
     * Accessible via une requête GET à l'URL /fibo/{n}.
     *
     * @param n L'indice du nombre de Fibonacci à calculer (extrait de l'URL).
     * @return Le n-ième nombre de Fibonacci sous forme de BigInteger.
     */
    @GetMapping("/{n}")
    public BigInteger getFibonacci(@PathVariable int n) {
        // Appelle la méthode fibonacci du service pour effectuer le calcul.
        return calculService.fibonacci(n);
    }
}
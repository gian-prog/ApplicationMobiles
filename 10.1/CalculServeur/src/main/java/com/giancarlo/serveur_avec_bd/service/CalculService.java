package com.giancarlo.serveur_avec_bd.service;

import java.math.BigInteger;
import org.springframework.stereotype.Service;

import java.math.BigInteger;

// Annotation @Service pour indiquer que cette classe est un composant Spring
// qui peut être injecté dans d'autres classes (comme un contrôleur).
@Service
public class CalculService {

    /**
     * Méthode pour calculer le n-ième nombre de Fibonacci.
     * Utilise une approche itérative pour éviter les problèmes de performance
     * liés à la récursivité pour de grandes valeurs de n.
     *
     * @param n L'indice du nombre de Fibonacci à calculer (doit être >= 0).
     * @return Le n-ième nombre de Fibonacci sous forme de BigInteger.
     * @throws IllegalArgumentException si n est négatif.
     */
    public BigInteger fibonacci(int n) {
        // Vérifie que n est un entier positif ou nul.
        if (n < 0) {
            throw new IllegalArgumentException("n doit être un entier positif.");
        }

        // Cas de base : Fibonacci(0) = 0
        if (n == 0) return BigInteger.ZERO;

        // Cas de base : Fibonacci(1) = 1
        if (n == 1) return BigInteger.ONE;

        // Variables pour stocker les deux derniers nombres de Fibonacci.
        BigInteger a = BigInteger.ZERO; // Fibonacci(0)
        BigInteger b = BigInteger.ONE;  // Fibonacci(1)

        // Boucle pour calculer Fibonacci(n) de manière itérative.
        for (int i = 2; i <= n; i++) {
            // Calcule le prochain nombre de Fibonacci.
            BigInteger temp = a.add(b);
            // Met à jour les variables pour le prochain itératif.
            a = b;
            b = temp;
        }

        // Retourne le n-ième nombre de Fibonacci.
        return b;
    }
}

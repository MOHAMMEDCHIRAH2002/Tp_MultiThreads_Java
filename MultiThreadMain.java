package org.multiThreads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MultiThreadMain {

    public static void main(String[] args) {
        int[] tableau = new int[1000];

        // Remplir le tableau de 1 à 1000
        for (int i = 0; i < tableau.length; i++) {
            tableau[i] = i + 1;
        }

        // Diviser en 4 tâches (4 threads)
        int nombreThreads = 4;
        int taillePartie = tableau.length / nombreThreads;

        ExecutorService executor = Executors.newFixedThreadPool(nombreThreads);
        Sommeur[] sommeurs = new Sommeur[nombreThreads];

        // Lancer les threads
        for (int i = 0; i < nombreThreads; i++) {
            int debut = i * taillePartie;
            int fin = (i == nombreThreads - 1) ? tableau.length : (i + 1) * taillePartie;
            sommeurs[i] = new Sommeur(tableau, debut, fin);
            executor.execute(sommeurs[i]);
        }

        // Arrêter le pool et attendre la fin
        executor.shutdown();
        while (!executor.isTerminated()) {
            // Attente que tous les threads terminent
        }

        // Additionner les sous-sommes
        int sommeTotale = 0;
        for (Sommeur s : sommeurs) {
            sommeTotale += s.getSomme();
        }

        System.out.println("✅ La somme totale est : " + sommeTotale);
    }
    }


package org.multiThreads;
class Compte {
    int solde = 0;

    synchronized void ajouter(int valeur) {
        solde += valeur; // ⚠️ ممكن جوج threads يدخلو هنا فـ نفس الوقت
    }

    void afficher() {
        System.out.println("Solde final : " + solde);
    }
}

public class Test {
    public static void main(String[] args) throws InterruptedException {
        Compte c = new Compte();

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) c.ajouter(1);
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) c.ajouter(1);
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        c.afficher(); // ممكن يعطي أقل من 2000 بسبب المشكل
    }
}


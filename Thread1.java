package org.multiThreads;

public class Thread1 extends Thread{


    public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println("Ana f thread : " + i);
            try {
                Thread.sleep(1000); // كيرتاح 1 ثانية
            } catch (InterruptedException e) {
                System.out.println("Erreur !");
            }
        }
    }

}

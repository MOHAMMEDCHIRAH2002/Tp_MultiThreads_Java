package org.multiThreads;

public class Main {
    public static void main(String[] args) throws InterruptedException {


        Thread1 t = new Thread1();
        Thread2 t2=new Thread2();
        t.start();
        t.join(); // كتسنى t حتى يسالي
        t2.start();

        System.out.println("✅ Thread salat, daba nkammel!");
    }
}
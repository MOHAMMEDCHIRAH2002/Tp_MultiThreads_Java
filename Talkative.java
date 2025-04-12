package org.multiThreads;

public class Talkative implements Runnable {

    public int x;
    public Talkative(int x) {
        this.x = x;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("valeur du x ["+i+"] "+x);
        }
    }
}

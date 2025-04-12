package org.multiThreads;

public class TalkativeMain  {
    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            Thread t = new Thread(new Talkative(i));
            t.start();
        }
    }
}

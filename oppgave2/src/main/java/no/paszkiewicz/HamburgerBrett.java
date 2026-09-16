package no.paszkiewicz;

import java.util.Queue;
import java.util.LinkedList;

public class HamburgerBrett {
    private final int kapasitet;
    private Queue<Hamburger> brett = new LinkedList<>();
    

    public HamburgerBrett(int kapasitet){
        this.kapasitet = kapasitet;
    }

    public synchronized void addBurger(Hamburger burger) throws InterruptedException {
        while (brett.size() >= kapasitet) {
            wait();
        }
        
        brett.add(burger);        
    }

    public synchronized Hamburger removeBurger() {

        return brett.poll();
    }
}

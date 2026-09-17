import java.util.LinkedList;
import java.util.Queue;


public class HamburgerBrett {

    private final int KAPASITET;
    private Queue<Hamburger> brett = new LinkedList<>();


    public HamburgerBrett(int kapasitet){
        this.KAPASITET = kapasitet;
    }

    public synchronized void addBurger(Hamburger burger) throws InterruptedException {
        while (brett.size() >= KAPASITET) {
            wait();
        }

        brett.add(burger);
        notifyAll();
    }

    public synchronized Hamburger removeBurger() throws InterruptedException{

        while (brett.isEmpty()) {
            wait();
        }
        return brett.poll();
    }
}

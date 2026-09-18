import java.util.LinkedList;
import java.util.Queue;


public class HamburgerBrett {

    private final int KAPASITET;
    private Queue<Hamburger> brett = new LinkedList<>();
    private Hamburger forsteburger;

    public HamburgerBrett(int kapasitet){
        this.KAPASITET = kapasitet;
        forsteburger = null;
    }

    public Hamburger getForsteburger() {
        return forsteburger;
    }
    public int mengde() {
        return brett.size();
    }

    public synchronized void addBurger(Hamburger burger) throws InterruptedException {
        while (brett.size() >= KAPASITET) {
            wait();
        }
        brett.add(burger);
        burger.increase();
        notifyAll();
    }

    public synchronized Hamburger removeBurger() throws InterruptedException{

        while (brett.isEmpty()) {
            wait();
        }
        return brett.poll();
    }
}

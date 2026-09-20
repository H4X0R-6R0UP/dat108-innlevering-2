import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class HamburgerBrett2 {
    private BlockingQueue<Hamburger> brett;
    private AtomicInteger antall;

    public HamburgerBrett2(int kapasitet){
        this.brett = new ArrayBlockingQueue<>(kapasitet);
        antall = new AtomicInteger(0);
    }

    public synchronized void addBurger2(String navn) throws InterruptedException {
        int inkrement = antall.incrementAndGet();
        Hamburger burger = new Hamburger(inkrement);
        brett.put(burger);
        System.out.print("\nKokk " +navn+ " la på burger nr " + burger.getBurger() + " nå er det " + brett.size() + " burgere på brettet");
    }

    public synchronized Hamburger removeBurger2(String navn) throws InterruptedException {

        Hamburger hamburger = brett.take();
        System.out.print("\nServitør "+navn+" tok av burger "+hamburger.getBurger()+" nå er det "+ brett.size()+" burgere på brettet");
        notifyAll();
        return hamburger;
    }
}

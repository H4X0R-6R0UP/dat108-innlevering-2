import java.util.LinkedList;
import java.util.Queue;

public class HamburgerBrett {

    private final int KAPASITET;
    private Queue<Hamburger> brett;
    private int antall;

    public HamburgerBrett(int kapasitet){
        this.KAPASITET = kapasitet;
        this.brett = new LinkedList<>();
        this.antall = 0;
    }

    public synchronized void addBurger(String navn) throws InterruptedException {
        while (brett.size() >= KAPASITET) {
            System.out.print("\nBrettet er fullt");
            wait();
        }
        antall++;
        Hamburger burger = new Hamburger(antall);
        brett.add(burger);
        System.out.print("\nKokk " +navn+ " la på burger nr " + burger.getBurger() + " nå er det " + brett.size() + " burgere på brettet");

        notifyAll();
    }

    public synchronized Hamburger removeBurger(String navn) throws InterruptedException {
        while (brett.isEmpty()) {
            System.out.print("\nBrettet er tomt");
            wait();
        }
        Hamburger hamburger = brett.poll();
        System.out.print("\nServitør "+navn+" tok av burger "+hamburger.getBurger()+" nå er det "+ brett.size()+" burgere på brettet");
        notifyAll();
        return hamburger;
    }

}

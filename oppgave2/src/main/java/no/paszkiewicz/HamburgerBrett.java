package no.paszkiewicz;

public class HamburgerBrett {
    private final int kapasitet;
    
    private Hamburger[] brett;

    private int antallKonsumert = 0;
    private int antallProdusert = 0;
    private int antall = 0;


    public HamburgerBrett(int kapasitet){
        this.kapasitet = kapasitet;
        brett = new Hamburger[kapasitet];
    }

    public synchronized void addBurger(Hamburger burger) throws InterruptedException {
        while (antall == kapasitet) {
            wait();
        }
        
        brett[antallProdusert % kapasitet] = burger;
        antallProdusert++;
        antall++;

        notifyAll();
    }

    public synchronized Hamburger removeBurger() throws InterruptedException{
        while (antall == 0) {
            System.out.println("No borgir for you!");
            wait();
        }

        Hamburger burger = brett[antallKonsumert % kapasitet];
        brett[antallKonsumert % kapasitet] = null;

        antallKonsumert++;
        antall--;

        notifyAll();

        return burger;
    }
}

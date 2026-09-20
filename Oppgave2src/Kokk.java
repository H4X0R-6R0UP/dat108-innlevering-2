
public class Kokk extends Thread {

    String navn;
    HamburgerBrett brett;
    Hamburger burger;

    public Kokk(HamburgerBrett brett, String navn) {
        this.navn = navn;
        this.brett = brett;
    }

    @Override
    public String toString() {
        return "burgeren på"+burger;
    }
    @Override
    public void run() {

        while (true) {
            try {
                Thread.sleep((long)(Math.random() * (6000 - 2000 + 1)) + 2000);
                brett.addBurger(navn);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

public class Kokk2 extends Thread {

    String navn;
    HamburgerBrett2 brett;
    Hamburger burger;

    public Kokk2(HamburgerBrett2 brett, String navn) {
        this.navn = navn;
        this.brett = brett;
    }

    @Override
    public void run() {

        while (true) {
            try {
                Thread.sleep((long)(Math.random() * (6000 - 2000 + 1)) + 2000);
                brett.addBurger2(navn);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

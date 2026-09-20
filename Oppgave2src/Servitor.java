public class Servitor extends Thread {

    String navn;
    HamburgerBrett brett;

    public Servitor(HamburgerBrett brett, String navn) {
        this.brett = brett;
        this.navn = navn;
    }

    @Override
    public String toString() {
        return "Burger ";
    }

    @Override
    public void run() {

        while(true) {
            try {
                Thread.sleep((long)(Math.random() * (6000 - 2000 + 1)) + 2000);
                brett.removeBurger(navn);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

public class Servitor2 extends Thread {

    String navn;
    HamburgerBrett2 brett;

    public Servitor2(HamburgerBrett2 brett, String navn) {
        this.brett = brett;
        this.navn = navn;
    }

    @Override
    public void run() {

        while(true) {
            try {
                Thread.sleep((long)(Math.random() * (6000 - 2000 + 1)) + 2000);
                brett.removeBurger2(navn);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

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
                System.out.print("\nServitør "+navn+" tok av burger "+brett.removeBurger().getBurger()+" nå er det "+ brett.mengde()+" burgere på brettet");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

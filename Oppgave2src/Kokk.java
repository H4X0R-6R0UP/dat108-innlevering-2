
public class Kokk extends Thread {

    String navn;
    HamburgerBrett brett;
    Hamburger burger;

    public Kokk(HamburgerBrett brett, String navn) {
        this.navn = navn;
        this.brett = brett;
        this.burger = new Hamburger(0, null);
    }

    @Override
    public String toString() {
        return "burgeren på"+burger;
    }
    @Override
    public void run() {

        while(true) {
            try {
                brett.addBurger(burger);
                System.out.print("\nKokk "+navn+" la på burger "+ burger.getBurger()+" nå er det "+ brett.mengde()+" burgere på brettet");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

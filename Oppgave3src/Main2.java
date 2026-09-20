public class Main2 implements Runnable {

    public static synchronized void main(String[] args) throws InterruptedException {

        final String[] kokker = {"Anne", "Erik", "Knut"};
        final String[] servitorer = {"Mia", "Per"};
        final int KAPASITET = 4;
        //skrivUtHeader(kokker, servitorer, KAPASITET);
        HamburgerBrett2 brett = new HamburgerBrett2(KAPASITET);
        for (String navn : kokker) {
            new Kokk2(brett, navn).start();
        }
        for (String navn : servitorer) {
            new Servitor2(brett, navn).start();
        }
    }

    /**
     * Runs this operation.
     */
    @Override
    public void run() {

    }
}

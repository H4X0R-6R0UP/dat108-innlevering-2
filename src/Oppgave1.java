import javax.swing.*;

public class Oppgave1 implements Runnable {

    /**
     * Runs this operation.
     */
    @Override
    public void run() {

    }

    public static synchronized void main (String[] args) throws NullPointerException, InterruptedException {

        String log = "Hallo verden\n";
        JOptionPane jop = new JOptionPane();

        Thread traad = new Thread(() -> {
            while (true) {
                try {
                    jop.showMessageDialog(null, log);
                    Thread.sleep(3000);
                    System.out.print(log);
                } catch (InterruptedException e) {
                    return;
                }
            }
        });
        traad.setDaemon(true);
        traad.start();


        Thread traad2 = new Thread(() -> {
            while (true) {
                try {
                    String log2 = jop.showInputDialog("Skriv inn din melding, quit for å slutte");
                    try {
                        if (log2.equals("quit")) {
                            traad.interrupt();
                            Thread.currentThread().interrupt();
                        } else {
                            jop.showMessageDialog(null, log2);
                            Thread.sleep(3000);
                            System.out.print(log2);
                        }
                    } catch (NullPointerException e) {
                        throw new NullPointerException("Trådene stenges");
                    }
                } catch (InterruptedException e) {
                    return;
                }
            }
        });
        traad2.start();

        if (traad2.isInterrupted()) {
            traad.interrupt();
        }

    }
}

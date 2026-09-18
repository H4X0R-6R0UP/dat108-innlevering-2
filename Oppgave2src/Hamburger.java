public class Hamburger {

    private int burger;
    private Hamburger neste;

    public Hamburger(int burger, Hamburger neste) {
        this.burger = burger;
        this.neste = neste;
    }

    public Hamburger(int burger) {
        this(burger, null);
    }

    public int getBurger() {
        return burger;
    }
    public void setBurger(int burger) {
        this.burger = burger;
    }
    public Hamburger getNeste() {
        return neste;
    }
    public void setNeste(Hamburger neste) {
        this.neste = neste;
    }
    public void increase() {
        burger +=1 ;
    }
}

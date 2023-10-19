package zoo;

public abstract class Raubkatze extends Tier {
    protected int danger;

    public Raubkatze(String name, double gewicht, boolean isWeibchen, double portionsGroesse, int danger) {
        super(name, gewicht, isWeibchen, portionsGroesse);
        this.danger = danger;
    }

    @Override
    public void buersten() {
        System.out.println("Purrpurrpurr");
    }

    public abstract void bruellen();
}

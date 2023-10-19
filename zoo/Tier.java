package zoo;

public abstract class Tier {
    protected String name;
    protected double gewicht;
    protected boolean isWeibchen;
    protected double portionsGroesse;

    public Tier(String name, double gewicht, boolean isWeibchen, double portionsGroesse) {
        this.name = name;
        this.gewicht = gewicht;
        this.isWeibchen = isWeibchen;
        this.portionsGroesse = portionsGroesse;
    }

    public void fuettern() {
        gewicht += portionsGroesse;
    }

    public abstract void buersten();
}

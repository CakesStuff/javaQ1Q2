package zoo;

public class Nilpferd extends Tier {
    public Nilpferd(String name, double gewicht, boolean isWeibchen) {
        super(name, gewicht, isWeibchen, gewicht / 100);
    }

    @Override
    public void buersten() {
        System.out.println("*das nilpferd schnaubt*");
    }
}

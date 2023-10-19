package zoo;

public class Loewe extends Raubkatze {
    public Loewe(String name, double gewicht, boolean isWeibchen, int danger) {
        super(name, gewicht, isWeibchen, gewicht * 0.025, danger);
    }

    @Override
    public void bruellen() {
        System.out.println("Roar!");
    }
}

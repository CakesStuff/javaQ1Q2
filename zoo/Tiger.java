package zoo;

public class Tiger extends Raubkatze {
    private int streifen;

    public Tiger(String name, double gewicht, boolean isWeibchen, int danger, int streifen) {
        super(name, gewicht, isWeibchen, gewicht / 50, danger);
        this.streifen = streifen;
    }

    @Override
    public void bruellen() {
        System.out.println("Chchchau");
    }
}

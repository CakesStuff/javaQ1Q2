package zoo;

import gui.GUI;

public class Zoo {
    private Tier[] tiere;

    public Zoo() {
        this.tiere = new Tier[3];
        this.tiere[0] = new Nilpferd("Das Nilpferd", 2000, true);
        this.tiere[1] = new Tiger("Der Tiger", 1000, false, 100, 100);
        this.tiere[2] = new Loewe("Der Loewe", 1000, false, 0);
        new GUI(this);
    }

    public void alleTiereFuettern() {
        for(Tier t : tiere) {
            t.fuettern();
        }
    }

    public void alleBuersten() {
        for(Tier t : tiere) {
            t.buersten();
        }
    }

    public void raubkatzenBruellen() {
        for(Tier t : tiere) {
            if(t instanceof Raubkatze) {
                ((Raubkatze) t).bruellen();
            }
        }
    }

    public static void main(String[] args) {
        new Zoo();
    }
}

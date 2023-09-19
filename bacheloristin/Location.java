package bacheloristin;

public class Location {
    private final String ort;
    private final String name;
    private int preis;
    private String partner;

    public Location(String ort, String name) {
        this.ort = ort;
        this.name = name;
    }

    public String getOrt() {
        return ort;
    }

    public String getName() {
        return name;
    }

    public int getPreis() {
        return preis;
    }

    public String getPartner() {
        return partner;
    }

    public void setPreis(int preis) {
        this.preis = preis;
    }

    public void setPartner(String partner) {
        this.partner = partner;
    }

    public int getMonatsPreis() {
        return preis * 30 / 7;
    }
}

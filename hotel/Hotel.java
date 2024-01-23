package hotel;

public class Hotel {
    private String name;
    private String anschrift;
    private String hotelkette;
    private int bewertungszahl;
    private int anzahlBewertungen;

    public Hotel(String name, String hotelkette) {
        this.name = name;
        this.hotelkette = hotelkette;
    }

    public Hotel(String name, String hotelkette, int bewertungszahl, int anzahlBewertungen) {
        this.name = name;
        this.hotelkette = hotelkette;
        this.bewertungszahl = bewertungszahl;
        this.anzahlBewertungen = anzahlBewertungen;
    }

    public void setAnschrift(String anschrift) {
        this.anschrift = anschrift;
    }

    public String getName() {
        return name;
    }

    public String getAnschrift() {
        return anschrift;
    }

    public String getHotelkette() {
        return hotelkette;
    }

    public double getBewertungszahl() {
        return (double) bewertungszahl / anzahlBewertungen;
    }

    public void bewerte(int bewertungszahl) {
        this.anzahlBewertungen++;
        this.bewertungszahl += bewertungszahl;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "name='" + name + '\'' +
                ", anschrift='" + anschrift + '\'' +
                ", hotelkette='" + hotelkette + '\'' +
                ", bewertungszahl=" + bewertungszahl +
                ", anzahlBewertungen=" + anzahlBewertungen +
                '}';
    }
}

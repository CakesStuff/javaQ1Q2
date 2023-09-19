package bacheloristin;

public class Kandidat {
    private final String name;
    private final int gebDatum;
    private final boolean weiblich;
    private int quotenPunkte;
    private boolean nochDabei;

    public Kandidat(String pName, int pGebDatum, boolean pWeiblich) {
        name = pName;
        gebDatum = pGebDatum;
        weiblich = pWeiblich;
        quotenPunkte = 0;
        nochDabei = true;
    }

    public String getName() {
        return name;
    }

    public int getGebDatum() {
        return gebDatum;
    }

    public boolean isWeiblich() {
        return weiblich;
    }

    public int getQuotenPunkte() {
        return quotenPunkte;
    }

    public boolean isNochDabei() {
        return nochDabei;
    }

    public void fliegtRaus() {
        nochDabei = false;
    }

    public void resetQuotenPunkte() {
        quotenPunkte = 0;
    }

    public void erhoeheQuotenPunkte(int pErhoehung) {
        quotenPunkte += pErhoehung;
    }

    public void senkeQuotenPunkte(int pSenkung) {
        quotenPunkte = Math.max(0, quotenPunkte - pSenkung);
    }

    public boolean istAelterAls(Kandidat pAnderer) {
        return gebDatum > pAnderer.getGebDatum();
    }
}

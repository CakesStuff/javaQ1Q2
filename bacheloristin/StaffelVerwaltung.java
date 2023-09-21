package bacheloristin;

import java.util.Arrays;
import java.util.Comparator;

public class StaffelVerwaltung {
    private final BacheloristinStaffel[] staffeln = new BacheloristinStaffel[3];
    private Location[] locations = new Location[4];

    public StaffelVerwaltung() {
        staffeln[0] = new BacheloristinStaffel(2017);
        staffeln[1] = new BacheloristinStaffel(2018);
        staffeln[2] = new BacheloristinStaffel(2019);
        initLocationListe();
    }

    public boolean kamKandidatSchon(Kandidat kandidat) {
        for(BacheloristinStaffel staffel : staffeln) {
            if(staffel.kandidatExists(kandidat)) {
                return true;
            }
        }
        return false;
    }

    public void sortLocations() {
        //Arrays.sort(locations, Comparator.comparingInt(Location::getPreis));
        Location[] temp = new Location[locations.length];
        int preis = Integer.MIN_VALUE;
        for(int i = 0; i < locations.length; i++) {
            Location l = null;
            int lowest = Integer.MAX_VALUE;
            for (Location location : locations) {
                if (location.getPreis() < lowest && location.getPreis() > preis) {
                    l = location;
                    lowest = l.getPreis();
                }
            }
            temp[i] = l;
            preis = l.getPreis();
        }
        locations = temp;
    }

    public void initLocationListe() {
        locations[0] = new Location("Bonn", "Name");
        locations[0].setPartner("Partner 1");
        locations[0].setPreis(50);
        locations[1] = new Location("Köln", "Name");
        locations[1].setPartner("Partner 2");
        locations[1].setPreis(250);
        locations[2] = new Location("Bad Honnef", "Name");
        locations[2].setPartner("Partner 3");
        locations[2].setPreis(25);
        locations[3] = new Location("Sonne", "Name");
        locations[3].setPartner("Helios");
        locations[3].setPreis(500000000);
    }
}

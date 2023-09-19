package bacheloristin;

public class StaffelVerwaltung {
    private final BacheloristinStaffel[] staffeln = new BacheloristinStaffel[3];

    public StaffelVerwaltung() {
        staffeln[0] = new BacheloristinStaffel(2017);
        staffeln[1] = new BacheloristinStaffel(2018);
        staffeln[2] = new BacheloristinStaffel(2019);
    }

    public boolean kamKandidatSchon(Kandidat kandidat) {
        for(BacheloristinStaffel staffel : staffeln) {
            if(staffel.kandidatExists(kandidat)) {
                return true;
            }
        }
        return false;
    }
}

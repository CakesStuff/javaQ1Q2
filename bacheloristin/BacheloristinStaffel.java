package bacheloristin;

import gui.GUI;
import linear.List;
import linear.ListWithViewer;

/**
 * 
 * 
 * @author Manuel Grifka
 * @version v0.2 2019-10-28
 */
public class BacheloristinStaffel {

	private final int jahr;
	private Kandidat bacheloristin;
	private final ListWithViewer<Kandidat> jungsListe;
	private Kandidat testkandidat;
	/**
	 * Konstruktor für Objekte der Klasse BacheloristinStaffel
	 */
	public BacheloristinStaffel(int pJahr)
	{
		jahr = pJahr;		
		jungsListe = new ListWithViewer<>();

		initJungsListeTestkandidatBacheloristin(pJahr);
	}

	public void rausschmeissen(String pName) {
		for(jungsListe.toFirst(); jungsListe.hasAccess(); jungsListe.next()) {
			if(jungsListe.getContent().getName().equals(pName)) {
				jungsListe.getContent().fliegtRaus();
			}
		}
	}

	public void alleResetten() {
		for(jungsListe.toFirst(); jungsListe.hasAccess(); jungsListe.next()) {
			jungsListe.getContent().resetQuotenPunkte();
		}
	}

	public int anzahlAusgeschiedener() {
		int sum = 0;
		for(jungsListe.toFirst(); jungsListe.hasAccess(); jungsListe.next()) {
			if(!jungsListe.getContent().isNochDabei()) {
				sum++;
			}
		}
		return sum;
	}

	public void hatGelaestert(String pNameWer, String pNameUeberWen) {
		for(jungsListe.toFirst(); jungsListe.hasAccess(); jungsListe.next()) {
			if(jungsListe.getContent().getName().equals(pNameWer)) {
				jungsListe.getContent().erhoeheQuotenPunkte(20);
			} else if(jungsListe.getContent().getName().equals(pNameUeberWen)) {
				jungsListe.getContent().erhoeheQuotenPunkte(10);
			}
		}
	}

	public void knutschtBacheloristin(Kandidat pKandidat) {
		pKandidat.erhoeheQuotenPunkte(50);
	}

	public Kandidat gibQuotenLetzten() {
		Kandidat result = jungsListe.getContent();
		int quote = Integer.MAX_VALUE;
		for(jungsListe.toFirst(); jungsListe.hasAccess(); jungsListe.next()) {
			if(jungsListe.getContent().getQuotenPunkte() < quote) {
				result = jungsListe.getContent();
				quote = result.getQuotenPunkte();
			}
		}
		return result;
	}

	public List<Kandidat> gibAlte() {
		int alter = (jahr - 30) * 10000;
		List<Kandidat> result = new List<>();
		for(jungsListe.toFirst(); jungsListe.hasAccess(); jungsListe.next()) {
			if(jungsListe.getContent().getGebDatum() < alter) {
				result.append(jungsListe.getContent());
			}
		}
		return result;
	}

	private void initJungsListeTestkandidatBacheloristin(int pJahr) {
        switch (pJahr) {
            case 2019 -> {
                bacheloristin = new Kandidat("Fiona Diaz", 19900106, true);
                jungsListe.append(new Kandidat("Diego de Deus", 19601030, false));
                jungsListe.append(new Kandidat("George Coolknee", 19610506, false));
                jungsListe.append(new Kandidat("Shria Ekstroem", 19900102, false));
                jungsListe.append(new Kandidat("Edward Heran", 19910217, false));
                jungsListe.append(new Kandidat("Adam Douglas", 19520311, false));
                jungsListe.append(new Kandidat("Wolfgang Howowitz", 19810229, false));
                jungsListe.append(new Kandidat("Stefan Falking", 19420108, false));
                jungsListe.append(new Kandidat("Thomas Enis", 19980906, false));

                // Attribut testkandidat zum Testen von Methoden, die ein Kandidat-Objekt als Parameter erhalten
                testkandidat = new Kandidat("Don Dump", 19460614, false);
                jungsListe.append(testkandidat);
                jungsListe.append(new Kandidat("Christian Ronald", 19850205, false));
            }
            case 2018 -> {
                bacheloristin = new Kandidat("Bibi Botox", 19910909, true);
                jungsListe.append(new Kandidat("Paul Poser", 19860107, false));
                jungsListe.append(new Kandidat("Leo Lackaffe", 19891117, false));
                jungsListe.append(new Kandidat("Alex Honey", 19920102, false));

                // Attribut testkandidat zum Testen von Methoden, die ein Kandidat-Objekt als Parameter erhalten
                testkandidat = new Kandidat("Anton Donis", 19821223, false);
                jungsListe.append(testkandidat);
                jungsListe.append(new Kandidat("Robert Geissbock", 19720429, false));
                jungsListe.append(new Kandidat("Magnus Dautit", 19890802, false));
                jungsListe.append(new Kandidat("Thomas Hayopai", 19711109, false));
                jungsListe.append(new Kandidat("Shawn Schoenling", 19990107, false));
                jungsListe.append(new Kandidat("Gustave Giro", 20000505, false));
                jungsListe.append(new Kandidat("Alfons Bergmeier", 19990431, false));
            }
            case 2017 -> {
                bacheloristin = new Kandidat("Anna Krohn-Ismus", 19900722, true);
                jungsListe.append(new Kandidat("Kai Pirinha", 19970324, false));
                jungsListe.append(new Kandidat("Bill Dung", 19791009, false));
                jungsListe.append(new Kandidat("Jim Panse", 20000315, false));
                jungsListe.append(new Kandidat("Dieter Moskanne", 19670419, false));

                // Attribut testkandidat zum Testen von Methoden, die ein Kandidat-Objekt als Parameter erhalten
                testkandidat = new Kandidat("Ernst Haft", 19990101, false);
                jungsListe.append(testkandidat);
                jungsListe.append(new Kandidat("Lars Vegas", 19930602, false));
                jungsListe.append(new Kandidat("Andi Arbeit", 19890501, false));
                jungsListe.append(new Kandidat("Gerd Raenkaux-Tomate", 19871223, false));
                jungsListe.append(new Kandidat("Ismael Lieba", 19871030, false));
                jungsListe.append(new Kandidat("Karl Auer", 19931111, false));
            }
        }
	}
	
	

	@Override
	public String toString() {
		return "Jahr " + jahr + ", Bacheloristin: " + bacheloristin;
	}



	public static void main(String[] args) {
		BacheloristinStaffel bs = new BacheloristinStaffel(2019);
		new GUI(bs);
	}

}

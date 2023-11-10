package _test;


import gui.GUI;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

import linear.List;
import linear.ListWithViewer;
import sortieren.QuicksortMulitThread;

public class QuicksortTest {
	private int anzahlVergleiche;

	public QuicksortTest(){
		anzahlVergleiche = 0;
	}

	public List<String> quicksort(List<String> strings){
		int length = 0;
		for(strings.toFirst(); strings.hasAccess(); strings.next()) {
			length++;
		}
		if(length < 2) {
			return strings;
		}
		strings.toFirst();
		String pivot = strings.getContent();

		List<String> left = new List<>();
		List<String> right = new List<>();

		for(strings.next(); strings.hasAccess(); strings.next()) {
			anzahlVergleiche++;
			if(strings.getContent().compareTo(pivot) < 0) {
				left.append(strings.getContent());
			} else {
				right.append(strings.getContent());
			}
		}

		left = quicksort(left);
		right = quicksort(right);

		List<String> result = new List<>();

		for(left.toFirst(); left.hasAccess(); left.next()) {
			result.append(left.getContent());
		}
		result.append(pivot);
		for(right.toFirst(); right.hasAccess(); right.next()) {
			result.append(right.getContent());
		}
		return result;
	}

	public String[] quicksortArr(String[] strings) {
		return quicksortArrRec(strings, 0, strings.length);
	}

	private String[] quicksortArrRec(String[] strings, int l, int r) {
		if((r-l) < 2) return strings;

		String pivot = strings[l];

		String[] parts = new String[r - l];
		int li = 0;
		int ri = r - l;

		for(int i = l + 1; i < r; i++) {
			anzahlVergleiche++;
			if(strings[i].compareTo(pivot) < 0) {
				parts[li++] = strings[i];
			} else {
				parts[--ri] = strings[i];
			}
		}

		quicksortArrRec(parts, 0, li);
		quicksortArrRec(parts, ri, r - l);

        System.arraycopy(parts, 0, strings, l, li);
		strings[li + l] = pivot;
        System.arraycopy(parts, ri, strings, ri + l, r - l - ri);

		return strings;
	}

	public void quicksortTestKlein(){
		anzahlVergleiche = 0;
		List<String> avengers = new ListWithViewer<>();
		avengers.append("Iron Man");
		avengers.append("Captain America");
		avengers.append("Thor");
		avengers.append("Spider Man");
		avengers.append("Black Widow");
		List<String> ergebnis = quicksort(avengers);
		ausgeben(ergebnis);
	}

	public void quicksortTestGross(int pAnzahl){
		System.out.println("List performance:");
		anzahlVergleiche = 0;
		List<String>strings = erzeugen(pAnzahl);
		long startzeit = System.currentTimeMillis();
		List<String> ergebnis = quicksort(strings);
		long endzeit = System.currentTimeMillis();
		//ausgeben(ergebnis);
		long verbrauchteZeit = endzeit - startzeit; 
		System.out.println("+++ Zeitverbrauch: "+verbrauchteZeit+"ms +++");
		System.out.println("+++ Anzahl Vergleiche: "+anzahlVergleiche);

		System.out.println("Array performance:");
		anzahlVergleiche = 0;
		String[] stringsArr = erzeugenArray(pAnzahl);
		startzeit = System.currentTimeMillis();
		String[] ergebnisArr = quicksortArr(stringsArr);
		endzeit = System.currentTimeMillis();
		//ausgebenArr(ergebnisArr);
		verbrauchteZeit = endzeit - startzeit;
		System.out.println("+++ Zeitverbrauch: "+verbrauchteZeit+"ms +++");
		System.out.println("+++ Anzahl Vergleiche: "+anzahlVergleiche);

		System.out.println("Multi thread performance:");
		anzahlVergleiche = 0;
		stringsArr = erzeugenArray(pAnzahl);
		startzeit = System.currentTimeMillis();
		ergebnisArr = new QuicksortMulitThread().quicksortArr(stringsArr);
		endzeit = System.currentTimeMillis();
		//ausgebenArr(ergebnisArr);
		verbrauchteZeit = endzeit - startzeit;
		System.out.println("+++ Zeitverbrauch: "+verbrauchteZeit+"ms +++");
		System.out.println("+++ Anzahl Vergleiche: "+anzahlVergleiche);

		System.out.println("Java performance:");
		anzahlVergleiche = 0;
		stringsArr = erzeugenArray(pAnzahl);
		startzeit = System.currentTimeMillis();
		Arrays.sort(stringsArr, Comparator.naturalOrder());
		endzeit = System.currentTimeMillis();
		//ausgebenArr(ergebnisArr);
		verbrauchteZeit = endzeit - startzeit;
		System.out.println("+++ Zeitverbrauch: "+verbrauchteZeit+"ms +++");
		System.out.println("+++ Anzahl Vergleiche: "+anzahlVergleiche);
	}

	/**
	 * erzeugt eine List mit zufaelligen Strings der Laenge 10.
	 * @param pAnzahl anzahl an strings
	 */
	public List<String> erzeugen(int pAnzahl){
		List<String> ergebnis = new List<>();
		Random r = new Random();
		System.out.println("*** erzeugen("+pAnzahl+") ***");
		for(int n=0; n<pAnzahl; n++){
			String s = "";
			for (int i=0; i<10;i++)
			{
				s += (char)(r.nextInt(26) + 65);
			}
			ergebnis.append(s);
			//System.out.println(s);
		}
		return ergebnis;
	}

	public String[] erzeugenArray(int anzahl) {
		String[] ergebnis = new String[anzahl];
		Random r = new Random();
		int a = 0;
		System.out.println("*** erzeugenArr("+anzahl+") ***");
		for(int n=0; n<anzahl; n++){
			String s = "";
			for (int i=0; i<10;i++)
			{
				s += (char)(r.nextInt(26) + 65);
			}
			ergebnis[a++] = s;
		}
		return ergebnis;
	}

	public void ausgeben(List<String> pStrings){
		System.out.println();
		System.out.println("*** ausgeben() ***");
		for(pStrings.toFirst();pStrings.hasAccess(); pStrings.next()){
			System.out.println(pStrings.getContent());
		}
	}

	public void ausgebenArr(String[] pStrings){
		System.out.println();
		System.out.println("*** ausgeben() ***");
		for(int i = 0;i < pStrings.length; i++){
			System.out.println(pStrings[i]);
		}
	}

	public static void main(String[] args) {
		new GUI(new QuicksortTest());
	}

	public int fakultaet(int n) {
		return n <= 1 ? n : n * fakultaet(n-1);
	}
}

package hafen;

import gui.GUI;

public class Ship {
	private String name;
	private double maxWeight;	
	private Container[] loadedContainers;
	private String destination;
	
	// Das folgende Attribut dient nur zu Testzwecken
	private Container testcontainer = new Container(26.3, 15.6);
	
	
	public Ship(String name, double maxWeight, String destination) {
		this.name = name;
		this.maxWeight = maxWeight;
		this.destination = destination;
		loadedContainers = new Container[6];
		testcontainer.setDestination("Hamburg");
		testcontainer.setLoadedProduct("LEGO Sets");
		
	}
	
	// TODO: automatisch getters und setters generieren lassen (Source -> Generate getters and setters)
	// Alle getters generieren und überlegen, welche setters man braucht
	
	public void hireCrewMembers(int number) {
		// TODO
	}
	
	public void fireOneCrewMember() {
		// TODO
	}
	
	public boolean unloadContainer(int position) {
		// TODO
		return false;
	}
	
	public double calculateCurrentWeight() {
		// TODO
		return 0.0;
	}
	
	public int numberOfFirstEmptyPosition() {
		// TODO
		return -1;
	}
	
	private boolean checkIfFits(Container newContainer) {
		// TODO
		return false;
	}
	
	public void load(Container newContainer) {
		// TODO
	}
	

	
	

	@Override
	public String toString() {
		return name + ", maxWeight " + maxWeight + "t, Crew "
	// + numberOfCrewMembers
				+ ", goes to " + destination;
	}
		
	/*
	 * Hilfsmethode zum Ausgeben der Ladung
	 */
	public void printLoad() {
		for(int i=0; i< loadedContainers.length; i++) {
			System.out.println(loadedContainers[i]);
		}
	}
	
	/*
	 * Hilfsmethode zum Erzeugen einer Beispielbeladung
	 */
	private void createExampleoad() {
		Container c1 = new Container(24.2, 12.3);
		c1.setDestination("Hamburg");
		c1.setLoadedProduct("Oil");
		Container c2 = new Container(23.2, 23.2);
		c2.setDestination("Lisbon");
		c2.setLoadedProduct("Computer chips");
		Container c3 = new Container(15.0, 4.2);
		c3.setDestination("Antwerpen");
		c3.setLoadedProduct("Hop");
		loadedContainers[0] = c1;
		loadedContainers[2] = c2;
		loadedContainers[5] = c3;
	}
	
	
	public static void main(String[] args) {
		Ship ship = new Ship("Floating Sibi", 111.2, "Lisbon");
		ship.createExampleoad();
		new GUI(ship);
	}
	
}

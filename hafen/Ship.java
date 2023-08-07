package hafen;

import gui.GUI;

import java.util.Arrays;
import java.util.Comparator;

public class Ship {
	private String name;
	private double maxWeight;	
	private Container[] loadedContainers;
	private String destination;
	private int crewMembers;
	
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
		if(number > 0)
			crewMembers += number;
	}
	
	public void fireOneCrewMember() {
		crewMembers--;
		if(crewMembers < 0)
			crewMembers++;
	}
	
	public boolean unloadContainer(int position) {
		if(position < loadedContainers.length)
			loadedContainers[position] = null;
		else
			return false;
		return true;
	}
	
	public double calculateCurrentWeight() {
		double weight = 0;
		for(Container c : loadedContainers)
			weight += c.getLoadedWeight();
		return weight;
	}
	
	public int numberOfFirstEmptyPosition() {
		for(int i = 0; i < loadedContainers.length; i++)
			if(loadedContainers[i] == null)
				return i;
		return -1;
	}
	
	private boolean checkIfFits(Container newContainer) {
		if(calculateCurrentWeight() + newContainer.getLoadedWeight() > maxWeight)
			return false;
		if(numberOfFirstEmptyPosition() < 0)
			return false;
		return true;
	}
	
	public void load(Container newContainer) {
		if(checkIfFits(newContainer))
			loadedContainers[numberOfFirstEmptyPosition()] = newContainer;
	}

	private int numOfContainers() {
		int num = 0;
		for(Container c : loadedContainers)
			if(c == null)
				num++;
		return num;
	}

	public void moveContainersOptimally() {
		int num = numOfContainers();
		Container[] temp = new Container[num];
		for(Container c : loadedContainers)
			if(c != null)
				temp[--num] = c;
		double average = 0;
		for(Container c : temp)
			average += c.getLoadedWeight();
		average /= temp.length;
		double finalAverage = average;
		Arrays.sort(temp, Comparator.comparingDouble(o -> Math.abs(o.getLoadedWeight() - finalAverage)));
        Arrays.fill(loadedContainers, null);
		for(int i = 0; i < Math.floorDiv(temp.length, 2); i++) {
			loadedContainers[i] = temp[i];
			loadedContainers[loadedContainers.length - i - 1] = temp[temp.length - i - 1];
		}
		if(temp.length % 2 == 1)
			loadedContainers[Math.floorDiv(loadedContainers.length - 1, 2)] = temp[Math.floorDiv(temp.length, 2)];
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
        for (Container loadedContainer : loadedContainers) {
            System.out.println(loadedContainer);
        }
	}
	
	/*
	 * Hilfsmethode zum Erzeugen einer Beispielbeladung
	 */
	private void createExampleLoad() {
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
		ship.createExampleLoad();
		ship.moveContainersOptimally();
		new GUI(ship);
	}
	
}

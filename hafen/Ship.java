package hafen;

import gui.GUI;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Ship {
	private final String name;
	private double maxWeight;
	private final Container[] loadedContainers;
	private String destination;
	private int crewMembers;
	
	public Ship(String name, double maxWeight, String destination) {
		this.name = name;
		this.maxWeight = maxWeight;
		this.destination = destination;
		loadedContainers = new Container[6];
	}

	public String getName() {
		return name;
	}

	public double getMaxWeight() {
		return maxWeight;
	}

	public Container[] getLoadedContainers() {
		return loadedContainers;
	}

	public String getDestination() {
		return destination;
	}

	public int getCrewMembers() {
		return crewMembers;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}
	
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
        return numberOfFirstEmptyPosition() >= 0;
    }
	
	public void load(Container newContainer) {
		if(checkIfFits(newContainer))
			loadedContainers[numberOfFirstEmptyPosition()] = newContainer;
	}

	public double calculateBalance(List<Container> containers) {
		double sum = 0;
		for(int i = 0; i < Math.floorDiv(containers.size(), 2); i++) {
			if(containers.get(i) == null)
				continue;
			double m = -i + Math.floorDiv(containers.size(), 2);
			sum -= m * containers.get(i).getLoadedWeight();
		}
		for(int i = Math.floorDiv(containers.size(), 2); i < containers.size(); i++) {
			if(containers.get(i) == null)
				continue;
			double m = i - Math.floorDiv(containers.size(), 2) + 1;
			sum += m * containers.get(i).getLoadedWeight();
		}
		return Math.abs(sum);
	}

	private Container[] balanceC;
	private double sum;

	private void generatePermutationsHelper(List<Container> classes, int currentIndex) {
		if (currentIndex == classes.size() - 1) {
			// Base case: Reached the last element, print the permutation
			double b = calculateBalance(classes);
			if(b < sum) {
				sum = b;
				balanceC = classes.toArray(new Container[0]);
			}
			return;
		}

		for (int i = currentIndex; i < classes.size(); i++) {
			// Swap the current element with the element at the current index
			Collections.swap(classes, currentIndex, i);

			// Recursively generate permutations for the remaining elements
			generatePermutationsHelper(classes, currentIndex + 1);

			// Swap back to restore the original order
			Collections.swap(classes, currentIndex, i);
		}
	}

	public void balanceContainers() {
		balanceC = new Container[loadedContainers.length];
		sum = Double.POSITIVE_INFINITY;
		List<Container> clist = Arrays.asList(loadedContainers);
		generatePermutationsHelper(clist, 0);
		System.out.println(sum);
		System.arraycopy(balanceC, 0, loadedContainers, 0, loadedContainers.length);
	}


@Override
	public String toString() {
		return name + ", maxWeight " + maxWeight + "t, Crew "
				+ crewMembers	+ ", goes to " + destination;
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
		ship.balanceContainers();
		new GUI(ship);
	}
	
}

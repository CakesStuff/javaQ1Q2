package hafen;

import java.util.Objects;
import java.util.Random;
import gui.GUI;
import linear.StackWithViewer;


public class Harbour {
	private final String country;
	private final String city;
	private final Ship[] shipsAtAnchor;
	private final StackWithViewer<Container> cargoStack;
	
	
	// das folgende Attribut ist nur zu Testzwecken vorhanden, es muss ansonsten nicht beachtet werden
	Ship testship = new Ship("Testship I", 187.45, "Hamburg");
	
		
	public Harbour(String country, String city, int size) {		
		this.country = country;
		this.city = city;
		this.shipsAtAnchor = new Ship[size];
		testship.load(new Container(15.5, 13.3));
		testship.load(new Container(22.3, 0.2));
		this.cargoStack = new StackWithViewer<>();
		createCargoStack();
	}
	
	public void createCargoStack() {
		cargoStack.push(new Container(15, 0));
		cargoStack.top().setDestination("Test");
		cargoStack.push(new Container(10, 0));
		cargoStack.top().setDestination("Test2");
		cargoStack.push(new Container(20, 0));
		cargoStack.top().setDestination("Test");
		cargoStack.push(new Container(14, 0));
		cargoStack.top().setDestination("Test2");
	}

	public double cargoWeight() {
		StackWithViewer<Container> temp = new StackWithViewer<>();
		double weight = 0;
		while(!cargoStack.isEmpty()) {
			Container c = cargoStack.top();
			cargoStack.pop();
			weight += c.getLoadedWeight();
			temp.push(c);
		}
		while(!temp.isEmpty()) {
			cargoStack.push(temp.top());
			temp.pop();
		}
		return weight;
	}

	public boolean shipTop() {
		Container c = cargoStack.top();
		for(Ship s : shipsAtAnchor)
			if(s != null && Objects.equals(s.getDestination(), c.getDestination()))
				if(s.load(c)) {
					cargoStack.pop();
					return true;
				}
		return false;
	}

	public Container findContainer(String destination, double weightLimit) {
		StackWithViewer<Container> temp = new StackWithViewer<>();
		while(!cargoStack.isEmpty()) {
			Container c = cargoStack.top();
			cargoStack.pop();
			if(Objects.equals(c.getDestination(), destination) && c.getLoadedWeight() <= weightLimit) {
				while(!temp.isEmpty()) {
					cargoStack.push(temp.top());
					temp.pop();
				}
				return c;
			}
			temp.push(c);
		}
		while(!temp.isEmpty()) {
			cargoStack.push(temp.top());
			temp.pop();
		}
		return null;
	}

	public int countShipsInHarbour() {
		int sum = 0;
		for(Ship s : shipsAtAnchor)
			if(s != null)
				sum++;
		return sum;
	}
	
	public int giveFirstFreeAnchorage() {
		for(int i = 0; i < shipsAtAnchor.length; i++)
			if(shipsAtAnchor[i] == null)
				return i;
		return -1;		
	}
	
	public boolean leave(String leavingShipName) {
		for(int i = 0; i < shipsAtAnchor.length; i++)
			if(shipsAtAnchor[i].getName().equals(leavingShipName)) {
				shipsAtAnchor[i] = null;
				return true;
			}
		return false;
	}
	
	public boolean arrive(Ship arrivingShip) {
		for(int i = 0; i < shipsAtAnchor.length; i++)
			if(shipsAtAnchor[i] == null) {
				shipsAtAnchor[i] = arrivingShip;
				return true;
			}
		return false;
	}
	
	
	/*
	 * Hilfsmethode zum Ausgaben aller vor Anker liegenden Schiffe auf der Konsole
	 */
	public void printShips() {
		for (Ship ship : shipsAtAnchor) {
			System.out.println(ship);
		}
	}
	
	/*
	 * getters & setters
	 */
	
	public String getCountry() {
		return country;
	}

	public String getCity() {
		return city;
	}

	public Ship[] getShipsAtAnchor() {
		return shipsAtAnchor;
	}
	
	// ------------------------------------------------------------------
	
	/*
	 * Hilfsmethode zum Erzeugen der zu Beginn im Hamburger Hafen liegenden Schiffe 
	 */
	private void createAndStoreShips() {
        String[] shipNames = {"Titanic", "Queen Mary", "Bismarck", "Yamato", "Santa Maria",
        	    "USS Enterprise", "HMS Victory", "Endeavour", "Mayflower", "Fitzgerald",
        	    "Black Pearl", "Cutty Sark", "Golden Hind", "Nautilus", "Lusitania",
        	    "Constitution", "Discovery", "Nina", "Pinta", "Santa Clara"};
        String[] destinationNames = {"Rotterdam", "Lisbon", "Piräus", "Shanghai", "Los Angeles", "Guangzhou", "Antwerpen", "Le Havre", "Singapur"};
        String[] countryNames = {"Netherlands", "Portugal", "Greece", "China", "USA", "China", "Belgium", "France", "Singapur"};
        double maxWeightLimit = 250.0;
        Random random = new Random();

        

        /* Create Harbours --> Has to be moved to administration class for the harbours later
        Harbour[] destinations = new Harbour[destinationNames.length];
        for(int i=0; i<destinationNames.length; i++) {
        	destinations[i] = new Harbour(destinationNames[i], countryNames[i], 25);
        } */       
        
        // Create 20 ships for Hamburg
        for (int i = 0; i < 20; i++) {
            String name = shipNames[i];            
            double maxWeight = (double)(Math.round(100 * random.nextDouble() * maxWeightLimit)+5000)/100;
            if( maxWeight > maxWeightLimit) maxWeight = maxWeightLimit;
           
            int harbourNumber = random.nextInt(destinationNames.length);
            Ship ship = new Ship(name, maxWeight, destinationNames[harbourNumber]);

            int randomIndex;
            do {
                randomIndex = random.nextInt(shipsAtAnchor.length);
            } while (shipsAtAnchor[randomIndex] != null);

            shipsAtAnchor[randomIndex] = ship;
        }
	}
	
	/*
	 * main-Methode
	 */
	public static void main(String[] args) {
		Harbour theHarbour = new Harbour("Germany", "Hamburg", 30);
		theHarbour.createAndStoreShips();
		new GUI(theHarbour);
		
	}
}

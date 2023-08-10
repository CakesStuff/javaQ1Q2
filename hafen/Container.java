package hafen;

public class Container {
	private double maxWeight, currentWeight;
	private String loadedProduct;
	private String destination;
	

	
		
	public Container(double maxWeight, double currentWeight) {
		super();
		this.maxWeight = maxWeight;
		this.currentWeight = currentWeight;
		this.loadedProduct = null;
		this.destination = null;
		
	}
	
	public void empty() {
		loadedProduct = null;
		currentWeight = 0;
	}
		
	public boolean canFit(double weight) {
		return weight + currentWeight <= maxWeight;
	}
	
	public void loadProduct(double weight) {
		if(canFit(weight))
			currentWeight += weight;
	}
		
	public double getMaxWeight() {
		return maxWeight;
	}

	public double getLoadedWeight() {
		return currentWeight;
	}

	public String getLoadedProduct() {
		return loadedProduct;
	}

	public String getDestination() {
		return destination;
	}
	
	public void setDestination(String destination) {
		this.destination = destination;
	}
	
	public void setLoadedProduct(String loadedProduct) {
		this.loadedProduct = loadedProduct;
	}

	@Override
	public String toString() {
		return "Container - Max: " + maxWeight + "t, current: " + currentWeight + "t,  "
				+ loadedProduct + ", goes to " + destination;
	}
	
	
}

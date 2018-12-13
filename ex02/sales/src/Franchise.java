
public class Franchise {
	private Store stores[];

	public Franchise(int num) {
		stores = new Store[num];
	}

	public void preCalculate() {
		for (Store store : stores)
			store.analyzeResults();
	}

	public Store getStores(int i) {
		return stores[i];
	}

	public void setStores(Store stores, int i) {
		this.stores[i] = stores;
	}

	public int getNumberOfStores() {
		return stores.length;
	}

}

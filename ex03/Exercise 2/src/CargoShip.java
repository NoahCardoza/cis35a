import java.util.ArrayList;
import java.util.List;

public class CargoShip extends Ship {
		
	private List<String> cargoHold;
	private int cargoHoldSize;
	
	CargoShip(String name, int cargoHoldSize) {
		super(name, 20 /* knots */);
		cargoHold = new ArrayList<String>();
		this.cargoHoldSize = cargoHoldSize;
	}
	
	public boolean packCargo(String cargo) {
		if (cargoHold.size() >= cargoHoldSize) return false;
		cargoHold.add(cargo);
		return true;
	}
	
	public List<String> getCargoManifest() {
		return cargoHold;
	}
	
	public void unloadAllCargo() {
		cargoHold.clear();
	}
	
	public void unloadCargoItem(int index) {
		cargoHold.remove(index);
	}
	
	public void unloadCargoItem(String value) {
		cargoHold.remove(value);
	}
	
	public void print() {
		System.out.printf("CargoShip<%s, cargoHoldSize=%d, cargoHold=%s>\n", formatPrintableString(), cargoHoldSize, Utils.formatArray(cargoHold));
	}

}

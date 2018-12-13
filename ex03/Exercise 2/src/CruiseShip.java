import java.util.ArrayList;
import java.util.List;

public class CruiseShip extends Ship {

	private List<String> passengers;
	private int passengersCompacity;
	
	CruiseShip() {
		passengers = new ArrayList<String>();
	}

	CruiseShip(String name, int passengersCompacity) {
		super(name, 30 /* knots */);
		passengers = new ArrayList<String>();
		this.passengersCompacity = passengersCompacity;
	}
	
	public boolean addPassenger(String name) {
		if (passengers.size() >= passengersCompacity) return false;
		passengers.add(name);
		return true;
	}
	
	public List<String> getPassengerRoster() {
		return passengers;
	}
	
	public void unloadAllPassengers() {
		passengers.clear();
	}
	
	public void unloadAPassenger(int index) {
		passengers.remove(index);
	}
	
	public void unloadAPassenger(String name) {
		passengers.remove(name);
	}
	
	public void print() {
		System.out.printf("CargoShip<%s, passengersCompacity=%d, passengers=%s>\n", formatPrintableString(), passengersCompacity, Utils.formatArray(passengers));
	}
	
	public int getPassengersCompacity() {
		return passengersCompacity;
	}

	public void setPassengersCompacity(int passengersCompacity) {
		this.passengersCompacity = passengersCompacity;
	}
}

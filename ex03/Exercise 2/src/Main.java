import java.util.stream.Stream;

public class Main {

	public static void main(String[] args) {
		CargoShip cargoShip = new CargoShip("SS Java", 127);
		CruiseShip cruiseShip = new CruiseShip("MS JVM", 255);
		
		cargoShip.christen("Perl Harbor", 49.288826, -123.111122);
		cruiseShip.christen("Port Metro Vancouver", 42.364506, -71.038887);
		
		cruiseShip.addPassengers("Barack Obama");
		cruiseShip.addPassengers("Bruno Mars");
		cruiseShip.addPassengers("Jason Momoa");
		
		cargoShip.packCargo("Cannabis");
		cargoShip.packCargo("Maple Syrup");
		cargoShip.packCargo("Kindness");
		
		cargoShip.print();
		cruiseShip.print();
		
		Stream<Ship> ships = Stream.of(cargoShip, cruiseShip);
		
		System.out.printf("Both ships will arrive at (lat: 0, long: 0) in %.2f hours.\n", ships.mapToDouble(ship -> ship.sailTo(0, 0)).max().getAsDouble());
	}

}

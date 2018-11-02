
public class Ship {
	private double latitude, longitude, topSpeed;
	private String name = "";
	private String launchedFrom = "";
	
	Ship(String shipName, double speed){
		name = shipName;
		topSpeed = speed;
	}
	
	void christen(String harbor, double lat, double lon) {
		launchedFrom = harbor;
		latitude = lat;
		longitude = lon;
	}
	
	double sailTo(double lat, double lon) {
		double distance = distance(latitude, lat, latitude, lon, 0, 0);
		latitude = lat;
		longitude = lon;
		//                m -> mi
		return distance / 1609.34 / topSpeed;
	}
	
	public String formatPrintableString() {
		return String.format("name=\"%s\", launchedFrom=\"%s\", latitude=%f, longitude=%f, topSpeed=%.2f knots", name, launchedFrom, latitude, longitude, topSpeed);
	}
	
	/**
	 * Credit: https://stackoverflow.com/a/16794680/6169961
	 * Calculate distance between two points in latitude and longitude taking
	 * into account height difference. If you are not interested in height
	 * difference pass 0.0. Uses Haversine method as its base.
	 * 
	 * lat1, lon1 Start point lat2, lon2 End point el1 Start altitude in meters
	 * el2 End altitude in meters
	 * @returns Distance in Meters
	 */
	public static double distance(double lat1, double lat2, double lon1,
	        double lon2, double el1, double el2) {

	    final int R = 6371; // Radius of the earth

	    double latDistance = Math.toRadians(lat2 - lat1);
	    double lonDistance = Math.toRadians(lon2 - lon1);
	    double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
	            + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
	            * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
	    double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
	    double distance = R * c * 1000; // convert to meters

	    double height = el1 - el2;

	    distance = Math.pow(distance, 2) + Math.pow(height, 2);

	    return Math.sqrt(distance);
	}
}

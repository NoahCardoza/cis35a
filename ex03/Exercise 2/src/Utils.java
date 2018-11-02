import java.util.List;
import java.util.stream.Collectors;

public class Utils {
	public static String formatArray(List<String> arr){
		return "[\"" + arr.stream().collect(Collectors.joining("\", \"")) + "\"]";
	}
}

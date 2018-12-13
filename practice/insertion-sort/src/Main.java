public class Main {
	static int wall;
	public static void printIntArr(int[] a) {
		System.out.print('[');
		for (int i : a) {
			System.out.print(i + ", ");
		}
		System.out.println(']');
	}
	
	public static int[] sort (int[] a) {
		int j, val;
		
		for (int i = 1; i < a.length; i++) {
			j = i - 1;
			val = a[i];
			
			while (j >= 0 && val < a[j])
				a[j + 1] = a[j--];
			
			
			a[j + 1] = val;	
		}
		
		return a;
	}

	public static void main(String[] args) {
		int[] arr = new int[] {-5, -55, 19, 30, -453, -5555};
		
		printIntArr(sort(arr));
	}

}

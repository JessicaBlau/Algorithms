package MinMax;

public class MinMax {
	public static int MinMaxPairs(int [] arr) {
		int comparisons = 1;
		int min = arr[0];
		int max = arr[1];

		if(arr[0] > arr[1]) { min = arr[1]; max = arr[0];}

		for (int i = 2; i < arr.length-1; i = i+2) {
			comparisons++;
			if(arr[i] <= arr[i+1]) {
				comparisons = comparisons+2;
				if(arr[i] < min) {min = arr[i];}
				if(arr[i+1] > max) {max = arr[i+1];}
			}
			else {
				comparisons = comparisons+2;
				if(arr[i+1] < min) {min = arr[i+1];}
				if(arr[i] > max) {max = arr[i];}
			}
			if(arr.length%2 != 0) {
				comparisons++;
				if(arr[arr.length-1] > max) {max = arr[arr.length-1];}
				else {
					comparisons++;
					if(arr[arr.length-1] < min) {min = arr[arr.length -1];}
				}
			}
		}
		System.out.println("Min = "+min+", Max = "+max);
		return comparisons;
	}
	public static void main(String[] args) {
		int size = 100;
		System.out.println("size = " + size);
		int[]arr = new int[size];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) (Math.random()*1000);
		}
		System.out.println(MinMaxPairs(arr));
		
	}
}

package lecture;

import java.util.Arrays;

public class LectureFour {

	public static void main(String[] args) {
		int[] arr = new int[200];
		for(int i= 0; i < arr.length; i++) {
			arr[i]=  (int) Math.floor(Math.random() * 100);
		}
		double[] items = {9.2,7.1,10.0,9.5,1.8};
		bubbleSort(items);
		System.out.print(Arrays.toString(items));
		
	}
	
	public static void twoDimensions() {
		int [][] arr = new int [3][4];
		int increment = 1;
		for(int row = 0; row < arr.length; row++) {
			for (int col = 0; col < arr[row].length;col++) {
				arr[row][col] = increment  * 10;
				increment++;
			}
		}
		for(int row = 0; row < arr.length; row++) {
			for (int col = 0; col < arr[row].length;col++) {
				System.out.print(arr[row][col] + "\t");
			}
			System.out.println();
		}
	}
	public static void twoRandomDimension() {
		int [][] arr = new int [3][4];
		for(int row = 0; row < arr.length; row++) {
			for(int col = 0; col < arr[row].length; col++) {
				arr[row][col] = (int) Math.floor(Math.random() * 100);
			}
		}
		
		for(int row = 0; row < arr.length; row++) {
			for(int col = 0; col < arr[row].length; col++) {
				System.out.print(arr[row][col] + "\t");
			}
			System.out.println();
		}
	}
	public static int binarySearch(int[] values, int searchValue) {
		int i0 = 0, i1 = values.length-1;
		while (i0 < i1) {
			int iMid = (i0+i1)/2, v = values[iMid];
			if(v == searchValue) return iMid;
			if(v > searchValue) i1 = iMid -1; else i0 = iMid+1;
		}
		return ~i0;
	}
	
	public static void bubbleSort(double[] values) {
		boolean swap = true;
		while(swap) {
			swap = false;
			for (int i = 1; i < values.length; i++) {
				if(values[i-1]> values[i]) {
					double temp = values[i];
					values[i] = values[i-1];
					values[i-1] = temp;
					swap = true;
				}
			}
		}
	}

}

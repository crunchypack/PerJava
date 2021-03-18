package lecture;

public class LectureFour {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println();
		twoDimensions();
		System.out.println("\n***************************\n");
		twoRandomDimension();
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

}

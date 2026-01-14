package ch03;

public class Test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n[][] = {{1},{1,2,3},{1},{1,2,3,4},{1,2}};
    	for (int i =0; i<n.length; i++) {
    		for (int j : n[i]) {
    			System.out.print(j + " ");
    		}
    		System.out.println();
    	}

	}

}

import java.util.ArrayList;
import java.util.Random;

public class Fermi {

	private int numOne;
	private int numTwo;
	private int numThree;
	private ArrayList<Integer> distinctNumbers;
	
	//------------------------------------ Construction
	public Fermi() {
		getDistinctNumbers();
		setNumOne();
		setNumTwo();
		setNumThree();
	}
	
		
	//------------------------------------ Public Methods
	
	public void getDistinctNumbers() {
	    Random random = new Random();
	    distinctNumbers = new ArrayList<Integer>();
	    
	    // will keep looping until the size of the array reaches 3
	    while (distinctNumbers.size() < 3) {
	    	// Generates the random integer from 1 to 9
	        int x = random.nextInt(8)+1; 
	        // If the integer that is generated is no already in the array list it will be added to the next spot in the arraylist
	        if (!distinctNumbers.contains(x)) {
	        	distinctNumbers.add(x);
	        }
	    }
	    System.out.println(distinctNumbers);
	}
	
	//------------------------------------ Gets & Sets 
	
	public int getNumOne() {
		return numOne;
	}
	
	public int getNumTwo() {
		return numTwo;
	}
	
	public int getNumThree() {
		return numThree;
	}
	
	public void setNumOne() {
		// setting numOne by getting its value from the arraylist
		numOne = distinctNumbers.get(0);
		//System.out.println(numOne);
	}
	
	public void setNumTwo() {
		// setting numTwo by getting its value from the arraylist
		numTwo = distinctNumbers.get(1);
		//System.out.println(numTwo);
	}
	
	public void setNumThree() {
		// setting numThree by getting its value from the arraylist
		numThree = distinctNumbers.get(2);
		//System.out.println(numThree);
	}
	
	
	
	
	
}

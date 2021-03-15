import java.util.ArrayList;
import java.util.Random;

public class Fermi {

	private int numOne;
	private int numTwo;
	private int numThree;
	private int first;
	private int second;
	private int third;
	private boolean win;
	private String allOutput;
	private ArrayList<Integer> distinctNumbers;
	private ArrayList<Integer> hintOutputOrder;
	private ArrayList<String> hintOutput;
	
	//------------------------------------ Construction
	public Fermi() {
		getDistinctNumbers();
		setTargetOne();
		setTargetTwo();
		setTargetThree();
	}
	
		
	//------------------------------------ Public Methods
	// This method will generate distinct numbers to be used as the target numbers in the guessing game
	public void getDistinctNumbers() {
		// new random object
	    Random random = new Random();
	    // create arrayList to add the numbers that are generated 
	    distinctNumbers = new ArrayList<Integer>();
	    
	    // will keep looping until the size of the array reaches 3
	    while (distinctNumbers.size() < 3) {
	    	// Generates the random integer from 1 to 9
	        int x = random.nextInt(8)+1; 
	        // If the integer that is generated is no already in the array list it will be added to the next spot in the arrayList
	        if (!distinctNumbers.contains(x)) {
	        	// If the number generated is not in the arrayList it will add the new number to the arrayList
	        	distinctNumbers.add(x);
	        }
	    }
	    //System.out.println(distinctNumbers);
	}
	
	//------------------------------------ Gets & Sets 
	// This method will return the first target number
	public int getTargetOne() {
		return numOne;
	}
	// This method will return the second target number
	public int getTargetTwo() {
		return numTwo;
	}
	// This method will return the third target number
	public int getTargetThree() {
		return numThree;
	}
	// This method will set the first target number
	public void setTargetOne() {
		// setting numOne by getting its value from the arrayList
		numOne = distinctNumbers.get(0);
		//System.out.println(numOne);
	}
	// This number will set the second target number
	public void setTargetTwo() {
		// setting numTwo by getting its value from the arrayList
		numTwo = distinctNumbers.get(1);
		//System.out.println(numTwo);
	}
	// This number will set the third target number
	public void setTargetThree() {
		// setting numThree by getting its value from the arrayList
		numThree = distinctNumbers.get(2);
		//System.out.println(numThree);
	}
	// This method will return all output for the hints and numbers that are guessed for the JTextArea output
	public String getAllOutput() {
		return allOutput;
	}
	// This will return if the user has won the game or not
	public boolean gameWin() {
		return win;
	}
	
	
	
	//----------------------------------- Public Methods
	// This method will reset the output of allOutput so that it is ready for the next time it is going to be used
	public void resetAllOutput() {
		allOutput = "";
	}
	// This method will reset the win to false 
	public void resetGameWin() {
		win = false;
	}
	
	
	
	// This method will randomly generate what order the three hints are printed out in
	public void getOutputOrder() {
	    Random random = new Random();
	    hintOutputOrder = new ArrayList<Integer>();
	    
	    // will keep looping until the size of the array reaches 3
	    while (hintOutputOrder.size() < 3) {
	    	// Generates the random integer from 1 to 3
	        int x = random.nextInt(3); 
	        // If the integer that is generated is no already in the array list it will be added to the next spot in the arrayList
	        if (!hintOutputOrder.contains(x)) {
	        	// The order will be added to this arrayList for further use when outputting
	        	hintOutputOrder.add(x);
	        }
	    }
	    //System.out.println(hintOutputOrder);
	}
	// This method is used to test the inputs to see if they are correct
	public void testMatches(int guess1, int guess2, int guess3) {
		// Create the array to store the values of the guess
		hintOutput = new ArrayList<String>();
		// Set the win to false
		win = false;
		// Set alloutput to empty
		allOutput = "";
		// Get the order that the hint will be displayed 
		getOutputOrder();
		// Set the string to nothing
		String test1 = "";
		String test2 = "";
		String test3 = "";
		// ----------------------------- Testing Target One 
		if(guess1 == getTargetOne()) {
			test1 = "fermi";
			//System.out.println("Target 1 - 1 fermi");
		}
		if(guess1 == getTargetTwo()) {
			test1 = "pico";
			//System.out.println("Target 1 - 2 pico");
		}
		if(guess1 == getTargetThree()) {
			test1 = "pico";
			//System.out.println("Target 1 - 3 pico");
		}
		if(guess1 != getTargetOne() && guess1 != getTargetTwo() && guess1 != getTargetThree()) {
			test1 = "nano";
			//System.out.println("Target 1 - 4 nano");
		}
		
		// ----------------------------- Testing Target Two 
		if(guess2 == getTargetTwo()) {
			test2 = "fermi";
			//System.out.println("Target 2 - 1 fermi");
		}
		if(guess2 == getTargetOne()) {
			test2 = "pico";
			//System.out.println("Target 2 - 2 pico");
		}
		if(guess2 == getTargetThree()) {
			test2 = "pico";
			//System.out.println("Target 2 - 3 pico");
		}
		if(guess2 != getTargetTwo() && guess2 != getTargetOne() && guess2 != getTargetThree()) {
			test2 = "nano";
			//System.out.println("Target 2 - 4 nano");
		}
		
		// ----------------------------- Testing Target Three
		if(guess3 == getTargetThree()) {
			test3 = "fermi";
			//System.out.println("Target 3 - 1 fermi");
		}
		if(guess3 == getTargetOne()) {
			test3 = "pico";
			//System.out.println("Target 3 - 2 pico");
		}
		if(guess3 == getTargetTwo()) {
			test3 = "pico";
			//System.out.println("Target 3 - 3 pico");
		}
		if(guess3 != getTargetThree() && guess3 != getTargetOne() && guess3 != getTargetTwo()) {
			test3 = "nano";
			//System.out.println("Target 3 - 4 nano");
		}
		
		// Set the hintoutputs 
		hintOutput.add(test1);
		hintOutput.add(test2);
		hintOutput.add(test3);
		// Get order to print out the hints randomly
		first = hintOutputOrder.get(0);
		second = hintOutputOrder.get(1);
		third = hintOutputOrder.get(2);
		// Check is user won the game 
		if(test1 == "fermi" && test2 == "fermi" && test3 == "fermi") {
			// Set win to true if user won the game 
			win = true;
		}
		// Set alloutput for the guess and the hints
		allOutput = guess1 + " " + guess2 + " " + guess3 + " " + hintOutput.get(first)+ " " + hintOutput.get(second) + " " + hintOutput.get(third);
		
		//System.out.println(allOutput);
	}	
	
}

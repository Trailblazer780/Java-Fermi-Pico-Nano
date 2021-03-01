
public class Fermi {

	private int numOne;
	private int numTwo;
	private int numThree;
	
	//------------------------------------ Construction
	public Fermi() {
		setNumOne();
		setNumTwo();
		setNumThree();
	}
	
	
	
	//------------------------------------ Public Methods
	public int randomNumbers(int min, int max) {
		int random = (int)(Math.random() * max + min);
		return random;
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
		numOne = randomNumbers(1,9);
		System.out.println(numOne);
	}
	
	public void setNumTwo() {
		numTwo = randomNumbers(1,9);
		System.out.println(numTwo);
	}
	
	public void setNumThree() {
		numThree = randomNumbers(1,9);
		System.out.println(numThree);
	}
	
	
	
	
	
}

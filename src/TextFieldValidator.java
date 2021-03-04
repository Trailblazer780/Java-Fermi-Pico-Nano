import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class TextFieldValidator {
	private JFrameForm resett;
	//private final String VALID_GUESS = "[1-9]";
	
	//----------------------------------------------------- Constructor method
	public TextFieldValidator() {
		
	}
	
	public TextFieldValidator(JTextField guess) {
		check(guess);
	}
	
	public TextFieldValidator(JTextField guess, Color errorColor) {
		guess.setBorder(BorderFactory.createLineBorder(errorColor, 1));
	}
	
	
	//------------------------------------------------------ Public Methods
	

	public boolean check(JTextField guess) {
		boolean isValid = false;
		//guess = Integer.parseInt(guess.getText());
		if (guess.getText().matches(setRegExp())) {
			isValid = true;
			// 
		}
		else {
			isValid = false;
			TextFieldValidator error = new TextFieldValidator(guess, setErrorColor());
		}
		System.out.println(isValid);
		
		return isValid;
	}
	

	public void reset(JTextField txtGuess1, JTextField txtGuess2, JTextField txtGuess3) {
		txtGuess1.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
		txtGuess2.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
		txtGuess3.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
	}
	
	//------------------------------------------------------ gets and sets 
	
	public String setRegExp() {
		final String VALID_GUESS = "[1-9]";
		return VALID_GUESS;
	}
	
	public Color setErrorColor() {
		final Color myErrorColor = new Color(255,0,0);
		return myErrorColor;
	}
	
}

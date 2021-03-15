import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class JFrameForm extends JFrame {

	private JPanel contentPane;
	private JTextField txtGuess1;
	private JTextField txtGuess2;
	private JTextField txtGuess3;
	private TextFieldValidator txtValidator1;
	private TextFieldValidator txtValidator2;
	private TextFieldValidator txtValidator3;
	public JTextArea txtOutput;
	private JButton btnOk;
	private int guess1;
	private int guess2;
	private int guess3;
	private int number1;
	private int number2;
	private int number3;
	private int guessCount;
	private boolean win;
	private String hintOutput;
	private Fermi newGame;
	 

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrameForm frame = new JFrameForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}

	/**
	 * Create the frame.
	 */
	public JFrameForm() {
		// Start a new game 
		newGame = new Fermi();
		// Get the target numbers 
		number1 = newGame.getTargetOne();
		number2 = newGame.getTargetTwo();
		number3 = newGame.getTargetThree();
		// set guess count to 0
		guessCount = 0;

		setTitle("Fermi Guessing Game");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 542, 378);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		// Create the txtGuess1 and add to content pane
		setContentPane(contentPane);
		contentPane.setLayout(null);
		txtGuess1 = new JTextField();
		txtGuess1.setBounds(27, 87, 86, 27);
		txtGuess1.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
		contentPane.add(txtGuess1);
		txtGuess1.setColumns(10);
		
		// Create the txtGuess2 and add to content pane
		txtGuess2 = new JTextField();
		txtGuess2.setColumns(10);
		txtGuess2.setBounds(27, 123, 86, 27);
		txtGuess2.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
		contentPane.add(txtGuess2);
		
		// Create the txtGuess3 and add to content pane
		txtGuess3 = new JTextField();
		txtGuess3.setColumns(10);
		txtGuess3.setBounds(27, 161, 86, 27);
		txtGuess3.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
		contentPane.add(txtGuess3);

		// Create the textFieldValidator objects
		// validate txtGuess1
		txtValidator1 = new TextFieldValidator(txtGuess1);
		// set regular expression to check the guess against 
		txtValidator1.setRegExp("[1-9]");
		// validate txtGuess2
		txtValidator2 = new TextFieldValidator(txtGuess2);
		// set regular expression to check the guess against
		txtValidator2.setRegExp("[1-9]");
		// validate txtGuess3
		txtValidator3 = new TextFieldValidator(txtGuess3);
		// set regular expression to check the guess against
		txtValidator3.setRegExp("[1-9]");
		

		JLabel lblTitle = new JLabel("Fermi Guessing Game");
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTitle.setBounds(27, 24, 184, 27);
		contentPane.add(lblTitle);
		
		// Instructions for the user
		JLabel lblInstructions = new JLabel("Enter your three guesses (0-9):");
		lblInstructions.setBounds(27, 62, 184, 14);
		contentPane.add(lblInstructions);
		
		// Create the Ok button and add it to the content pane
		btnOk = new JButton("Ok");
		// Add action listener to ok button
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// When ok button is clicked call the on clicked method
				onClicked(e);
			}
		});
		btnOk.setBounds(27, 199, 86, 23);
		contentPane.add(btnOk);
		
		// Create the reset button and add it to the content pane
		JButton btnReset = new JButton("Reset");
		// Add action listener to reset button 
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// When reset button is pressed call the reset game method
				resetGame();
			}
		});
		btnReset.setBounds(27, 280, 86, 27);
		contentPane.add(btnReset);
		
		JLabel lblHints = new JLabel("Hints:");
		lblHints.setBounds(230, 62, 46, 14);
		contentPane.add(lblHints);
		
		// Create the JTextArea for the output and add it to the content pane 
		txtOutput = new JTextArea();
		// Print out answer for testing purposes 
		txtOutput.setText("answer: " + newGame.getTargetOne()+" : " + newGame.getTargetTwo() + " : " + newGame.getTargetThree() + "\n");
		JScrollPane pnlScroll = new JScrollPane(txtOutput, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		pnlScroll.setBounds(230, 87, 259, 220);
		contentPane.add(pnlScroll);
		
			
	}
	// This block of code is run when the Ok button has been clicked and starts to check the input in the 3 fields
	private void onClicked(ActionEvent e) {
		// Check if the guess is correct
		if(txtValidator1.check() == true) {
			// If the guess passes the regular expression it will parse it into an integer
			guess1 = Integer.parseInt(txtGuess1.getText());
			// Set the error color of the input box to default if the guess passes the check
			txtValidator1.setErrorColor(Color.GRAY);
			//System.out.println(guess1);
		}
		
		// Check if the guess is correct
		if(txtValidator1.check() == false) {
			// If the guess does not pass the check it will set the error color to red
			txtValidator1.setErrorColor(new Color(255,0,0));
			//System.out.println(guess1);
		}
		
		// Check if the guess is correct
		if(txtValidator2.check() == true) {
			// If the guess passes the regular expression it will parse it into an integer
			guess2 = Integer.parseInt(txtGuess2.getText());
			// Set the error color of the input box to default if the guess passes the check
			txtValidator2.setErrorColor(Color.GRAY);
			//System.out.println(guess2);
		}
		
		// Check if the guess is correct
		if(txtValidator2.check() == false) {
			// If the guess does not pass the check it will set the error color to red
			txtValidator2.setErrorColor(new Color(255,0,0));
			//System.out.println(guess1);
		}	
		
		// Check if the guess is correct
		if(txtValidator3.check() == true) {
			// If the guess passes the regular expression it will parse it into an integer
			guess3 = Integer.parseInt(txtGuess3.getText());
			// Set the error color of the input box to default if the guess passes the check
			txtValidator3.setErrorColor(Color.GRAY);
			//System.out.println(guess3);
		}
		
		// Check if the guess is correct
		if(txtValidator3.check() == false) {
			// If the guess does not pass the check it will set the error color to red
			txtValidator3.setErrorColor(new Color(255,0,0));
			//System.out.println(guess3);
		}
		
		// Check to see if all 3 pass the check against the regexp 
		if(txtValidator1.check() == true && txtValidator2.check() == true && txtValidator3.check() == true) {
			// If all pass then it will test the guesses to see if the user has won or not
			newGame.testMatches(guess1, guess2, guess3);
			// Increase the guess count every time the button is clicked and all input is valid
			guessCount++;
			//System.out.println(guessCount);
		}
		
		// Check to see if the user won the game
		if(newGame.gameWin() == true) {
			// This will get all of the output for the user 
			txtOutput.append(newGame.getAllOutput() +"\n");
			// Tell the user that they have won the game
			txtOutput.append("Congratulation you won! " + guessCount + " guesses" +"\n");
			// Disable the Ok button
			btnOk.setEnabled(false);
		}
		else {
			// If user did not win this will print out the next 3 hints 
			txtOutput.append(newGame.getAllOutput() +"\n");
		}

	}
	
	// This method is used to reset all inputs and output for the game getting it ready for a new game 
	public void resetGame() {
		// Sets output box to empty
		txtOutput.setText("");
		// Sets the guess 1 box to be empty 
		txtGuess1.setText("");
		// Sets the guess 2 box to be empty 
		txtGuess2.setText("");
		// Sets the guess 3 box to be empty 
		txtGuess3.setText("");
		// Initializes a new game 
		newGame = new Fermi();
		// Sets all output of new game to be empty 
		newGame.resetAllOutput();
		// Resets the game win back to false
		newGame.resetGameWin();
		// Prints out answer for testing purposes
		txtOutput.setText("answer: " + newGame.getTargetOne()+" : " + newGame.getTargetTwo() + " : " + newGame.getTargetThree()+ "\n");
		// Gets the new target number 1
		number1 = newGame.getTargetOne();
		// Gets the new target number 2
		number2 = newGame.getTargetTwo();
		// Gets the new target number 3
		number3 = newGame.getTargetThree();
		// Reset the textValidator 
		txtValidator1.reset();
		// Reset the textValidator
		txtValidator2.reset();
		// Reset the textValidator
		txtValidator3.reset();
		// Enable the ok button for the new game 
		btnOk.setEnabled(true);
		// Reset the guess count back to 0 for the new game
		guessCount = 0;
	}
	
}

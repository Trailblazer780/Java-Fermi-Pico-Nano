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
	private TextFieldValidator getInput;
	private TextFieldValidator getInput2;
	private TextFieldValidator getInput3;
	private TextFieldValidator resetting;
	public JTextArea txtOutput;

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
		
		//Fermi newGame = new Fermi();
		//txtOutput.setText("answer: ");
	}

	/**
	 * Create the frame.
	 */
	public JFrameForm() {
		Fermi newGame = new Fermi();
		TextFieldValidator access = new TextFieldValidator();
		setTitle("Fermi Guessing Game");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 542, 378);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		txtGuess1 = new JTextField();
		txtGuess1.setBounds(27, 87, 86, 27);
		txtGuess1.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
		contentPane.add(txtGuess1);
		txtGuess1.setColumns(10);
		
		txtGuess2 = new JTextField();
		txtGuess2.setColumns(10);
		txtGuess2.setBounds(27, 123, 86, 27);
		txtGuess2.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
		contentPane.add(txtGuess2);
		
		txtGuess3 = new JTextField();
		txtGuess3.setColumns(10);
		txtGuess3.setBounds(27, 161, 86, 27);
		txtGuess3.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
		contentPane.add(txtGuess3);
		
		JLabel lblTitle = new JLabel("Fermi Guessing Game");
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTitle.setBounds(27, 24, 184, 27);
		contentPane.add(lblTitle);
		
		JLabel lblInstructions = new JLabel("Enter your three guesses (0-9):");
		lblInstructions.setBounds(27, 62, 184, 14);
		contentPane.add(lblInstructions);
		
		JButton btnOk = new JButton("Ok");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TextFieldValidator getInput = new TextFieldValidator(txtGuess1);
				TextFieldValidator getInput2 = new TextFieldValidator(txtGuess2);
				TextFieldValidator getinput3 = new TextFieldValidator(txtGuess3);
			}
		});
		btnOk.setBounds(27, 199, 86, 23);
		contentPane.add(btnOk);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				access.reset(txtGuess1, txtGuess2, txtGuess3);
				resetGame();
			}
		});
		btnReset.setBounds(27, 280, 86, 27);
		contentPane.add(btnReset);
		
		JLabel lblHints = new JLabel("Hints:");
		lblHints.setBounds(230, 62, 46, 14);
		contentPane.add(lblHints);
		
		txtOutput = new JTextArea();
		txtOutput.setText("answer: " + newGame.getNumOne()+" : " + newGame.getNumTwo() + " : " + newGame.getNumThree());
		JScrollPane pnlScroll = new JScrollPane(txtOutput, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		pnlScroll.setBounds(230, 87, 259, 220);
		contentPane.add(pnlScroll);
		
	}
	
	public void resetGame() {
		txtOutput.setText("");
		txtGuess1.setText("");
		txtGuess2.setText("");
		txtGuess3.setText("");
		Fermi newGame = new Fermi();
		txtOutput.setText("answer: " + newGame.getNumOne()+" : " + newGame.getNumTwo() + " : " + newGame.getNumThree());
	}
	
}

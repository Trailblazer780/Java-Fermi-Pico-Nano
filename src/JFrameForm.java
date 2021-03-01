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

public class JFrameForm extends JFrame {

	private JPanel contentPane;
	private final JTextField txtGuess1 = new JTextField();
	private JTextField txtGuess2;
	private JTextField txtGuess3;

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
		setTitle("Fermi Guessing Game");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 542, 378);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
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
		btnOk.setBounds(27, 199, 86, 23);
		contentPane.add(btnOk);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnReset.setBounds(27, 280, 86, 27);
		contentPane.add(btnReset);
		
		JTextArea txtOutput = new JTextArea();
		txtOutput.setEditable(false);
		txtOutput.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
		txtOutput.setBounds(230, 87, 259, 220);
		contentPane.add(txtOutput);
		
		JLabel lblHints = new JLabel("Hints:");
		lblHints.setBounds(230, 62, 46, 14);
		contentPane.add(lblHints);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(472, 87, 17, 183);
		contentPane.add(scrollBar);
	}
	
	
	
}
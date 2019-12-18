package eg.edu.alexu.csd.oop.game;

import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import java.awt.Toolkit;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.event.WindowEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class MainFrame extends JFrame {

	/** image put as icon */
	private ImageIcon exitIcon = null;
	/** instence of OptionButtons */
	private OptionsButtons options = null;
	/** instence of NewGamePanel */
	private NewGamePanel newGame = null;

	public MainFrame() {
		super.setTitle("Circus Game");
		super.setSize(1200,700);
		super.setResizable(false);
		super.setLocationRelativeTo(null);
		super.setIconImage(Toolkit.getDefaultToolkit().getImage("photos/circus.png"));
		super.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

		/** 
		*	there is some magic on this area I don't really know how it works 
		*/
		super.setLayout(new BorderLayout());
		super.setContentPane(new JLabel(new ImageIcon("photos/bg.jpg")));
		super.setLayout(new FlowLayout(0,450,175));

		this.options = OptionsButtons.getInstance();
		this.newGame = NewGamePanel.getInstance();
		this.addSettingsToButtons();
		super.add(options);

		super.setSize(1199, 699);
		super.setSize(1200, 700);

		super.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				exitIcon = new ImageIcon("photos/icons8-question-mark-64.png");    
				int check = JOptionPane.showConfirmDialog(MainFrame.this, "Are you sure to exit?", "EXIT", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, exitIcon);
				if(check == JOptionPane.YES_OPTION)
					MainFrame.this.dispose();
			}
			@Override
			public void windowClosed(WindowEvent e) {
				System.out.println("The programm terminated succesfully...");
			}
		});
	}

	private void addSettingsToButtons() {
		options.getNewGameButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				getContentPane().removeAll();
				repaint();
				setLayout(null);
				add(newGame);
			}
		});

		newGame.getDoneButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
	} 
}
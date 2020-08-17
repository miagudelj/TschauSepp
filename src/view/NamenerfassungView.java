/**
 * 
 */
package view;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.*;

import model.Game;
import model.Player;
import service.ImageFinder;

/**
 * @author Mia Gudelj
 * @since 29.06.2020
 * @version 1.0
 *
 */
public class NamenerfassungView extends JDialog {

	private JTextField nameText1, nameText2, nameText3, nameText4;
	private JLabel nameLabel1, nameLabel2, nameLabel3, nameLabel4, title;
	private JButton start, back;
	private JPanel titlePanel, bodyPanel, panel, buttonPanel, buttonInnerPanel;

	/**
	 * 
	 */
	public NamenerfassungView() {
		super();
		//
		setName("Tschau Sepp");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(Toolkit.getDefaultToolkit().getScreenSize());
		//
		init();
		//
		setVisible(true);
		setResizable(false);
	}

	/**
	 * 
	 */
	private void init() {

		// titel
		title = new JLabel("Spielernamen eingeben");
		title.setFont(title.getFont().deriveFont(30.0f));
		title.setForeground(Color.black);

		// title panel
		titlePanel = new JPanel(new BorderLayout(570, 20));
		titlePanel.add(title, BorderLayout.CENTER);
		titlePanel.add(new JLabel(), BorderLayout.NORTH);
		titlePanel.add(new JLabel(), BorderLayout.WEST);
		titlePanel.add(new JLabel(), BorderLayout.EAST);
		titlePanel.add(new JLabel(), BorderLayout.SOUTH);
		titlePanel.setBackground(Color.red.darker());

		// labels for names
		nameLabel1 = new JLabel("Name Spieler 1");
		nameLabel1.setForeground(Color.black);
		nameLabel1.setFont(nameLabel1.getFont().deriveFont(20.0f));
		nameLabel2 = new JLabel("Name Spieler 2");
		nameLabel2.setForeground(nameLabel1.getForeground());
		nameLabel2.setFont(nameLabel1.getFont());
		nameLabel3 = new JLabel("Name Spieler 3");
		nameLabel3.setForeground(nameLabel1.getForeground());
		nameLabel3.setFont(nameLabel1.getFont());
		nameLabel4 = new JLabel("Name Spieler 4");
		nameLabel4.setForeground(nameLabel1.getForeground());
		nameLabel4.setFont(nameLabel1.getFont());

		// text fields for name input
		nameText1 = new JTextField(1);
		nameText1.setFont(nameText1.getFont().deriveFont(15.0f));
		nameText1.setBorder(BorderFactory.createStrokeBorder(new BasicStroke(2.0f), Color.black));
		// nameText1.setMargin(new Insets(0, 30, 0, 30));
		nameText2 = new JTextField(1);
		nameText2.setFont(nameText1.getFont());
		nameText2.setBorder(nameText1.getBorder());
		nameText3 = new JTextField(1);
		nameText3.setFont(nameText1.getFont());
		nameText3.setBorder(nameText1.getBorder());
		nameText4 = new JTextField(1);
		nameText4.setFont(nameText1.getFont());
		nameText4.setBorder(nameText1.getBorder());

		// panel
		panel = new JPanel(new GridLayout(8, 1, 10, 10));
		panel.add(nameLabel1);
		panel.add(nameText1);
		panel.add(nameLabel2);
		panel.add(nameText2);
		panel.add(nameLabel3);
		panel.add(nameText3);
		panel.add(nameLabel4);
		panel.add(nameText4);
		panel.setBackground(titlePanel.getBackground());

		// bodyPanel
		bodyPanel = new JPanel(new BorderLayout(500, 30));
		bodyPanel.add(panel, BorderLayout.CENTER);
		bodyPanel.add(new JLabel(), BorderLayout.NORTH);
		bodyPanel.add(new JLabel(), BorderLayout.WEST);
		bodyPanel.add(new JLabel(), BorderLayout.EAST);
		bodyPanel.add(new JLabel(), BorderLayout.SOUTH);
		bodyPanel.setBackground(panel.getBackground());

		// buttons
		start = new JButton("START");
		start.setBackground(Color.white);
		start.setForeground(Color.black);
		start.setFont(start.getFont().deriveFont(24.0f));
		start.setBorder(nameText1.getBorder());
		start.setEnabled(false);

		back = new JButton("zurück");
		back.setBackground(start.getBackground());
		back.setForeground(start.getForeground());
		back.setFont(start.getFont());
		back.setBorder(nameText1.getBorder());

		// buttonInnerPanel
		buttonInnerPanel = new JPanel(new GridLayout(1, 3, -10, 0));
		buttonInnerPanel.setBackground(panel.getBackground());
		buttonInnerPanel.add(back);
		buttonInnerPanel.add(new JLabel());
		buttonInnerPanel.add(start);

		// buttonPanel
		buttonPanel = new JPanel(new BorderLayout(500, 100));
		buttonPanel.setBackground(buttonInnerPanel.getBackground());
		buttonPanel.add(buttonInnerPanel, BorderLayout.CENTER);
		buttonPanel.add(new JLabel(), BorderLayout.NORTH);
		buttonPanel.add(new JLabel(), BorderLayout.WEST);
		buttonPanel.add(new JLabel(), BorderLayout.EAST);
		buttonPanel.add(new JLabel(), BorderLayout.SOUTH);

		// getContentPane().setLayout(new BorderLayout(500, 200));
		getContentPane().add(titlePanel, BorderLayout.NORTH);
		getContentPane().add(bodyPanel, BorderLayout.CENTER);
		getContentPane().add(new JLabel(), BorderLayout.WEST);
		getContentPane().add(new JLabel(), BorderLayout.EAST);
		getContentPane().add(buttonPanel, BorderLayout.SOUTH);
		getContentPane().setBackground(Color.red.darker());

		// ACTIONLISTENER
		back.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				openAnleitung(e);
			}
		});


		nameText1.addKeyListener(new Keylistener());
		nameText2.addKeyListener(new Keylistener());
		nameText3.addKeyListener(new Keylistener());
		nameText4.addKeyListener(new Keylistener());
		
		start.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				startNewGame(e);
			}
		});

	}
	
	private void startNewGame(ActionEvent e) {

		Player p1, p2, p3, p4;

		p1 = new Player(nameText1.getText());
		p2 = new Player(nameText3.getText());
		p3 = new Player(nameText4.getText());
		p4 = new Player(nameText2.getText());

		Game game = new Game(p1, p2, p3, p4);

		p1.setGame(game);
		p2.setGame(game);
		p3.setGame(game);
		p4.setGame(game);

		game.newGame();

		GameView g = new GameView(null, rootPaneCheckingEnabled, game, new ImageFinder());
		g.setVisible(true);
		
	}

	private void openAnleitung(ActionEvent e) {
		new AnleitungView();
		setVisible(false);
	}

	// KEYLISTENER
	class Keylistener extends KeyAdapter {

		@Override
		public void keyTyped(KeyEvent e) {

			Vector<JTextField> textfields = new Vector();
			textfields.add(nameText1);
			textfields.add(nameText2);
			textfields.add(nameText3);
			textfields.add(nameText4);

			/*
			 * for (int i = 0; i < textfields.size(); i++) { if
			 * (!textfields.get(i).getText().isBlank() &&
			 * !textfields.get(i).getText().isBlank()) { start.setEnabled(true); } else {
			 * start.setEnabled(false); } }
			 */

			if (!nameText1.getText().isBlank() && !nameText1.getText().isBlank() && !nameText2.getText().isBlank()
					&& !nameText2.getText().isBlank() && !nameText3.getText().isBlank()
					&& !nameText3.getText().isBlank() && !nameText4.getText().isBlank()
					&& !nameText4.getText().isBlank()) {

				for (int i = 0; i < textfields.size(); i++) {
					for (int j = 0; j < textfields.size(); j++) {
						if (textfields.get(i).getText().equalsIgnoreCase(textfields.get(j).getText())) {
							start.setEnabled(false);
							textfields.get(i).setToolTipText("Spielername existiert bereits.");
						} else {
							start.setEnabled(true);
						}
					}
				}

				start.setEnabled(true);
			} else {
				start.setEnabled(false);
			}

		}
	}
	
	public static void main(String[] args) {
		new NamenerfassungView();
	}
}

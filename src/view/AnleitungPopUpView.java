/**
 * 
 */
package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

/**
 * @author Mia Gudelj
 * @since 02.07.2020
 * @version 1.0
 *
 */
public class AnleitungPopUpView extends JDialog {

	private JLabel title;
	private JTextArea anleitungText;
	private JScrollPane scrollPane;
	private JPanel titlePanel, panel, buttonPanel;
	private JButton backButton;

	/**
	 * 
	 */
	public AnleitungPopUpView(Frame parent, boolean modal) {
		super(parent, modal);
		setName("Tschau Sepp");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(Toolkit.getDefaultToolkit().getScreenSize());
		//
		init();
		//
		setVisible(true);
		setResizable(false);
	}

	private void init() {

		// titel
		title = new JLabel("Anleitung \"Tschau Sepp\"");
		title.setFont(title.getFont().deriveFont(30.0f));
		title.setForeground(Color.black);

		titlePanel = new JPanel(new BorderLayout(570, 30));
		titlePanel.add(title, BorderLayout.CENTER);
		titlePanel.add(new JLabel(), BorderLayout.WEST);
		titlePanel.add(new JLabel(), BorderLayout.EAST);
		titlePanel.add(new JLabel(), BorderLayout.NORTH);
		titlePanel.add(new JLabel(), BorderLayout.SOUTH);
		titlePanel.setBackground(Color.red.darker());

		// anleitung
		anleitungText = new JTextArea();
		anleitungText.setForeground(Color.black);
		anleitungText.setFont(anleitungText.getFont().deriveFont(20.0f));
		// set text
		anleitungText.setText("Ziel des Spiels");
		anleitungText.append(
				"\nDas Ziel beim «Tschau Sepp» ist es, als erster Spieler 200 Punkte (kann vor dem Spiel festgelegt werden) zu erzielen. Pro Runde erhält derjenige Spieler Punkte, welcher als Erster alle seine Karten auf der Hand ablegen konnte. Punkte gibt es für alle Karten, die die übrigen Mitspieler noch auf der Hand halten (siehe Kapitel Punkte).");

		anleitungText.append("\n\nSpielvorbereitung");
		anleitungText.append(
				"\nDas Kartenset besteht aus zwei Jokersets (siehe Kapitel Kartenset). Die Karten werden gemischt und jeder Spieler erhält 7 Karten, die er auf seine Hand nimmt. Die verbleibenden Karten werden verdeckt in die Mitte gelegt und bilden den Kartenstapel. Vom Kartenstapel wird die oberste Karte aufgedeckt und neben den Kartenstapel platziert. Dieser neue Stapel bildet den Ablagestapel. Ein Spieler, der beginnt, wird ausgelost respektive zufällig bestimmt.");

		anleitungText.append("\n\nSpielverlauf");
		anleitungText.append(
				"\nDer erste Spieler legt eine Karte von seiner Hand auf den Ablagestapel. Dabei gilt: Eine Karte kann nur auf eine Karte des gleichen Symbols, der gleichen Zahl oder der gleichen Figur gelegt werden. Manche Karten sind spezielle Aktionskarten mit besonderen Regeln (siehe Kapitel Kartenset). Kann oder will ein Spieler keine passende Karte legen, so muss er eine Strafkarte vom verdeckten Stapel ziehen. Diese oder eine andere Karte kann er sofort ausspielen, sofern er eine passende hat. Hat er keine passende Karte ist der nächste Spieler an der Reihe. Wer die vorletzte Karte ablegt, muss „Tschau!“ rufen und signalisiert damit, dass er nur noch eine Karte auf der Hand hat. Vergisst ein Spieler diese Mitteilung, bevor der nächste Spieler am Zug ist, muss er 2 Strafkarten ziehen. Wer die letzte Karte ablegt, muss schliesslich „Sepp!“ rufen, wodurch der Spieler die Runde gewinnt und diese beendet wird. Vergisst ein Spieler diese Mitteilung, bevor der nächste Spieler am Zug ist, muss er 4 Strafkarten ziehen und die Runde geht weiter. Am Ende der Runde werden die Punkte der restlichen Handkarte zusammengezählt und dem Spieler gutgeschrieben, der die Runde gewonnen hat. Besitzt der Spieler das definierte Punktelimit, so hat er das gesamte Spiel gewonnen. Falls nicht, beginnt eine neue Runde. .");

		anleitungText.append("\n\nKartenset");
		anleitungText.append(
				"\nDas Kartenset von «Tschau Sepp» besteht aus Jokerkarten (ohne Joker) aus zwei Kartensets (insgesamt 104 Karten). Die Eckpunkte des Kartensets sind wie folgt:");
		anleitungText.append("\n\t• Zwei Farben: Rot, Schwarz");
		anleitungText.append("\n\t• Vier Symbole: Herz, Ecke, Kreuz, Schaufel");
		anleitungText.append("\n\t• Neun Zahlen: 2 bis 10 (inklusive)");
		anleitungText.append("\n\t• Vier Bilder: Bauer, Dame, König, Ass");

		anleitungText.append("\n\nStrafen");
		anleitungText.append(
				"\nWenn ein Spieler sich nicht an die Regeln hält, so muss er eine oder mehrere Strafkarten ziehen. Die Regelungen sind wie folgt:");
		anleitungText.append("\n\t• Tschau: Vergisst ein Spieler nach dem Legen seiner vorletzten Karte «Tschau!» "
				+ "\n\t   zu rufen oder kündigt er es falsch an, muss er zwei Strafkarten ziehen.");
		anleitungText
				.append("\n\t• Sepp: Vergisst ein Spieler nach dem Legen seiner vorletzten Karte «Tschau!» zu rufen"
						+ "\n\t  oder kündigt er es falsch an, muss er vier Strafkarten ziehen.");
		anleitungText.append("\n\t• Falsch gelegt: Wer eine Karte falsch legt oder wenn er nicht dran ist, muss diese"
				+ "\n\t  wieder aufnehmen und eine Strafkarte ziehen.");

		anleitungText.append("\n\nPunkte ");
		anleitungText.append(
				"\nDer Spieler, der als Erster all seine Karten abgelegt hat, erhält folgende Punkte für die Karten, die seine Mitspieler noch in der Hand halten. ");
		anleitungText.append("\n\t• Ass: 11 Punkte ");
		anleitungText.append("\n\t• König: 4 Punkt");
		anleitungText.append("\n\t• Dame: 3 Punkte ");
		anleitungText.append("\n\t• Bauer: 20 Punkte ");
		anleitungText.append("\n\t• Zahlenkarte: entsprechend ihrer Zahl ");
		//
		anleitungText.setLineWrap(true);
		anleitungText.setWrapStyleWord(true);
		anleitungText.setBackground(titlePanel.getBackground());
		anleitungText.setEditable(false);
		anleitungText.setMargin(new Insets(30, 30, 30, 30));

		scrollPane = new JScrollPane(anleitungText);
		scrollPane.setBackground(anleitungText.getBackground());
		scrollPane.setBorder(BorderFactory.createStrokeBorder(new BasicStroke(2.0f), Color.red.darker().darker()));

		panel = new JPanel(new BorderLayout(250, 0));
		panel.add(scrollPane, BorderLayout.CENTER);
		panel.add(new JLabel(), BorderLayout.NORTH);
		panel.add(new JLabel(), BorderLayout.WEST);
		panel.add(new JLabel(), BorderLayout.EAST);
		panel.add(new JLabel(), BorderLayout.SOUTH);
		panel.setBackground(scrollPane.getBackground());

		// button
		backButton = new JButton("zurück");
		backButton.setBackground(Color.white);
		backButton.setFont(backButton.getFont().deriveFont(24.0f));
		backButton.setBorder(BorderFactory.createStrokeBorder(new BasicStroke(2.0f), Color.black));

		buttonPanel = new JPanel(new BorderLayout(700, 40));
		buttonPanel.add(backButton, BorderLayout.CENTER);
		buttonPanel.add(new JLabel(), BorderLayout.NORTH);
		buttonPanel.add(new JLabel(), BorderLayout.WEST);
		buttonPanel.add(new JLabel(), BorderLayout.EAST);
		buttonPanel.add(new JLabel(), BorderLayout.SOUTH);
		buttonPanel.setBackground(panel.getBackground());

		getContentPane().add(titlePanel, BorderLayout.NORTH);
		getContentPane().add(panel, BorderLayout.CENTER);
		getContentPane().add(new JLabel(), BorderLayout.WEST);
		getContentPane().add(new JLabel(), BorderLayout.EAST);
		getContentPane().add(buttonPanel, BorderLayout.SOUTH);
		getContentPane().setBackground(Color.red.darker());

		// ACTIONLISTENER
		backButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				getBackToMenu();
			}
		});
	}

	private void getBackToMenu() {
		dispose();
		this.setVisible(false);
	}
}

/**
 * 
 */
package view;

import java.awt.*;

import javax.swing.*;

/**
 * @author Mia Gudelj
 * @since 09.07.2020
 * @version 1.0
 *
 */
public class ErrorDialogView extends JDialog{

	private JLabel errorMessage, errorMessage2;
	private JPanel errorMessagePanel;
	
	public ErrorDialogView(Dialog parent, boolean modal) {
		super(parent, modal);
		setName("ERROR");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(500,200);

		//
		init();
		centreWindow(this);
		//
		setVisible(false);
		setResizable(false);
	}
	
	private void init() {
		errorMessage = new JLabel("Regelverstoss");
		errorMessage.setFont(errorMessage.getFont().deriveFont(30.0f));
		errorMessage.setForeground(Color.red.darker());
		errorMessage.setHorizontalAlignment(JLabel.CENTER);
		
		errorMessage2 = new JLabel("Karte kann nicht gelegt werden");
		errorMessage2.setFont(errorMessage2.getFont().deriveFont(25.0f));
		errorMessage2.setForeground(Color.white);
		errorMessage2.setHorizontalAlignment(JLabel.CENTER);
		
		errorMessagePanel = new JPanel(new GridLayout(2, 1));
		errorMessagePanel.add(errorMessage);
		errorMessagePanel.add(errorMessage2);
		errorMessagePanel.setBackground(Color.black);
		
		getContentPane().add(errorMessagePanel, BorderLayout.CENTER);
		
	}


	/**
	 * zentriert das Fenster
	 * 
	 * @param frame
	 */
	public void centreWindow(Window frame) {
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2.25);
		int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2.25);
		frame.setLocation(x, y);
	}

	/*
	public static void main(String[] args) {
		new ErrorDialogView();
	}*/

}

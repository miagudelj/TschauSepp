/**
 * 
 */
package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * @author Mia Gudelj
 * @since 29.06.2020
 * @version 1.0
 *
 */
public class StartseiteView extends JFrame {

	// variables
	private JButton anleitung, start;
	private JPanel homePanel, blackPanel, blackComponentPanel, blackButtonPanel, blackButtonInnerPanel, redPanel,
			redComponentPanel, redButtonPanel, redButtonInnerPanel;

	public StartseiteView() {
		super("Tschau Sepp");
		//
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(Toolkit.getDefaultToolkit().getScreenSize());
		//
		init();
		//
		setVisible(true);
		setResizable(false);
	}

	private void init() {

		// button anleitung
		anleitung = new JButton("Anleitung");
		anleitung.setFont(anleitung.getFont().deriveFont(24.0f));
		anleitung.setBackground(Color.white);
		anleitung.setForeground(Color.black);

		// button start
		start = new JButton("  Spielen  ");
		start.setFont(anleitung.getFont());
		start.setBackground(Color.white);
		start.setForeground(Color.black);

		// blackButtonInnerPanel
		blackButtonInnerPanel = new JPanel(new GridLayout(1, 3));
		blackButtonInnerPanel.add(new JLabel());
		blackButtonInnerPanel.add(new JLabel());
		blackButtonInnerPanel.add(anleitung);
		blackButtonInnerPanel.add(new JLabel(), BorderLayout.EAST);
		blackButtonInnerPanel.setBackground(Color.black);
		blackButtonInnerPanel.setFocusable(false);

		// redButtonInnerPanel
		redButtonInnerPanel = new JPanel(new GridLayout(1, 3));
		redButtonInnerPanel.add(new JLabel());
		redButtonInnerPanel.add(start);
		redButtonInnerPanel.add(new JLabel());
		redButtonInnerPanel.setBackground(Color.red.darker());
		redButtonInnerPanel.setFocusable(false);

		// blackButtonPanel
		blackButtonPanel = new JPanel(new BorderLayout());
		blackButtonPanel.add(blackButtonInnerPanel, BorderLayout.SOUTH);
		blackButtonPanel.add(new JLabel(), BorderLayout.NORTH);
		blackButtonPanel.add(new JLabel(), BorderLayout.WEST);
		blackButtonPanel.add(new JLabel(), BorderLayout.EAST);
		blackButtonPanel.setBackground(blackButtonInnerPanel.getBackground());
		blackButtonPanel.setFocusable(false);

		// redButtonPanel
		redButtonPanel = new JPanel(new BorderLayout());
		redButtonPanel.add(redButtonInnerPanel, BorderLayout.SOUTH);
		redButtonPanel.add(new JLabel(), BorderLayout.NORTH);
		redButtonPanel.add(new JLabel(), BorderLayout.WEST);
		redButtonPanel.add(new JLabel(), BorderLayout.EAST);
		redButtonPanel.setBackground(redButtonInnerPanel.getBackground());
		redButtonPanel.setFocusable(false);

		// blackComponentPanel
		blackComponentPanel = new JPanel(new GridLayout(2, 1));
		blackComponentPanel.add(new JLabel(new ImageIcon("./Pictures/Graphics/rotLogo.png")));
		blackComponentPanel.add(blackButtonPanel);
		blackComponentPanel.setBackground(blackButtonPanel.getBackground());
		blackComponentPanel.setFocusable(false);

		// redComponentPanel
		redComponentPanel = new JPanel(new GridLayout(2, 1));
		redComponentPanel.add(new JLabel(new ImageIcon("./Pictures/Graphics/schwarzLogo.png")));
		redComponentPanel.add(redButtonPanel);
		redComponentPanel.setBackground(redButtonPanel.getBackground());
		redComponentPanel.setFocusable(false);

		// blackPanel
		blackPanel = new JPanel(new BorderLayout(0, 140));
		blackPanel.add(blackComponentPanel, BorderLayout.EAST);
		blackPanel.add(new JLabel(), BorderLayout.NORTH);
		blackPanel.add(new JLabel(), BorderLayout.WEST);
		blackPanel.add(new JLabel(), BorderLayout.SOUTH);
		blackPanel.setBackground(blackComponentPanel.getBackground());
		blackPanel.setFocusable(false);

		// redPanel
		redPanel = new JPanel(new BorderLayout(0, 140));
		redPanel.add(redComponentPanel, BorderLayout.WEST);
		redPanel.add(new JLabel(), BorderLayout.NORTH);
		redPanel.add(new JLabel(), BorderLayout.EAST);
		redPanel.add(new JLabel(), BorderLayout.SOUTH);
		redPanel.setBackground(redComponentPanel.getBackground());
		redPanel.setFocusable(false);

		// homePanel
		homePanel = new JPanel(new GridLayout(1, 2));
		homePanel.add(blackPanel);
		homePanel.add(redPanel);

		homePanel.setToolTipText("");
		homePanel.setFocusable(false);

		getContentPane().add(homePanel);
		
		// ACTIONLISTENER
		anleitung.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				openAnleitung();
			}
		});
		
		start.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new NamenerfassungView();
				StartseiteView.super.setVisible(false);
			}
		});
	}
	
	private void openAnleitung() {
		new AnleitungView();
		this.setVisible(false);
	}
}

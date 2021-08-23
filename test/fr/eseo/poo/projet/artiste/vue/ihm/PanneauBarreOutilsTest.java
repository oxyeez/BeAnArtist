package fr.eseo.poo.projet.artiste.vue.ihm;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class PanneauBarreOutilsTest {
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new PanneauBarreOutilsTest();
			}
		});
	}

	public PanneauBarreOutilsTest() {
		JFrame frame = new JFrame("OutilLigneTest");

		PanneauDessin panneauDessin = new PanneauDessin();
		PanneauBarreOutils panneauOutils = new PanneauBarreOutils(panneauDessin);

		frame.setLayout(new BorderLayout());
		frame.add(panneauDessin, BorderLayout.WEST);
		frame.add(panneauOutils, BorderLayout.EAST);
		
		frame.setSize(panneauDessin.getPreferredSize());
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
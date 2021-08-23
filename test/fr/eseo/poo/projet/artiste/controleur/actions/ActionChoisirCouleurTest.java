package fr.eseo.poo.projet.artiste.controleur.actions;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import fr.eseo.poo.projet.artiste.vue.ihm.PanneauBarreOutils;
import fr.eseo.poo.projet.artiste.vue.ihm.PanneauDessin;

public class ActionChoisirCouleurTest {
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new ActionChoisirCouleurTest();
			}
		});
	}

	public ActionChoisirCouleurTest() {
		JFrame frame = new JFrame("OutilLigneTest");

		PanneauDessin panneauDessin = new PanneauDessin();
		PanneauBarreOutils panneauOutils = new PanneauBarreOutils(panneauDessin);

		frame.setLayout(new BorderLayout());
		frame.add(panneauDessin);
		frame.add(panneauOutils, BorderLayout.EAST);
		
		frame.setSize(panneauDessin.getPreferredSize());
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
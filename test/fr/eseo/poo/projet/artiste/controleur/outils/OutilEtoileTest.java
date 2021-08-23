package fr.eseo.poo.projet.artiste.controleur.outils;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import fr.eseo.poo.projet.artiste.controleur.outils.formes.OutilEtoile;
import fr.eseo.poo.projet.artiste.vue.ihm.PanneauBarreOutils;
import fr.eseo.poo.projet.artiste.vue.ihm.PanneauDessin;

public class OutilEtoileTest {
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new OutilEtoileTest();
			}
		});
	}

	public OutilEtoileTest() {
		JFrame frame = new JFrame("OutilEtoileTest");

		PanneauDessin panneau = new PanneauDessin();
		PanneauBarreOutils panneauOutils = new PanneauBarreOutils(panneau);

		frame.add(panneau);

		frame.setSize(panneau.getPreferredSize());
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		OutilEtoile outilEtoile = new OutilEtoile(panneauOutils);

		outilEtoile.setPanneauDessin(panneau);
		panneau.associerOutil(outilEtoile);
	}
}
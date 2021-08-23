package fr.eseo.poo.projet.artiste.controleur.outils;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import fr.eseo.poo.projet.artiste.controleur.outils.formes.OutilLigne;
import fr.eseo.poo.projet.artiste.vue.ihm.PanneauBarreOutils;
import fr.eseo.poo.projet.artiste.vue.ihm.PanneauDessin;

public class OutilLigneTest {
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new OutilLigneTest();
			}
		});
	}

	public OutilLigneTest() {
		JFrame frame = new JFrame("OutilLigneTest");

		PanneauDessin panneau = new PanneauDessin();
		PanneauBarreOutils panneauOutils = new PanneauBarreOutils(panneau);

		frame.add(panneau);

		frame.setSize(panneau.getSize());
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		OutilLigne outilLigne = new OutilLigne(panneauOutils);

		panneau.associerOutil(outilLigne);
	}
}

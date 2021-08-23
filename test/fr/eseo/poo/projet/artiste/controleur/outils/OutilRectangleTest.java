package fr.eseo.poo.projet.artiste.controleur.outils;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import fr.eseo.poo.projet.artiste.controleur.outils.formes.OutilRectangle;
import fr.eseo.poo.projet.artiste.vue.ihm.PanneauBarreOutils;
import fr.eseo.poo.projet.artiste.vue.ihm.PanneauDessin;

public class OutilRectangleTest {
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new OutilRectangleTest();
			}
		});
	}

	public OutilRectangleTest() {
		JFrame frame = new JFrame("OutilRectangleTest");

		PanneauDessin panneau = new PanneauDessin();
		PanneauBarreOutils panneauOutils = new PanneauBarreOutils(panneau);

		frame.add(panneau);

		frame.setSize(panneau.getSize());
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		OutilRectangle outilRectangle = new OutilRectangle(panneauOutils);

		outilRectangle.setPanneauDessin(panneau);
		panneau.associerOutil(outilRectangle);
	}
}

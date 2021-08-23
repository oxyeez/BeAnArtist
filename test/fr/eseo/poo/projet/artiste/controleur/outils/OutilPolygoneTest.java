package fr.eseo.poo.projet.artiste.controleur.outils;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import fr.eseo.poo.projet.artiste.controleur.outils.formes.OutilPolygone;
import fr.eseo.poo.projet.artiste.vue.ihm.PanneauBarreOutils;
import fr.eseo.poo.projet.artiste.vue.ihm.PanneauDessin;

public class OutilPolygoneTest {
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new OutilPolygoneTest();
			}
		});
	}

	public OutilPolygoneTest() {
		JFrame frame = new JFrame("OutilPolygoneTest");

		PanneauDessin panneau = new PanneauDessin();
		PanneauBarreOutils panneauOutils = new PanneauBarreOutils(panneau);

		frame.add(panneau);

		frame.setSize(panneau.getPreferredSize());
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		OutilPolygone outilPolygone = new OutilPolygone(panneauOutils);

		outilPolygone.setPanneauDessin(panneau);
		panneau.associerOutil(outilPolygone);
	}
}
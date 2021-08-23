package fr.eseo.poo.projet.artiste;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import fr.eseo.poo.projet.artiste.vue.ihm.PanneauBarreOutils;
import fr.eseo.poo.projet.artiste.vue.ihm.PanneauDessin;
import fr.eseo.poo.projet.artiste.vue.ihm.TailleFenetre;

public class EtreUnArtiste {
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				windowCreation();
			}
		});
	}
	
	public static void windowCreation() {
		JFrame frame = new JFrame("Etre Un Artiste");
		PanneauDessin panneauDessin = new PanneauDessin();
		PanneauBarreOutils panneauBarreOutils = new PanneauBarreOutils(panneauDessin);
		TailleFenetre tailleFenetre = new TailleFenetre(panneauDessin, panneauBarreOutils);

		frame.setLayout(null);
		frame.setMinimumSize(new Dimension((int)(3*panneauBarreOutils.getSize().getWidth()),
											(int)(panneauBarreOutils.getSize().getHeight()+30)));
		frame.setSize(new Dimension((int)(panneauDessin.getSize().getWidth()+panneauBarreOutils.getSize().getWidth()),
											(int)(panneauDessin.getSize().getHeight())));
		frame.add(panneauDessin);
		frame.addComponentListener(tailleFenetre);
		frame.add(panneauBarreOutils);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

		panneauDessin.setLocation(0, 0);

		panneauBarreOutils.setLocation((int)panneauDessin.getSize().getWidth(), 0);
		

	}
}
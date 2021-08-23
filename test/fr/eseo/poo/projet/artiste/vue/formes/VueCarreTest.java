package fr.eseo.poo.projet.artiste.vue.formes;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import org.junit.Test;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;
import fr.eseo.poo.projet.artiste.modele.formes.Carre;
import fr.eseo.poo.projet.artiste.vue.ihm.PanneauDessin;

public class VueCarreTest {
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new VueCarreTest();
			}
		});
	}

	public VueCarreTest() {
		JFrame frame = new JFrame("VueCarreTest");
		PanneauDessin panneau = new PanneauDessin(500, 300, Color.WHITE);

		frame.add(panneau);
		frame.setSize(panneau.getPreferredSize());
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		panneau.ajouterVueForme(testCarre1());
		panneau.ajouterVueForme(testCarre2());
		panneau.ajouterVueForme(testCarre3());
		panneau.ajouterVueForme(testCarre4());
	}

	@Test
	private VueCarre testCarre1() {
		Carre carre = new Carre();
		carre.setCouleur(Color.PINK);
		VueCarre vueCarre = new VueCarre(carre);
		return vueCarre;
	}

	@Test
	private VueCarre testCarre2() {
		Carre carre = new Carre(new Coordonnees(5, 80));
		carre.setCouleur(Color.RED);
		VueCarre vueCarre = new VueCarre(carre);
		return vueCarre;
	}

	@Test
	private VueCarre testCarre3() {
		Carre carre = new Carre(50);
		carre.setCouleur(Color.CYAN);
		VueCarre vueCarre = new VueCarre(carre);
		return vueCarre;
	}

	@Test
	private VueCarre testCarre4() {
		Carre carre = new Carre(new Coordonnees(80, 4), 155);
		VueCarre vueCarre = new VueCarre(carre);
		return vueCarre;
	}
}
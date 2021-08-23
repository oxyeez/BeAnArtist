package fr.eseo.poo.projet.artiste.vue.formes;

import org.junit.Test;

import fr.eseo.poo.projet.artiste.vue.ihm.PanneauDessin;
import fr.eseo.poo.projet.artiste.modele.formes.Cercle;
import fr.eseo.poo.projet.artiste.modele.Coordonnees;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class VueCercleTest {
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new VueCercleTest();
			}
		});
	}

	public VueCercleTest() {
		JFrame frame = new JFrame("VueCercleTest");
		PanneauDessin panneau = new PanneauDessin(500, 300, Color.WHITE);

		frame.add(panneau);
		frame.setSize(panneau.getPreferredSize());
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		panneau.ajouterVueForme(testCercle1());
		panneau.ajouterVueForme(testCercle2());
		panneau.ajouterVueForme(testCercle3());
		panneau.ajouterVueForme(testCercle4());
	}

	@Test
	private VueCercle testCercle1() {
		Cercle cercle = new Cercle();
		cercle.setCouleur(Color.PINK);
		VueCercle vueCercle = new VueCercle(cercle);
		return vueCercle;
	}

	@Test
	private VueCercle testCercle2() {
		Cercle cercle = new Cercle(new Coordonnees(5, 80));
		cercle.setCouleur(Color.RED);
		VueCercle vueCercle = new VueCercle(cercle);
		return vueCercle;
	}

	@Test
	private VueCercle testCercle3() {
		Cercle cercle = new Cercle(50);
		cercle.setCouleur(Color.CYAN);
		VueCercle vueCercle = new VueCercle(cercle);
		return vueCercle;
	}

	@Test
	private VueCercle testCercle4() {
		Cercle cercle = new Cercle(new Coordonnees(80, 4), 155);
		VueCercle vueCercle = new VueCercle(cercle);
		return vueCercle;
	}
}

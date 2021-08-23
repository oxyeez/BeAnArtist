package fr.eseo.poo.projet.artiste.vue.formes;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import org.junit.Test;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;
import fr.eseo.poo.projet.artiste.modele.formes.Polygone;
import fr.eseo.poo.projet.artiste.vue.ihm.PanneauDessin;

public class VuePolygoneTest {
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new VuePolygoneTest(); 
			}
		});
	}
	
	public VuePolygoneTest() {
		JFrame frame = new JFrame("VuePolygoneTest");
		PanneauDessin panneau = new PanneauDessin(500, 300, Color.WHITE);
		
		frame.add(panneau);
		frame.setSize(panneau.getPreferredSize());
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panneau.ajouterVueForme(testPolygone1());
		panneau.ajouterVueForme(testPolygone2());
		panneau.ajouterVueForme(testPolygone3());
		panneau.ajouterVueForme(testPolygone4());
		panneau.ajouterVueForme(testPolygone5());
	}
	
	@Test
	private VuePolygone testPolygone1() {
		Polygone polygone = new Polygone(12);
		polygone.setCouleur(Color.PINK);
		VuePolygone vuePolygone = new VuePolygone(polygone);
		return vuePolygone;
	}
	
	@Test
	private VuePolygone testPolygone2() {
		Polygone polygone = new Polygone(new Coordonnees(50, 90), 10);
		polygone.setCouleur(Color.RED);
		VuePolygone vuePolygone = new VuePolygone(polygone);
		return vuePolygone;
	}
	
	@Test
	private VuePolygone testPolygone3() {
		Polygone polygone = new Polygone(90, 7);
		polygone.setCouleur(Color.CYAN);
		VuePolygone vuePolygone = new VuePolygone(polygone);
		return vuePolygone;
	}
	
	@Test
	private VuePolygone testPolygone4() {
		Polygone polygone = new Polygone(new Coordonnees(12, 72), 69, 8);
		VuePolygone vuePolygone = new VuePolygone(polygone);
		return vuePolygone;
	}
	
	@Test
	private VuePolygone testPolygone5() {
		Polygone polygone = new Polygone(new Coordonnees(200, 200), 100, 6, 0.6);
		VuePolygone vuePolygone = new VuePolygone(polygone);
		return vuePolygone;
	}
}
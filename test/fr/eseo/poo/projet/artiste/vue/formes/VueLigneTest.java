package fr.eseo.poo.projet.artiste.vue.formes;

import org.junit.Test;
import javax.swing.SwingUtilities;
import javax.swing.JFrame;
import java.awt.Color;
import fr.eseo.poo.projet.artiste.vue.ihm.PanneauDessin;
import fr.eseo.poo.projet.artiste.modele.formes.Ligne;
import fr.eseo.poo.projet.artiste.modele.Coordonnees;

public class VueLigneTest {
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new VueLigneTest(); 
			}
		});
	}
	
	public VueLigneTest() {
		JFrame frame = new JFrame("VueLigneTest");
		PanneauDessin panneau = new PanneauDessin(500, 300, Color.WHITE);
		
		frame.add(panneau);
		frame.setSize(panneau.getPreferredSize());
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panneau.ajouterVueForme(testLigne1());
		panneau.ajouterVueForme(testLigne2());
		panneau.ajouterVueForme(testLigne3());
		panneau.ajouterVueForme(testLigne4());
	}
	
	@Test
	private VueLigne testLigne1() {
		Ligne ligne = new Ligne();
		ligne.setCouleur(Color.PINK);
		VueLigne vueLigne = new VueLigne(ligne);
		return vueLigne;
	}
	
	@Test
	private VueLigne testLigne2() {
		Ligne ligne = new Ligne(new Coordonnees(50, 90));
		ligne.setCouleur(Color.RED);
		VueLigne vueLigne = new VueLigne(ligne);
		return vueLigne;
	}
	
	@Test
	private VueLigne testLigne3() {
		Ligne ligne = new Ligne(90, 55);
		ligne.setCouleur(Color.CYAN);
		VueLigne vueLigne = new VueLigne(ligne);
		return vueLigne;
	}
	
	@Test
	private VueLigne testLigne4() {
		Ligne ligne = new Ligne(new Coordonnees(12, 72), -8, 69);
		VueLigne vueLigne = new VueLigne(ligne);
		return vueLigne;
	}
	
}
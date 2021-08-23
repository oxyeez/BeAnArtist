package fr.eseo.poo.projet.artiste.vue.formes;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import org.junit.Test;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;
import fr.eseo.poo.projet.artiste.modele.formes.Etoile;
import fr.eseo.poo.projet.artiste.vue.ihm.PanneauDessin;

public class VueEtoileTest {
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new VueEtoileTest(); 
			}
		});
	}
	
	public VueEtoileTest() {
		JFrame frame = new JFrame("VueEtoileTest");
		PanneauDessin panneau = new PanneauDessin(500, 300, Color.WHITE);
		
		frame.add(panneau);
		frame.setSize(panneau.getPreferredSize());
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panneau.ajouterVueForme(testEtoile1());
		panneau.ajouterVueForme(testEtoile2());
		panneau.ajouterVueForme(testEtoile3());
		panneau.ajouterVueForme(testEtoile4());
		panneau.ajouterVueForme(testEtoile5());
	}
	
	@Test
	private VueEtoile testEtoile1() {
		Etoile etoile = new Etoile();
		etoile.setCouleur(Color.PINK);
		VueEtoile vueEtoile = new VueEtoile(etoile);
		return vueEtoile;
	}
	
	@Test
	private VueEtoile testEtoile2() {
		Etoile etoile = new Etoile(new Coordonnees(50, 90));
		etoile.setCouleur(Color.RED);
		VueEtoile vueEtoile = new VueEtoile(etoile);
		return vueEtoile;
	}
	
	@Test
	private VueEtoile testEtoile3() {
		Etoile etoile = new Etoile(90);
		etoile.setCouleur(Color.CYAN);
		VueEtoile vueEtoile = new VueEtoile(etoile);
		return vueEtoile;
	}
	
	@Test
	private VueEtoile testEtoile4() {
		Etoile etoile = new Etoile(new Coordonnees(12, 72), 69);
		VueEtoile vueEtoile = new VueEtoile(etoile);
		return vueEtoile;
	}
	
	@Test
	private VueEtoile testEtoile5() {
		Etoile etoile = new Etoile(new Coordonnees(200, 200), 100, 6, 0.6, 0.6);
		VueEtoile vueEtoile = new VueEtoile(etoile);
		return vueEtoile;
	}
}
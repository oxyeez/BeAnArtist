package fr.eseo.poo.projet.artiste.vue.formes;

import org.junit.Test;

import fr.eseo.poo.projet.artiste.vue.ihm.PanneauDessin;
import fr.eseo.poo.projet.artiste.modele.formes.Ellipse;
import fr.eseo.poo.projet.artiste.modele.Coordonnees;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class VueEllipseTest {
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new VueEllipseTest(); 
			}
		});
	}
	
	public VueEllipseTest() {
		JFrame frame = new JFrame("VueEllipseTest");
		PanneauDessin panneau = new PanneauDessin(500, 300, Color.WHITE);
		
		frame.add(panneau);
		frame.setSize(panneau.getPreferredSize());
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panneau.ajouterVueForme(testEllipse1());
		panneau.ajouterVueForme(testEllipse2());
		panneau.ajouterVueForme(testEllipse3());
		panneau.ajouterVueForme(testEllipse4());
	}
	
	@Test
	private VueEllipse testEllipse1() {
		Ellipse ellipse = new Ellipse();
		ellipse.setCouleur(Color.PINK);
		VueEllipse vueEllipse = new VueEllipse(ellipse);
		return vueEllipse;
	}
	
	@Test
	private VueEllipse testEllipse2() {
		Ellipse ellipse = new Ellipse(new Coordonnees(5,80));
		ellipse.setCouleur(Color.RED);
		VueEllipse vueEllipse = new VueEllipse(ellipse);
		return vueEllipse;
	}
	
	@Test
	private VueEllipse testEllipse3() {
		Ellipse ellipse = new Ellipse(50, 94);
		ellipse.setCouleur(Color.CYAN);
		VueEllipse vueEllipse = new VueEllipse(ellipse);
		return vueEllipse;
	}
	
	@Test
	private VueEllipse testEllipse4() {
		Ellipse ellipse = new Ellipse(new Coordonnees(80,4), 94, 155);
		VueEllipse vueEllipse = new VueEllipse(ellipse);
		return vueEllipse;
	}

}

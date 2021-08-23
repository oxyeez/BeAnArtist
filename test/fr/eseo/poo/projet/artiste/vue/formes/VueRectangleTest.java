package fr.eseo.poo.projet.artiste.vue.formes;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import org.junit.Test;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;
import fr.eseo.poo.projet.artiste.modele.formes.Rectangle;
import fr.eseo.poo.projet.artiste.vue.ihm.PanneauDessin;

public class VueRectangleTest {
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new VueRectangleTest(); 
			}
		});
	}
	
	public VueRectangleTest() {
		JFrame frame = new JFrame("VueRectangleTest");
		PanneauDessin panneau = new PanneauDessin(500, 300, Color.WHITE);
		
		frame.add(panneau);
		frame.setSize(panneau.getPreferredSize());
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panneau.ajouterVueForme(testRectangle1());
		panneau.ajouterVueForme(testRectangle2());
		panneau.ajouterVueForme(testRectangle3());
		panneau.ajouterVueForme(testRectangle4());
	}
	
	@Test
	private VueRectangle testRectangle1() {
		Rectangle rectangle = new Rectangle();
		rectangle.setCouleur(Color.PINK);
		VueRectangle vueRectangle = new VueRectangle(rectangle);
		return vueRectangle;
	}
	
	@Test
	private VueRectangle testRectangle2() {
		Rectangle rectangle = new Rectangle(new Coordonnees(5,80));
		rectangle.setCouleur(Color.RED);
		VueRectangle vueRectangle = new VueRectangle(rectangle);
		return vueRectangle;
	}
	
	@Test
	private VueRectangle testRectangle3() {
		Rectangle rectangle = new Rectangle(50, 94);
		rectangle.setCouleur(Color.CYAN);
		VueRectangle vueRectangle = new VueRectangle(rectangle);
		return vueRectangle;
	}
	
	@Test
	private VueRectangle testRectangle4() {
		Rectangle rectangle = new Rectangle(new Coordonnees(80,4), 94, 155);
		VueRectangle vueRectangle = new VueRectangle(rectangle);
		return vueRectangle;
	}

}

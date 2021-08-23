package fr.eseo.poo.projet.artiste.vue.formes;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import org.junit.Test;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;
import fr.eseo.poo.projet.artiste.modele.formes.Triangle;
import fr.eseo.poo.projet.artiste.modele.formes.TriangleEquilateral;
import fr.eseo.poo.projet.artiste.modele.formes.TriangleIsocele;
import fr.eseo.poo.projet.artiste.vue.ihm.PanneauDessin;

public class VueTriangleTest {
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new VueTriangleTest(); 
			}
		});
	}
	
	public VueTriangleTest() {
		JFrame frame = new JFrame("VueTriangleTest");
		PanneauDessin panneau = new PanneauDessin(500, 300, Color.WHITE);
		
		frame.add(panneau);
		frame.setSize(panneau.getPreferredSize());
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panneau.ajouterVueForme(testTriangle1());
		panneau.ajouterVueForme(testTriangle2());
		panneau.ajouterVueForme(testTriangle3());
		panneau.ajouterVueForme(testTriangle4());
		panneau.ajouterVueForme(testTriangleIsocele1());
		panneau.ajouterVueForme(testTriangleIsocele2());
		panneau.ajouterVueForme(testTriangleIsocele3());
		panneau.ajouterVueForme(testTriangleIsocele4());
		panneau.ajouterVueForme(testTriangleEquilateral1());
		panneau.ajouterVueForme(testTriangleEquilateral2());
		panneau.ajouterVueForme(testTriangleEquilateral3());
	}
	
	@Test
	private VueTriangle testTriangle1() {
		Triangle triangle = new Triangle();
		triangle.setCouleur(Color.PINK);
		VueTriangle vueTriangle = new VueTriangle(triangle);
		return vueTriangle;
	}
	
	@Test
	private VueTriangle testTriangle2() {
		Triangle triangle = new Triangle(new Coordonnees(100, 180));
		triangle.setCouleur(Color.RED);
		VueTriangle vueTriangle = new VueTriangle(triangle);
		return vueTriangle;
	}
	
	@Test
	private VueTriangle testTriangle3() {
		Triangle triangle = new Triangle(new Coordonnees(120, 220), new Coordonnees(200, 60));
		triangle.setCouleur(Color.CYAN);
		VueTriangle vueTriangle = new VueTriangle(triangle);
		return vueTriangle;
	}
	
	@Test
	private VueTriangle testTriangle4() {
		Triangle triangle = new Triangle(new Coordonnees(50, 90), new Coordonnees(300,190), new Coordonnees(160, 200));
		VueTriangle vueTriangle = new VueTriangle(triangle);
		return vueTriangle;
	}
	
	@Test
	private VueTriangle testTriangleIsocele1() {
		TriangleIsocele triangle = new TriangleIsocele();
		triangle.setCouleur(Color.PINK);
		VueTriangle vueTriangle = new VueTriangle(triangle);
		return vueTriangle;
	}
	
	@Test
	private VueTriangle testTriangleIsocele2() {
		TriangleIsocele triangle = new TriangleIsocele(new Coordonnees(100, 180));
		triangle.setCouleur(Color.RED);
		VueTriangle vueTriangle = new VueTriangle(triangle);
		return vueTriangle;
	}
	
	@Test
	private VueTriangle testTriangleIsocele3() {
		TriangleIsocele triangle = new TriangleIsocele(new Coordonnees(120, 220), new Coordonnees(200, 60));
		triangle.setCouleur(Color.CYAN);
		VueTriangle vueTriangle = new VueTriangle(triangle);
		return vueTriangle;
	}
	
	@Test
	private VueTriangle testTriangleIsocele4() {
		TriangleIsocele triangle = new TriangleIsocele(new Coordonnees(50, 90), new Coordonnees(300,190), new Coordonnees(160, 200));
		VueTriangle vueTriangle = new VueTriangle(triangle);
		return vueTriangle;
	}
	
	@Test
	private VueTriangle testTriangleEquilateral1() {
		TriangleEquilateral triangle = new TriangleEquilateral();
		triangle.setCouleur(Color.PINK);
		VueTriangle vueTriangle = new VueTriangle(triangle);
		return vueTriangle;
	}
	
	@Test
	private VueTriangle testTriangleEquilateral2() {
		TriangleEquilateral triangle = new TriangleEquilateral(new Coordonnees(100, 180));
		triangle.setCouleur(Color.RED);
		VueTriangle vueTriangle = new VueTriangle(triangle);
		return vueTriangle;
	}
	
	@Test
	private VueTriangle testTriangleEquilateral3() {
		TriangleEquilateral triangle = new TriangleEquilateral(new Coordonnees(120, 220), new Coordonnees(200, 60));
		triangle.setCouleur(Color.CYAN);
		VueTriangle vueTriangle = new VueTriangle(triangle);
		return vueTriangle;
	}
}
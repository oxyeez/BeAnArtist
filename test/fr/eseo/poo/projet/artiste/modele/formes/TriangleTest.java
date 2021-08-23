package fr.eseo.poo.projet.artiste.modele.formes;

import static org.junit.Assert.*;

import java.awt.Color;
import java.util.Locale;

import org.junit.Test;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;

public class TriangleTest {
	public static final double EPSILON = 1e-6;
	
	@Test
	public void testAireRandom() {
		Triangle triangle = new Triangle(new Coordonnees(0, 6), new Coordonnees(6, 0), new Coordonnees(8, 7));
		
		assertEquals(27, triangle.aire(), EPSILON);
	}
	
	@Test
	public void testAireBaseHorizontale() {
		Triangle triangle = new Triangle(new Coordonnees(0, 0), new Coordonnees(6, 0), new Coordonnees(8, 7));
		
		assertEquals(21, triangle.aire(), EPSILON);
	}
	
	@Test
	public void testAireBaseVerticale() {
		Triangle triangle = new Triangle(new Coordonnees(0, 6), new Coordonnees(0, 0), new Coordonnees(-1, 5));
		
		assertEquals(3, triangle.aire(), EPSILON);
	}

	@Test
	public void testPerimetre() {
		Triangle triangle = new Triangle(new Coordonnees(0, 6), new Coordonnees(6, 0), new Coordonnees(8, 7));
		
		assertEquals(23.827649011, triangle.perimetre(), EPSILON);
	}

	@Test
	public void testContient() {
		Triangle triangle = new Triangle(new Coordonnees(0, 6), new Coordonnees(6, 0), new Coordonnees(8, 7));
		
		assertTrue(triangle.contient(new Coordonnees(5, 4)));
	}
	
	@Test
	public void testContientPas() {
		Triangle triangle = new Triangle(new Coordonnees(0, 6), new Coordonnees(6, 0), new Coordonnees(8, 7));
		
		assertTrue(triangle.contient(new Coordonnees(3, 7)));
	}

	@Test
	public void testTriangle() {
		Triangle triangle = new Triangle();
		
		assertTrue(triangle.getBase1().estEgalA(new Coordonnees(50, 50)));
		assertTrue(triangle.getBase2().estEgalA(new Coordonnees(70, 30)));
		assertTrue(triangle.getSommet().estEgalA(new Coordonnees(80,60)));
		assertTrue(triangle.getPosition().estEgalA(new Coordonnees(50, 30)));
		assertEquals(30, triangle.getLargeur(), EPSILON);
		assertEquals(30, triangle.getHauteur(), EPSILON);
	}

	@Test
	public void testTriangleCoordonnees() {
		Triangle triangle = new Triangle(new Coordonnees(0, 6));
		
		assertTrue(triangle.getBase1().estEgalA(new Coordonnees(0, 6)));
		assertTrue(triangle.getBase2().estEgalA(new Coordonnees(100, 106)));
		assertTrue(triangle.getSommet().estEgalA(new Coordonnees(125, 31)));
		assertTrue(triangle.getPosition().estEgalA(new Coordonnees(0, 6)));
		assertEquals(125, triangle.getLargeur(), EPSILON);
		assertEquals(100, triangle.getHauteur(), EPSILON);
	}
	
	@Test
	public void testTriangleCoordonneesCoordonnees() {
		Triangle triangle = new Triangle(new Coordonnees(6, 0), new Coordonnees(0, 6));
		
		assertTrue(triangle.getBase1().estEgalA(new Coordonnees(6, 0)));
		assertTrue(triangle.getBase2().estEgalA(new Coordonnees(0, 6)));
		assertTrue(triangle.getSommet().estEgalA(new Coordonnees(4.5, 7.5)));
		assertTrue(triangle.getPosition().estEgalA(new Coordonnees(0, 0)));
		assertEquals(6, triangle.getLargeur(), EPSILON);
		assertEquals(7.5, triangle.getHauteur(), EPSILON);
	}
	
	@Test
	public void testTriangleCoordonneesCoordonneesCoordonnees() {
		Triangle triangle = new Triangle(new Coordonnees(0, 6), new Coordonnees(6, 0), new Coordonnees(8, 7));
		
		assertTrue(triangle.getBase1().estEgalA(new Coordonnees(0, 6)));
		assertTrue(triangle.getBase2().estEgalA(new Coordonnees(6, 0)));
		assertTrue(triangle.getSommet().estEgalA(new Coordonnees(8, 7)));
		assertTrue(triangle.getPosition().estEgalA(new Coordonnees(0, 0)));
		assertEquals(8, triangle.getLargeur(), EPSILON);
		assertEquals(7, triangle.getHauteur(), EPSILON);
	}

	@Test
	public void testToStringFrVide() {
		Triangle triangle = new Triangle(new Coordonnees(0, 6), new Coordonnees(6, 0), new Coordonnees(8, 7));
		
		Locale.setDefault(Locale.FRENCH);
		
		assertEquals("[Triangle] : base de (0,0 , 6,0) à (6,0 , 0,0) sommet (8,0 , 7,0) hauteur : 6,36 "
				+ "périmètre : 23,83 aire : 27,0/n couleur = R0,V0,B0 epaisseur = 1px", triangle.toString());
	}
	
	@Test
	public void testToStringFrRempli() {
		Triangle triangle = new Triangle(new Coordonnees(0, 6), new Coordonnees(6, 0), new Coordonnees(8, 7));
		triangle.setRempli(true);
		triangle.setCouleur(Color.RED);
		triangle.setCouleurRemplissage(Color.BLUE);
		
		Locale.setDefault(Locale.FRENCH);
		
		assertEquals("[Triangle-Rempli] : base de (0,0 , 6,0) à (6,0 , 0,0) sommet (8,0 , 7,0) hauteur : 6,36 "
				+ "périmètre : 23,83 aire : 27,0/n couleur = R255,V0,B0 epaisseur = 1px remplissage = R0,V0,B255", triangle.toString());
	}
	
	@Test
	public void testToStringEnVide() {
		Triangle triangle = new Triangle(new Coordonnees(0, 6), new Coordonnees(6, 0), new Coordonnees(8, 7));
		
		Locale.setDefault(Locale.ENGLISH);
		
		assertEquals("[Triangle] : base de (0.0 , 6.0) à (6.0 , 0.0) sommet (8.0 , 7.0) hauteur : 6.36 "
				+ "périmètre : 23.83 aire : 27.0/n couleur = R0,G0,B0 epaisseur = 1px", triangle.toString());
	}
	
	@Test
	public void testToStringEnRempli() {
		Triangle triangle = new Triangle(new Coordonnees(0, 6), new Coordonnees(6, 0), new Coordonnees(8, 7));
		triangle.setRempli(true);
		triangle.setCouleur(Color.RED);
		triangle.setCouleurRemplissage(Color.BLUE);
		
		Locale.setDefault(Locale.ENGLISH);
		
		assertEquals("[Triangle-Rempli] : base de (0.0 , 6.0) à (6.0 , 0.0) sommet (8.0 , 7.0) hauteur : 6.36 "
				+ "périmètre : 23.83 aire : 27.0/n couleur = R255,G0,B0 epaisseur = 1px remplissage = R0,G0,B255", triangle.toString());
	}

	@Test
	public void testGetHauteurTriangle() {
		Triangle triangle = new Triangle(new Coordonnees(0, 6), new Coordonnees(6, 0), new Coordonnees(8, 7));
		
		assertEquals(6.36396103067, triangle.getHauteurTriangle(), EPSILON);
	}
}

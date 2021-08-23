package fr.eseo.poo.projet.artiste.modele.formes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.awt.Color;
import java.util.Locale;

import org.junit.Test;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;

public class RectangleTest {
	public static final double EPSILON = 1e-6;
	
	@Test
	public void testSetLargeur() {
		Rectangle rectangle = new Rectangle(new Coordonnees(10, 10), 25, 15);
		rectangle.setLargeur(30);
		
		assertEquals(30, rectangle.getLargeur(), EPSILON);
		assertEquals(15, rectangle.getHauteur(), EPSILON);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testSetLargeurNeg() {
		Rectangle rectangle = new Rectangle(new Coordonnees(10, 10), 25, 15);
		rectangle.setLargeur(-30);
	}

	@Test
	public void testSetHauteur() {
		Rectangle rectangle = new Rectangle(new Coordonnees(10, 10), 25, 15);
		rectangle.setHauteur(30);
		
		assertEquals(25, rectangle.getLargeur(), EPSILON);
		assertEquals(30, rectangle.getHauteur(), EPSILON);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testSetHauteurNeg() {
		Rectangle rectangle = new Rectangle(new Coordonnees(10, 10), 25, 15);
		rectangle.setHauteur(-30);
	}

	@Test
	public void testAire() {
		Rectangle rectangle = new Rectangle(new Coordonnees(10, 10), 25, 15);
		
		assertEquals(25*15, rectangle.aire(), EPSILON);
	}

	@Test
	public void testPerimetre() {
		Rectangle rectangle = new Rectangle(new Coordonnees(10, 10), 25, 15);
		
		assertEquals(25+25+15+15 , rectangle.perimetre(), EPSILON);
	}

	@Test
	public void testRectangle() {
		Rectangle rectangle = new Rectangle();
		
		assertEquals(100, rectangle.getLargeur(), EPSILON);
		assertEquals(75, rectangle.getHauteur(), EPSILON);
		assertEquals(50, rectangle.getPosition().getAbscisse(), EPSILON);
		assertEquals(50, rectangle.getPosition().getOrdonnee(), EPSILON);
	}

	@Test
	public void testRectangleDoubleDouble() {
		Rectangle rectangle = new Rectangle(25, 15);
		
		assertEquals(25, rectangle.getLargeur(), EPSILON);
		assertEquals(15, rectangle.getHauteur(), EPSILON);
		assertEquals(50, rectangle.getPosition().getAbscisse(), EPSILON);
		assertEquals(50, rectangle.getPosition().getOrdonnee(), EPSILON);
	}

	@Test
	public void testRectangleCoordonnees() {
		Rectangle rectangle = new Rectangle(new Coordonnees(10, 10));
		
		assertEquals(100, rectangle.getLargeur(), EPSILON);
		assertEquals(75, rectangle.getHauteur(), EPSILON);
		assertEquals(10, rectangle.getPosition().getAbscisse(), EPSILON);
		assertEquals(10, rectangle.getPosition().getOrdonnee(), EPSILON);
	}

	@Test
	public void testRectangleCoordonneesDoubleDouble() {
		Rectangle rectangle = new Rectangle(new Coordonnees(10, 10), 25, 15);
		
		assertEquals(25, rectangle.getLargeur(), EPSILON);
		assertEquals(15, rectangle.getHauteur(), EPSILON);
		assertEquals(10, rectangle.getPosition().getAbscisse(), EPSILON);
		assertEquals(10, rectangle.getPosition().getOrdonnee(), EPSILON);
	}

	@Test
	public void testToStringFrVide() {
		Rectangle rectangle = new Rectangle(new Coordonnees(10, 10), 25, 15);
		
		Locale.setDefault(Locale.FRENCH);
		
		assertEquals("[Rectangle] : pos (10,0 , 10,0) dim 25,0 x 15,0 "
				+ "périmètre : 80,0 aire : 375,0/n couleur = R0,V0,B0 epaisseur = 1px", rectangle.toString());
	}
	
	@Test
	public void testToStringFrRempli() {
		Rectangle rectangle = new Rectangle(new Coordonnees(10, 10), 25, 15);
		rectangle.setRempli(true);
		rectangle.setCouleur(Color.RED);
		rectangle.setCouleurRemplissage(Color.BLUE);
		
		Locale.setDefault(Locale.FRENCH);
		
		assertEquals("[Rectangle-Rempli] : pos (10,0 , 10,0) dim 25,0 x 15,0 "
				+ "périmètre : 80,0 aire : 375,0/n couleur = R255,V0,B0 epaisseur = 1px remplissage = R0,V0,B255", rectangle.toString());
	}
	
	@Test
	public void testToStringEnVide() {
		Rectangle rectangle = new Rectangle(new Coordonnees(10, 10), 25, 15);
		
		Locale.setDefault(Locale.ENGLISH);
		
		assertEquals("[Rectangle] : pos (10.0 , 10.0) dim 25.0 x 15.0 "
				+ "périmètre : 80.0 aire : 375.0/n couleur = R0,G0,B0 epaisseur = 1px", rectangle.toString());
	}
	
	@Test
	public void testToStringEnRempli() {
		Rectangle rectangle = new Rectangle(new Coordonnees(10, 10), 25, 15);
		rectangle.setRempli(true);
		rectangle.setCouleur(Color.RED);
		rectangle.setCouleurRemplissage(Color.BLUE);
		
		Locale.setDefault(Locale.ENGLISH);
		
		assertEquals("[Rectangle-Rempli] : pos (10.0 , 10.0) dim 25.0 x 15.0 "
				+ "périmètre : 80.0 aire : 375.0/n couleur = R255,G0,B0 epaisseur = 1px remplissage = R0,G0,B255", rectangle.toString());
	}
	
	@Test
	public void testContient() {
		Rectangle rectangle = new Rectangle(new Coordonnees(10, 10), 25, 25);
		
		assertTrue(rectangle.contient(new Coordonnees(20, 20)));
	}
	
	@Test
	public void testContientPasTropHaut() {
		Rectangle rectangle = new Rectangle(new Coordonnees(10, 10), 30, 15);
		
		assertFalse(rectangle.contient(new Coordonnees(20, 5)));
	}
	
	@Test
	public void testContientPasTropBas() {
		Rectangle rectangle = new Rectangle(new Coordonnees(10, 10), 30, 15);
		
		assertFalse(rectangle.contient(new Coordonnees(20, 50)));
	}
	
	@Test
	public void testContientPasDroite() {
		Rectangle rectangle = new Rectangle(new Coordonnees(10, 10), 30, 15);
		
		assertFalse(rectangle.contient(new Coordonnees(60, 20)));
	}
	
	@Test
	public void testContientPasGauche() {
		Rectangle rectangle = new Rectangle(new Coordonnees(10, 10), 30, 15);
		
		assertFalse(rectangle.contient(new Coordonnees(0, 20)));
	}
}
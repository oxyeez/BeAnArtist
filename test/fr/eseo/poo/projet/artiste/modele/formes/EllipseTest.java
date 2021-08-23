package fr.eseo.poo.projet.artiste.modele.formes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.awt.Color;
import java.util.Locale;

import static org.junit.Assert.assertFalse;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;

import org.junit.Test;

public class EllipseTest {
	public static final double EPSILON = 1e-6;
	
	@Test
	public void testSetLargeur() {
		Ellipse ellipse = new Ellipse(new Coordonnees(10, 10), 25, 15);
		ellipse.setLargeur(30);
		
		assertEquals(30, ellipse.getLargeur(), EPSILON);
		assertEquals(15, ellipse.getHauteur(), EPSILON);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testSetLargeurNeg() {
		Ellipse ellipse = new Ellipse(new Coordonnees(10, 10), 25, 15);
		ellipse.setLargeur(-30);
	}

	@Test
	public void testSetHauteur() {
		Ellipse ellipse = new Ellipse(new Coordonnees(10, 10), 25, 15);
		ellipse.setHauteur(30);
		
		assertEquals(25, ellipse.getLargeur(), EPSILON);
		assertEquals(30, ellipse.getHauteur(), EPSILON);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testSetHauteurNeg() {
		Ellipse ellipse = new Ellipse(new Coordonnees(10, 10), 25, 15);
		ellipse.setHauteur(-30);
	}

	@Test
	public void testAire() {
		Ellipse ellipse = new Ellipse(new Coordonnees(10, 10), 25, 15);
		
		assertEquals(Math.PI*7.5*12.5, ellipse.aire(), EPSILON);
	}

	@Test
	public void testPerimetre() {
		Ellipse ellipse = new Ellipse(new Coordonnees(10, 10), 25, 15);
		
		assertEquals(63.8174971569719 , ellipse.perimetre(), EPSILON);
	}

	@Test
	public void testEllipse() {
		Ellipse ellipse = new Ellipse();
		
		assertEquals(100, ellipse.getLargeur(), EPSILON);
		assertEquals(75, ellipse.getHauteur(), EPSILON);
		assertEquals(50, ellipse.getPosition().getAbscisse(), EPSILON);
		assertEquals(50, ellipse.getPosition().getOrdonnee(), EPSILON);
	}

	@Test
	public void testEllipseDoubleDouble() {
		Ellipse ellipse = new Ellipse(25, 15);
		
		assertEquals(25, ellipse.getLargeur(), EPSILON);
		assertEquals(15, ellipse.getHauteur(), EPSILON);
		assertEquals(50, ellipse.getPosition().getAbscisse(), EPSILON);
		assertEquals(50, ellipse.getPosition().getOrdonnee(), EPSILON);
	}

	@Test
	public void testEllipseCoordonnees() {
		Ellipse ellipse = new Ellipse(new Coordonnees(10, 10));
		
		assertEquals(100, ellipse.getLargeur(), EPSILON);
		assertEquals(75, ellipse.getHauteur(), EPSILON);
		assertEquals(10, ellipse.getPosition().getAbscisse(), EPSILON);
		assertEquals(10, ellipse.getPosition().getOrdonnee(), EPSILON);
	}

	@Test
	public void testEllipseCoordonneesDoubleDouble() {
		Ellipse ellipse = new Ellipse(new Coordonnees(10, 10), 25, 15);
		
		assertEquals(25, ellipse.getLargeur(), EPSILON);
		assertEquals(15, ellipse.getHauteur(), EPSILON);
		assertEquals(10, ellipse.getPosition().getAbscisse(), EPSILON);
		assertEquals(10, ellipse.getPosition().getOrdonnee(), EPSILON);
	}

	@Test
	public void testToStringFrVide() {
		Ellipse ellipse = new Ellipse(new Coordonnees(10, 10), 25, 15);
		
		Locale.setDefault(Locale.FRENCH);
		
		assertEquals("[Ellipse] : pos (10,0 , 10,0) dim 25,0 x 15,0 "
				+ "périmètre : 63,82 aire : 294,52/n couleur = R0,V0,B0 epaisseur = 1px", ellipse.toString());
	}
	
	@Test
	public void testToStringFrRempli() {
		Ellipse ellipse = new Ellipse(new Coordonnees(10, 10), 25, 15);
		ellipse.setRempli(true);
		ellipse.setCouleur(Color.RED);
		ellipse.setCouleurRemplissage(Color.BLUE);
		
		Locale.setDefault(Locale.FRENCH);
		
		assertEquals("[Ellipse-Rempli] : pos (10,0 , 10,0) dim 25,0 x 15,0 "
				+ "périmètre : 63,82 aire : 294,52/n couleur = R255,V0,B0 epaisseur = 1px remplissage = R0,V0,B255", ellipse.toString());
	}
	
	@Test
	public void testToStringEnVide() {
		Ellipse ellipse = new Ellipse(new Coordonnees(10, 10), 25, 15);
		
		Locale.setDefault(Locale.ENGLISH);
		
		assertEquals("[Ellipse] : pos (10.0 , 10.0) dim 25.0 x 15.0 "
				+ "périmètre : 63.82 aire : 294.52/n couleur = R0,G0,B0 epaisseur = 1px", ellipse.toString());
	}
	
	@Test
	public void testToStringEnRempli() {
		Ellipse ellipse = new Ellipse(new Coordonnees(10, 10), 25, 15);
		ellipse.setRempli(true);
		ellipse.setCouleur(Color.RED);
		ellipse.setCouleurRemplissage(Color.BLUE);
		
		Locale.setDefault(Locale.ENGLISH);
		
		assertEquals("[Ellipse-Rempli] : pos (10.0 , 10.0) dim 25.0 x 15.0 "
				+ "périmètre : 63.82 aire : 294.52/n couleur = R255,G0,B0 epaisseur = 1px remplissage = R0,G0,B255", ellipse.toString());
	}
	
	@Test
	public void testContient() {
		Ellipse ellipse = new Ellipse(new Coordonnees(10, 10), 25, 25);
		
		assertTrue(ellipse.contient(new Coordonnees(15, 15)));
	}
	
	@Test
	public void testContientPas() {
		Ellipse ellipse = new Ellipse(new Coordonnees(10, 10), 25, 25);
		
		assertFalse(ellipse.contient(new Coordonnees(5, 17.5)));
	}
}

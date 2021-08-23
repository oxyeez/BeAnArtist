package fr.eseo.poo.projet.artiste.modele.formes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;

public class CercleTest {
	public static final double EPSILON = 1e-6;

	@Test
	public void testSetLargeur() {
		Cercle cercle = new Cercle();
		cercle.setLargeur(25);
		
		assertEquals(25, cercle.getLargeur(), EPSILON);
		assertEquals(25, cercle.getHauteur(), EPSILON);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testSetLargeurNeg() {
		Cercle cercle = new Cercle();
		cercle.setLargeur(-25);
	}

	@Test
	public void testSetHauteur() {
		Cercle cercle = new Cercle();
		cercle.setHauteur(25);
		
		assertEquals(25, cercle.getLargeur(), EPSILON);
		assertEquals(25, cercle.getHauteur(), EPSILON);		
	}

	@Test
	public void testPerimetre() {
		Cercle cercle = new Cercle(new Coordonnees(10, 10), 25);
		
		assertEquals(Math.PI*25, cercle.perimetre(), EPSILON);
	}

	@Test
	public void testCercle() {
		Cercle cercle = new Cercle();
		
		assertEquals(100, cercle.getLargeur(), EPSILON);
		assertEquals(100, cercle.getHauteur(), EPSILON);
		assertEquals(50, cercle.getPosition().getAbscisse(), EPSILON);
		assertEquals(50, cercle.getPosition().getOrdonnee(), EPSILON);
	}

	@Test
	public void testCercleDouble() {
		Cercle cercle = new Cercle(25);
		
		assertEquals(25, cercle.getLargeur(), EPSILON);
		assertEquals(25, cercle.getHauteur(), EPSILON);
		assertEquals(50, cercle.getPosition().getAbscisse(), EPSILON);
		assertEquals(50, cercle.getPosition().getOrdonnee(), EPSILON);
	}

	@Test
	public void testCercleCoordonnees() {
		Cercle cercle = new Cercle(new Coordonnees(10, 10));
		
		assertEquals(100, cercle.getLargeur(), EPSILON);
		assertEquals(100, cercle.getHauteur(), EPSILON);
		assertEquals(10, cercle.getPosition().getAbscisse(), EPSILON);
		assertEquals(10, cercle.getPosition().getOrdonnee(), EPSILON);
	}

	@Test
	public void testCercleCoordonneesDouble() {
		Cercle cercle = new Cercle(new Coordonnees(10, 10), 25);
		
		assertEquals(25, cercle.getLargeur(), EPSILON);
		assertEquals(25, cercle.getHauteur(), EPSILON);
		assertEquals(10, cercle.getPosition().getAbscisse(), EPSILON);
		assertEquals(10, cercle.getPosition().getOrdonnee(), EPSILON);
	}
	
	@Test
	public void testContient() {
		Cercle cercle = new Cercle(new Coordonnees(10, 10), 25);
		
		assertTrue(cercle.contient(new Coordonnees(15, 15)));
	}
}

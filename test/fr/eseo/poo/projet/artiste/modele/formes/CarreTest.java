package fr.eseo.poo.projet.artiste.modele.formes;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;

public class CarreTest {
	public static final double EPSILON = 1e-6;

	@Test
	public void testSetLargeur() {
		Carre carre = new Carre();
		carre.setLargeur(25);
		
		assertEquals(25, carre.getLargeur(), EPSILON);
		assertEquals(25, carre.getHauteur(), EPSILON);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testSetLargeurNeg() {
		Carre carre = new Carre();
		carre.setLargeur(-25);
	}

	@Test
	public void testSetHauteur() {
		Carre carre = new Carre();
		carre.setHauteur(25);
		
		assertEquals(25, carre.getLargeur(), EPSILON);
		assertEquals(25, carre.getHauteur(), EPSILON);		
	}

	@Test
	public void testCarre() {
		Carre carre = new Carre();
		
		assertEquals(100, carre.getLargeur(), EPSILON);
		assertEquals(100, carre.getHauteur(), EPSILON);
		assertEquals(50, carre.getPosition().getAbscisse(), EPSILON);
		assertEquals(50, carre.getPosition().getOrdonnee(), EPSILON);
	}

	@Test
	public void testCarreDouble() {
		Carre carre = new Carre(25);
		
		assertEquals(25, carre.getLargeur(), EPSILON);
		assertEquals(25, carre.getHauteur(), EPSILON);
		assertEquals(50, carre.getPosition().getAbscisse(), EPSILON);
		assertEquals(50, carre.getPosition().getOrdonnee(), EPSILON);
	}

	@Test
	public void testCarreCoordonnees() {
		Carre carre = new Carre(new Coordonnees(10, 10));
		
		assertEquals(100, carre.getLargeur(), EPSILON);
		assertEquals(100, carre.getHauteur(), EPSILON);
		assertEquals(10, carre.getPosition().getAbscisse(), EPSILON);
		assertEquals(10, carre.getPosition().getOrdonnee(), EPSILON);
	}

	@Test
	public void testCarreCoordonneesDouble() {
		Carre carre = new Carre(new Coordonnees(10, 10), 25);
		
		assertEquals(25, carre.getLargeur(), EPSILON);
		assertEquals(25, carre.getHauteur(), EPSILON);
		assertEquals(10, carre.getPosition().getAbscisse(), EPSILON);
		assertEquals(10, carre.getPosition().getOrdonnee(), EPSILON);
	}
}

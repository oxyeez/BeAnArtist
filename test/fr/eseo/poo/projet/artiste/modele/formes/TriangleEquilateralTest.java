package fr.eseo.poo.projet.artiste.modele.formes;

import static org.junit.Assert.*;

import org.junit.Test;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;

public class TriangleEquilateralTest {
	public static final double EPSILON = 1e-6;

	@Test
	public void testTriangleEquilateral() {
		TriangleEquilateral triangle = new TriangleEquilateral();

		assertEquals(triangle.getBase1().distanceVers(triangle.getBase2()), triangle.getBase1().distanceVers(triangle.getSommet()), EPSILON);
		assertEquals(triangle.getBase1().distanceVers(triangle.getBase2()), triangle.getBase2().distanceVers(triangle.getSommet()), EPSILON);
	}

	@Test
	public void testTriangleEquilateralCoordonnees() {
		TriangleEquilateral triangle = new TriangleEquilateral(new Coordonnees(0, 6));
		
		assertEquals(triangle.getBase1().distanceVers(triangle.getBase2()), triangle.getBase1().distanceVers(triangle.getSommet()), EPSILON);
		assertEquals(triangle.getBase1().distanceVers(triangle.getBase2()), triangle.getBase2().distanceVers(triangle.getSommet()), EPSILON);
	}

	@Test
	public void testTriangleEquilateralCoordonneesCoordonnees() {
		TriangleEquilateral triangle = new TriangleEquilateral(new Coordonnees(0, 6), new Coordonnees(6, 0));
		assertEquals(triangle.getBase1().distanceVers(triangle.getBase2()), triangle.getBase1().distanceVers(triangle.getSommet()), EPSILON);
		assertEquals(triangle.getBase1().distanceVers(triangle.getBase2()), triangle.getBase2().distanceVers(triangle.getSommet()), EPSILON);
	}

}

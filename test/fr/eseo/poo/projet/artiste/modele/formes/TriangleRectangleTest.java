package fr.eseo.poo.projet.artiste.modele.formes;

import static org.junit.Assert.*;

import org.junit.Test;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;

public class TriangleRectangleTest {
	public static final double EPSILON = 1e-6;

	@Test
	public void testTriangleRectangle() {
		TriangleRectangle triangle = new TriangleRectangle();
		
		assertTrue(triangle.getBase1().estEgalA(new Coordonnees(50, 50)));
		assertTrue(triangle.getBase2().estEgalA(new Coordonnees(70, 30)));
		assertTrue(triangle.getSommet().estEgalA(new Coordonnees(90, 50)));
		assertTrue(triangle.getPosition().estEgalA(new Coordonnees(50, 30)));
		assertEquals(40, triangle.getLargeur(), EPSILON);
		assertEquals(20, triangle.getHauteur(), EPSILON);
	}

	@Test
	public void testTriangleRectangleCoordonnees() {
		TriangleRectangle triangle = new TriangleRectangle(new Coordonnees(100, 60));
		
		assertTrue(triangle.getBase1().estEgalA(new Coordonnees(100, 60)));
		assertTrue(triangle.getBase2().estEgalA(new Coordonnees(200, 160)));
		assertTrue(triangle.getSommet().estEgalA(new Coordonnees(250, 110)));
		assertTrue(triangle.getPosition().estEgalA(new Coordonnees(100, 60)));
		assertEquals(150, triangle.getLargeur(), EPSILON);
		assertEquals(100, triangle.getHauteur(), EPSILON);
	}

	@Test
	public void testTriangleRectangleCoordonneesCoordonnees() {
		TriangleRectangle triangle = new TriangleRectangle(new Coordonnees(6, 0), new Coordonnees(0, 6));
		
		assertTrue(triangle.getBase1().estEgalA(new Coordonnees(6, 0)));
		assertTrue(triangle.getBase2().estEgalA(new Coordonnees(0, 6)));
		assertTrue(triangle.getSommet().estEgalA(new Coordonnees(3, 9)));
		assertTrue(triangle.getPosition().estEgalA(new Coordonnees(0, 0)));
		assertEquals(6, triangle.getLargeur(), EPSILON);
		assertEquals(9, triangle.getHauteur(), EPSILON);
	}

	@Test
	public void testTriangleRectangleCoordonneesCoordonneesCoordonnees() {
		TriangleRectangle triangle = new TriangleRectangle(new Coordonnees(6, 0), new Coordonnees(0, 6), new Coordonnees(8, 7));
		
		assertTrue(triangle.getBase1().estEgalA(new Coordonnees(6, 0)));
		assertTrue(triangle.getBase2().estEgalA(new Coordonnees(0, 6)));
		assertTrue(triangle.getSommet().estEgalA(new Coordonnees(4.5, 10.5)));
		assertTrue(triangle.getPosition().estEgalA(new Coordonnees(0, 0)));
		assertEquals(6, triangle.getLargeur(), EPSILON);
		assertEquals(10.5, triangle.getHauteur(), EPSILON);
	}

}

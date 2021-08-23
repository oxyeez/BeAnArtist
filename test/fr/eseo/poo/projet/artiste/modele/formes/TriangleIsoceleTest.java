package fr.eseo.poo.projet.artiste.modele.formes;

import static org.junit.Assert.*;

import java.util.Locale;

import org.junit.Test;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;

public class TriangleIsoceleTest {
	public static final double EPSILON = 1e-6;

	@Test
	public void testTriangleIsocele() {
		TriangleIsocele triangle = new TriangleIsocele();
		
		assertTrue(triangle.getBase1().estEgalA(new Coordonnees(50, 50)));
		assertTrue(triangle.getBase2().estEgalA(new Coordonnees(70, 30)));
		assertTrue(triangle.getSommet().estEgalA(new Coordonnees(80, 60)));
		assertTrue(triangle.getPosition().estEgalA(new Coordonnees(50, 30)));
		assertEquals(30, triangle.getLargeur(), EPSILON);
		assertEquals(30, triangle.getHauteur(), EPSILON);
	}

	@Test
	public void testTriangleIsoceleCoordonnees() {
		TriangleIsocele triangle = new TriangleIsocele(new Coordonnees(0, 60));
		
		assertTrue(triangle.getBase1().estEgalA(new Coordonnees(0, 60)));
		assertTrue(triangle.getBase2().estEgalA(new Coordonnees(100, 160)));
		assertTrue(triangle.getSommet().estEgalA(new Coordonnees(200, -40)));
		assertTrue(triangle.getPosition().estEgalA(new Coordonnees(0, -40)));
		assertEquals(200, triangle.getLargeur(), EPSILON);
		assertEquals(200, triangle.getHauteur(), EPSILON);
	}

	@Test
	public void testTriangleIsoceleCoordonneesCoordonnees() {
		TriangleIsocele triangle = new TriangleIsocele(new Coordonnees(6, 0), new Coordonnees(0, 6));
		
		assertTrue(triangle.getBase1().estEgalA(new Coordonnees(6, 0)));
		assertTrue(triangle.getBase2().estEgalA(new Coordonnees(0, 6)));
		assertTrue(triangle.getSommet().estEgalA(new Coordonnees(12, 12)));
		assertTrue(triangle.getPosition().estEgalA(new Coordonnees(0, 0)));
		assertEquals(12, triangle.getLargeur(), EPSILON);
		assertEquals(12, triangle.getHauteur(), EPSILON);
	}

	@Test
	public void testTriangleIsoceleCoordonneesCoordonneesCoordonnees() {
		TriangleIsocele triangle = new TriangleIsocele(new Coordonnees(0, 6), new Coordonnees(6, 0), new Coordonnees(8, 7));
		
		assertTrue(triangle.getBase1().estEgalA(new Coordonnees(0, 6)));
		assertTrue(triangle.getBase2().estEgalA(new Coordonnees(6, 0)));
		assertTrue(triangle.getSommet().estEgalA(new Coordonnees(7.5, 7.5)));
		assertTrue(triangle.getPosition().estEgalA(new Coordonnees(0, 0)));
		assertEquals(7.5, triangle.getLargeur(), EPSILON);
		assertEquals(7.5, triangle.getHauteur(), EPSILON);
	}

	@Test
	public void testToString() {
		TriangleIsocele triangle = new TriangleIsocele(new Coordonnees(0, 6), new Coordonnees(6, 0), new Coordonnees(8, 7));
		
		Locale.setDefault(Locale.FRENCH);
		
		assertEquals("[TriangleIsocele] : base de (0,0 , 6,0) à (6,0 , 0,0) sommet (7,5 , 7,5) hauteur : 6,36 "
				+ "périmètre : 23,78 aire : 27,0/n couleur = R0,V0,B0 epaisseur = 1px", triangle.toString());
	}
}

package fr.eseo.poo.projet.artiste.modele;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class CoordonneesTest {
	public static final double EPSILON = 1e-6;

	@Test
	public void testConstructeur0() {
		Coordonnees coord = new Coordonnees();

		assertEquals(Coordonnees.ABSCISSE_PAR_DEFAUT, coord.getAbscisse(), EPSILON);
		assertEquals(Coordonnees.ORDONNEE_PAR_DEFAUT, coord.getOrdonnee(), EPSILON);
	}

	@Test
	public void testConstructeur2() {
		Coordonnees coord = new Coordonnees(45, 68);

		assertEquals(45, coord.getAbscisse(), EPSILON);
		assertEquals(68, coord.getOrdonnee(), EPSILON);
	}

	@Test
	public void testDeplacerDe() {
		Coordonnees coord = new Coordonnees();
		coord.deplacerDe(-5, 18);

		assertEquals(45, coord.getAbscisse(), EPSILON);
		assertEquals(68, coord.getOrdonnee(), EPSILON);
	}

	@Test
	public void testDeplacerVers() {
		Coordonnees coord = new Coordonnees();
		coord.deplacerVers(45, 68);

		assertEquals(45, coord.getAbscisse(), EPSILON);
		assertEquals(68, coord.getOrdonnee(), EPSILON);
	}

	@Test
	public void testDistanceVers() {
		Coordonnees coord = new Coordonnees(10, 10);
		Coordonnees coord2 = new Coordonnees(50, 50);

		assertEquals(40*Math.sqrt(2), coord.distanceVers(coord2), EPSILON);
	}

	@Test
	public void testToString() {
		Coordonnees coord = new Coordonnees();

		assertEquals("(50,0 , 50,0)", coord.toString());
	}
	
	@Test
	public void testEgal() {
		Coordonnees coord1 = new Coordonnees(12, 12);
		Coordonnees coord2 = new Coordonnees(12, 12);

		assertTrue(coord1.estEgalA(coord2));
	}

	@Test
	public void testPasEgalAbs() {
		Coordonnees coord1 = new Coordonnees(12, 12);
		Coordonnees coord2 = new Coordonnees(15, 12);

		assertFalse(coord1.estEgalA(coord2));
	}
	
	@Test
	public void testPasEgalOrd() {
		Coordonnees coord1 = new Coordonnees(12, 12);
		Coordonnees coord2 = new Coordonnees(12, 15);

		assertFalse(coord1.estEgalA(coord2));
	}
	
	@Test
	public void testPasEgalDuTout() {
		Coordonnees coord1 = new Coordonnees(15, 12);
		Coordonnees coord2 = new Coordonnees(12, 15);

		assertFalse(coord1.estEgalA(coord2));
	}
	
	@Test
	public void testMilieu() {
		Coordonnees coord1 = new Coordonnees(0, 0);
		Coordonnees coord2 = new Coordonnees(20, 20);
		Coordonnees coordMilieu = new Coordonnees(10, 10);

		assertTrue((coord1.milieu(coord2)).estEgalA(coordMilieu));
	}
}

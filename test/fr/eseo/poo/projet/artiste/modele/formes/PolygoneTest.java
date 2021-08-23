package fr.eseo.poo.projet.artiste.modele.formes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Locale;

import org.junit.Test;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;

public class PolygoneTest {
	public static final double EPSILON = 1e-6;
	
	@Test (expected = IllegalArgumentException.class)
	public void testSetLargeurNeg() {
		Polygone polygone = new Polygone(new Coordonnees(10, 10), 25.0);
		polygone.setLargeur(-30);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testSetHauteurNeg() {
		Polygone polygone = new Polygone(new Coordonnees(10, 10), 25.0);
		polygone.setHauteur(-30);
	}
	
	@Test
	public void testAire() {
		Polygone polygone = new Polygone(new Coordonnees(10, 10), 50, 8, 0);
		
		assertEquals(1767.766952966, polygone.aire(), EPSILON);
	}

	@Test
	public void testPerimetre() {
		Polygone polygone = new Polygone(new Coordonnees(10, 10), 50, 8, 0);
		
		assertEquals(153.073372946, polygone.perimetre(), EPSILON);
	}
	
	@Test
	public void testContientRayon1() {
		Polygone polygone = new Polygone(new Coordonnees(-15, -15), 50, 8, 0.1831108172625);

		assertTrue(polygone.contient(new Coordonnees(10, 10)));
	}
	
	@Test
	public void testContientRayon2() {
		Polygone polygone = new Polygone(new Coordonnees(-15, -15), 50, 8, 0);

		assertTrue(polygone.contient(new Coordonnees(-7.67, -7.67)));
	}
	
	@Test
	public void testContientPas() {
		Polygone polygone = new Polygone(new Coordonnees(-15, -15), 50, 8, 0);
		
		assertFalse(polygone.contient(new Coordonnees(70, 80)));
	}
	
	@Test
	public void testPolygone() {
		Polygone polygone = new Polygone();
		
		assertEquals(100, polygone.getLargeur(), EPSILON);
		assertEquals(100, polygone.getHauteur(), EPSILON);
		assertEquals(50, polygone.getPosition().getAbscisse(), EPSILON);
		assertEquals(50, polygone.getPosition().getOrdonnee(), EPSILON);
		assertEquals(5, polygone.getNombreSommets());
		assertEquals(-Math.PI/2, polygone.getAnglePremierSommet(), EPSILON);
	}
	
	@Test
	public void testPolygoneInt() {
		Polygone polygone = new Polygone(8);
		
		assertEquals(100, polygone.getLargeur(), EPSILON);
		assertEquals(100, polygone.getHauteur(), EPSILON);
		assertEquals(50, polygone.getPosition().getAbscisse(), EPSILON);
		assertEquals(50, polygone.getPosition().getOrdonnee(), EPSILON);
		assertEquals(8, polygone.getNombreSommets());
		assertEquals(-Math.PI/2, polygone.getAnglePremierSommet(), EPSILON);
	}
	
	@Test
	public void testPolygoneDouble() {
		Polygone polygone = new Polygone(25.0);
		
		assertEquals(25, polygone.getLargeur(), EPSILON);
		assertEquals(25, polygone.getHauteur(), EPSILON);
		assertEquals(50, polygone.getPosition().getAbscisse(), EPSILON);
		assertEquals(50, polygone.getPosition().getOrdonnee(), EPSILON);
		assertEquals(5, polygone.getNombreSommets());
		assertEquals(-Math.PI/2, polygone.getAnglePremierSommet(), EPSILON);
	}
	
	@Test
	public void testPolygoneDoubleInt() {
		Polygone polygone = new Polygone(25.0, 8);
		
		assertEquals(25, polygone.getLargeur(), EPSILON);
		assertEquals(25, polygone.getHauteur(), EPSILON);
		assertEquals(50, polygone.getPosition().getAbscisse(), EPSILON);
		assertEquals(50, polygone.getPosition().getOrdonnee(), EPSILON);
		assertEquals(8, polygone.getNombreSommets());
		assertEquals(-Math.PI/2, polygone.getAnglePremierSommet(), EPSILON);
	}
	
	@Test
	public void testPolygoneCoordonnees() {
		Polygone polygone = new Polygone(new Coordonnees(10, 10));
		
		assertEquals(100, polygone.getLargeur(), EPSILON);
		assertEquals(100, polygone.getHauteur(), EPSILON);
		assertEquals(10, polygone.getPosition().getAbscisse(), EPSILON);
		assertEquals(10, polygone.getPosition().getOrdonnee(), EPSILON);
		assertEquals(5, polygone.getNombreSommets());
		assertEquals(-Math.PI/2, polygone.getAnglePremierSommet(), EPSILON);
	}
	
	@Test
	public void testPolygoneCoordonneesInt() {
		Polygone polygone = new Polygone(new Coordonnees(10, 10), 8);
		
		assertEquals(100, polygone.getLargeur(), EPSILON);
		assertEquals(100, polygone.getHauteur(), EPSILON);
		assertEquals(10, polygone.getPosition().getAbscisse(), EPSILON);
		assertEquals(10, polygone.getPosition().getOrdonnee(), EPSILON);
		assertEquals(8, polygone.getNombreSommets());
		assertEquals(-Math.PI/2, polygone.getAnglePremierSommet(), EPSILON);
	}
	
	@Test
	public void testPolygoneCoordonneesDouble() {
		Polygone polygone = new Polygone(new Coordonnees(10, 10), 25.0);
		
		assertEquals(25, polygone.getLargeur(), EPSILON);
		assertEquals(25, polygone.getHauteur(), EPSILON);
		assertEquals(10, polygone.getPosition().getAbscisse(), EPSILON);
		assertEquals(10, polygone.getPosition().getOrdonnee(), EPSILON);
		assertEquals(5, polygone.getNombreSommets());
		assertEquals(-Math.PI/2, polygone.getAnglePremierSommet(), EPSILON);
	}
	
	@Test
	public void testPolygoneCoordonneesDoubleInt() {
		Polygone polygone = new Polygone(new Coordonnees(10, 10), 25.0, 8);
		
		assertEquals(25, polygone.getLargeur(), EPSILON);
		assertEquals(25, polygone.getHauteur(), EPSILON);
		assertEquals(10, polygone.getPosition().getAbscisse(), EPSILON);
		assertEquals(10, polygone.getPosition().getOrdonnee(), EPSILON);
		assertEquals(8, polygone.getNombreSommets());
		assertEquals(-Math.PI/2, polygone.getAnglePremierSommet(), EPSILON);
	}
	
	@Test
	public void testPolygoneCoordonneesDoubleIntDouble() {
		Polygone polygone = new Polygone(new Coordonnees(10, 10), 25.0, 8, Math.PI);
		
		assertEquals(25, polygone.getLargeur(), EPSILON);
		assertEquals(25, polygone.getHauteur(), EPSILON);
		assertEquals(10, polygone.getPosition().getAbscisse(), EPSILON);
		assertEquals(10, polygone.getPosition().getOrdonnee(), EPSILON);
		assertEquals(8, polygone.getNombreSommets());
		assertEquals(Math.PI, polygone.getAnglePremierSommet(), EPSILON);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testSetNombreSommetsPasAssez() {
		Polygone polygone = new Polygone();
		polygone.setNombreSommets(2);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testSetNombreSommetsTrop() {
		Polygone polygone = new Polygone();
		polygone.setNombreSommets(18);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testSetAnglePremierSommetPasAssez() {
		Polygone polygone = new Polygone();
		polygone.setAnglePremierSommet(-4);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testSetAnglePremierSommetTrop() {
		Polygone polygone = new Polygone();
		polygone.setAnglePremierSommet(4);
	}
	
	@Test
	public void testToStringOctogoneFrVide() {
		Polygone polygone = new Polygone(new Coordonnees(10, 10), 50, 8, 0);
		
		Locale.setDefault(Locale.FRENCH);
		
		assertEquals("[Octogone] : pos (10,0 , 10,0) dim 50,0 x 50,0 "
				+ "périmètre : 153,07 aire : 1767,77/n couleur = R0,V0,B0 epaisseur = 1px", polygone.toString());
	}
	
	@Test
	public void testToStringPentagoneFrRempli() {
		Polygone polygone = new Polygone(new Coordonnees(10, 10), 50, 5, 0);
		polygone.setRempli(true);
		
		Locale.setDefault(Locale.FRENCH);

		assertEquals("[Pentagone-Rempli] : pos (10,0 , 10,0) dim 50,0 x 50,0 "
				+ "périmètre : 146,95 aire : 1486,03/n couleur = R0,V0,B0 epaisseur = 1px remplissage = R0,V0,B0", polygone.toString());
	}
	
	@Test
	public void testToStringDecagoneEnVide() {
		Polygone polygone = new Polygone(new Coordonnees(10, 10), 50, 10, 0);
		
		Locale.setDefault(Locale.ENGLISH);

		assertEquals("[Decagone] : pos (10.0 , 10.0) dim 50.0 x 50.0 "
				+ "périmètre : 154.51 aire : 1836.83/n couleur = R0,G0,B0 epaisseur = 1px", polygone.toString());
	}
	
	public void testToStringDecagoneEnRempli() {
		Polygone polygone = new Polygone(new Coordonnees(10, 10), 50, 10, 0);
		polygone.setRempli(true);
		
		Locale.setDefault(Locale.ENGLISH);

		assertEquals("[Decagone-Rempli] : pos (10.0 , 10.0) dim 50.0 x 50.0 "
				+ "périmètre : 154.51 aire : 1836.83/n couleur = R0,G0,B0 epaisseur = 1px remplissage = R0,G0,B0", polygone.toString());
	}
	
	@Test
	public void testRempli() {
		Polygone polygone = new Polygone(new Coordonnees(10, 10), 50, 8, 0);
		
		assertFalse(polygone.estRempli());
		
		polygone.setRempli(true);
		
		assertTrue(polygone.estRempli());
	}
}

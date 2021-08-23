package fr.eseo.poo.projet.artiste.modele.formes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.awt.Color;
import java.util.Locale;

import org.junit.Test;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;

public class EtoileTest {
	public static final double EPSILON = 1e-6;
	
	@Test (expected = IllegalArgumentException.class)
	public void testSetLargeurNeg() {
		Etoile etoile = new Etoile(new Coordonnees(10, 10), 25);
		etoile.setLargeur(-30);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testSetHauteurNeg() {
		Etoile etoile = new Etoile(new Coordonnees(10, 10), 25);
		etoile.setHauteur(-30);
	}
	
	@Test
	public void testAire() {
		Etoile etoile = new Etoile(new Coordonnees(10, 10), 40, 8, 0, 0.75);
		
		assertEquals(306.146745, etoile.aire(), EPSILON);
	}

	@Test
	public void testPerimetre() {
		Etoile etoile = new Etoile(new Coordonnees(10, 10), 50, 4, 0, 0.5);
		
		assertEquals(147.362575820, etoile.perimetre(), EPSILON);
	}
	
	@Test
	public void testContientRayon1() {
		Etoile etoile = new Etoile(new Coordonnees(-15, -15), 50, 4, 0.1470783553884, 0.5);
		
		assertTrue(etoile.contient(new Coordonnees(10, 10)));
	}
	
	@Test
	public void testContientRayon2() {
		Etoile etoile = new Etoile(new Coordonnees(-15, -15), 50, 4, 0, 0.5);
		
		assertTrue(etoile.contient(new Coordonnees(10, 10)));
	}
	
	@Test
	public void testContientPas() {
		Etoile etoile = new Etoile(new Coordonnees(-15, -15), 50, 4, 0, 0.5);
		
		assertFalse(etoile.contient(new Coordonnees(70, 80)));
	}

	@Test
	public void testEtoile() {
		Etoile etoile = new Etoile();
		
		assertEquals(100, etoile.getLargeur(), EPSILON);
		assertEquals(100, etoile.getHauteur(), EPSILON);
		assertEquals(50, etoile.getPosition().getAbscisse(), EPSILON);
		assertEquals(50, etoile.getPosition().getOrdonnee(), EPSILON);
		assertEquals(5, etoile.getNombreBranches());
		assertEquals(-Math.PI/2, etoile.getAnglePremiereBranche(), EPSILON);
		assertEquals(0.5, etoile.getLongueurBranche(), EPSILON);
	}

	@Test
	public void testEtoileDouble() {
		Etoile etoile = new Etoile(25);
		
		assertEquals(25, etoile.getLargeur(), EPSILON);
		assertEquals(25, etoile.getHauteur(), EPSILON);
		assertEquals(50, etoile.getPosition().getAbscisse(), EPSILON);
		assertEquals(50, etoile.getPosition().getOrdonnee(), EPSILON);
		assertEquals(5, etoile.getNombreBranches());
		assertEquals(-Math.PI/2, etoile.getAnglePremiereBranche(), EPSILON);
		assertEquals(0.5, etoile.getLongueurBranche(), EPSILON);
	}

	@Test
	public void testEtoileCoordonnees() {
		Etoile etoile = new Etoile(new Coordonnees(10, 10));
		
		assertEquals(100, etoile.getLargeur(), EPSILON);
		assertEquals(100, etoile.getHauteur(), EPSILON);
		assertEquals(10, etoile.getPosition().getAbscisse(), EPSILON);
		assertEquals(10, etoile.getPosition().getOrdonnee(), EPSILON);
		assertEquals(5, etoile.getNombreBranches());
		assertEquals(-Math.PI/2, etoile.getAnglePremiereBranche(), EPSILON);
		assertEquals(0.5, etoile.getLongueurBranche(), EPSILON);
	}

	@Test
	public void testEtoileCoordonneesDouble() {
		Etoile etoile = new Etoile(new Coordonnees(10, 10), 25);
		
		assertEquals(25, etoile.getLargeur(), EPSILON);
		assertEquals(25, etoile.getHauteur(), EPSILON);
		assertEquals(10, etoile.getPosition().getAbscisse(), EPSILON);
		assertEquals(10, etoile.getPosition().getOrdonnee(), EPSILON);
		assertEquals(5, etoile.getNombreBranches());
		assertEquals(-Math.PI/2, etoile.getAnglePremiereBranche(), EPSILON);
		assertEquals(0.5, etoile.getLongueurBranche(), EPSILON);
	}

	@Test
	public void testEtoileCoordonneesDoubleIntDoubleDouble() {
		Etoile etoile = new Etoile(new Coordonnees(10, 10), 25, 8, Math.PI, 0.3);
		
		assertEquals(25, etoile.getLargeur(), EPSILON);
		assertEquals(25, etoile.getHauteur(), EPSILON);
		assertEquals(10, etoile.getPosition().getAbscisse(), EPSILON);
		assertEquals(10, etoile.getPosition().getOrdonnee(), EPSILON);
		assertEquals(8, etoile.getNombreBranches());
		assertEquals(Math.PI, etoile.getAnglePremiereBranche(), EPSILON);
		assertEquals(0.3, etoile.getLongueurBranche(), EPSILON);
	}

	@Test (expected = IllegalArgumentException.class)
	public void testSetNombreBranchesPasAssez() {
		Etoile etoile = new Etoile();
		etoile.setNombreBranches(2);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testSetNombreBranchesTrop() {
		Etoile etoile = new Etoile();
		etoile.setNombreBranches(18);
	}

	@Test (expected = IllegalArgumentException.class)
	public void testSetLongueurBrancheNeg() {
		Etoile etoile = new Etoile();
		etoile.setLongueurBranche(-2);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testSetLongueurBrancheTropGrand() {
		Etoile etoile = new Etoile();
		etoile.setLongueurBranche(1.2);
	}

	@Test (expected = IllegalArgumentException.class)
	public void testSetAnglePremiereBranchePasAssez() {
		Etoile etoile = new Etoile();
		etoile.setAnglePremiereBranche(-4);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testSetAnglePremiereBrancheTrop() {
		Etoile etoile = new Etoile();
		etoile.setAnglePremiereBranche(4);
	}

	@Test
	public void testToStringFrVide() {
		Etoile etoile = new Etoile(new Coordonnees(10, 10), 50, 4, 0, 0.5);
		
		Locale.setDefault(Locale.FRENCH);
		
		assertEquals("[Etoile] : pos (10,0 , 10,0) dim 50,0 x 50,0 "
				+ "périmètre : 147,36 aire : 883,88/n couleur = R0,V0,B0 epaisseur = 1px", etoile.toString());
	}
	
	@Test
	public void testToStringFrRempli() {
		Etoile etoile = new Etoile(new Coordonnees(10, 10), 50, 4, 0, 0.5);
		etoile.setRempli(true);
		etoile.setCouleurRemplissage(Color.RED);
		
		Locale.setDefault(Locale.FRENCH);
		
		assertEquals("[Etoile-Rempli] : pos (10,0 , 10,0) dim 50,0 x 50,0 "
				+ "périmètre : 147,36 aire : 883,88/n couleur = R0,V0,B0 epaisseur = 1px remplissage = R255,V0,B0", etoile.toString());
	}
	
	@Test
	public void testToStringEnVide() {
		Etoile etoile = new Etoile(new Coordonnees(10, 10), 50, 4, 0, 0.5);
		
		Locale.setDefault(Locale.ENGLISH);
		
		assertEquals("[Etoile] : pos (10.0 , 10.0) dim 50.0 x 50.0 "
				+ "périmètre : 147.36 aire : 883.88/n couleur = R0,G0,B0 epaisseur = 1px", etoile.toString());
	}
	
	@Test
	public void testToStringEnRempli() {
		Etoile etoile = new Etoile(new Coordonnees(10, 10), 50, 4, 0, 0.5);
		etoile.setRempli(true);
		etoile.setCouleurRemplissage(Color.RED);
		
		Locale.setDefault(Locale.ENGLISH);
		
		assertEquals("[Etoile-Rempli] : pos (10.0 , 10.0) dim 50.0 x 50.0 "
				+ "périmètre : 147.36 aire : 883.88/n couleur = R0,G0,B0 epaisseur = 1px remplissage = R255,G0,B0", etoile.toString());
	}

	@Test
	public void testRempli() {
		Etoile etoile = new Etoile(new Coordonnees(10, 10), 50, 4, 0, 0.5);
		
		assertFalse(etoile.estRempli());
		
		etoile.setRempli(true);
		
		assertTrue(etoile.estRempli());
	}

}

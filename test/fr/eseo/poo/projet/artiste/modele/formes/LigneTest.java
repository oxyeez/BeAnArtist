/**
 * 
 */
package fr.eseo.poo.projet.artiste.modele.formes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Locale;

import static org.junit.Assert.assertFalse;

import org.junit.Test;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;

/**
 * @author marcelin
 *
 */
public class LigneTest {
	public static final double EPSILON = 1e-6;

	@Test
	public void testAire() {
		Ligne ligne = new Ligne();

		assertEquals(0, ligne.aire(), EPSILON);
	}

	@Test
	public void testPerimetre() {
		Ligne ligne = new Ligne(new Coordonnees(10, 10), -5, 20);

		assertEquals(Math.sqrt(25 + 400), ligne.perimetre(), EPSILON);
	}

	@Test
	public void testLigne() {
		Ligne ligne = new Ligne();

		assertEquals(Forme.LARGEUR_PAR_DEFAUT, ligne.getLargeur(), EPSILON);
		assertEquals(Forme.HAUTEUR_PAR_DEFAUT, ligne.getHauteur(), EPSILON);
		assertEquals(Coordonnees.ABSCISSE_PAR_DEFAUT, ligne.getPosition().getAbscisse(), EPSILON);
		assertEquals(Coordonnees.ORDONNEE_PAR_DEFAUT, ligne.getPosition().getOrdonnee(), EPSILON);
	}

	@Test
	public void testLigneCoordonnees() {
		Ligne ligne = new Ligne(new Coordonnees(10, 25));

		assertEquals(Forme.LARGEUR_PAR_DEFAUT, ligne.getLargeur(), EPSILON);
		assertEquals(Forme.HAUTEUR_PAR_DEFAUT, ligne.getHauteur(), EPSILON);
		assertEquals(10, ligne.getPosition().getAbscisse(), EPSILON);
		assertEquals(25, ligne.getPosition().getOrdonnee(), EPSILON);
	}

	@Test
	public void testLigneDoubleDouble() {
		Ligne ligne = new Ligne(45, 68);

		assertEquals(45, ligne.getLargeur(), EPSILON);
		assertEquals(68, ligne.getHauteur(), EPSILON);
		assertEquals(Coordonnees.ABSCISSE_PAR_DEFAUT, ligne.getPosition().getAbscisse(), EPSILON);
		assertEquals(Coordonnees.ORDONNEE_PAR_DEFAUT, ligne.getPosition().getOrdonnee(), EPSILON);
	}

	@Test
	public void testLigneCoordonneesDoubleDouble() {
		Ligne ligne = new Ligne(new Coordonnees(10, 25), 45, 68);

		assertEquals(45, ligne.getLargeur(), EPSILON);
		assertEquals(68, ligne.getHauteur(), EPSILON);
		assertEquals(10, ligne.getPosition().getAbscisse(), EPSILON);
		assertEquals(25, ligne.getPosition().getOrdonnee(), EPSILON);
	}

	@Test
	public void testGetC1() {
		Ligne ligne = new Ligne(new Coordonnees(10, 15), -5, 20);

		assertEquals(10, ligne.getC1().getAbscisse(), EPSILON);
		assertEquals(15, ligne.getC1().getOrdonnee(), EPSILON);
	}

	@Test
	public void testGetC2() {
		Ligne ligne = new Ligne(new Coordonnees(10, 15), -5, 20);

		assertEquals(10 - 5, ligne.getC2().getAbscisse(), EPSILON);
		assertEquals(15 + 20, ligne.getC2().getOrdonnee(), EPSILON);
	}

	@Test
	public void testSetC1() {
		Ligne ligne = new Ligne(new Coordonnees(10, 15), -5, 20);
		ligne.setC1(new Coordonnees(5, 20));

		assertEquals(5, ligne.getC1().getAbscisse(), EPSILON);
		assertEquals(20, ligne.getC1().getOrdonnee(), EPSILON);
		assertEquals(10 - 5, ligne.getC2().getAbscisse(), EPSILON);
		assertEquals(15 + 20, ligne.getC2().getOrdonnee(), EPSILON);
	}

	@Test
	public void testSetC2() {
		Ligne ligne = new Ligne(new Coordonnees(10, 15), -5, 20);
		ligne.setC2(new Coordonnees(25, 50));

		assertEquals(10, ligne.getC1().getAbscisse(), EPSILON);
		assertEquals(15, ligne.getC1().getOrdonnee(), EPSILON);
		assertEquals(25, ligne.getC2().getAbscisse(), EPSILON);
		assertEquals(50, ligne.getC2().getOrdonnee(), EPSILON);
	}
	
	@Test
	public void testDeplacerDe() {
		Ligne ligne = new Ligne(new Coordonnees(10, 15), -5, 20);
		ligne.deplacerDe(5, 5);

		assertEquals(15, ligne.getPosition().getAbscisse(), EPSILON);
		assertEquals(20, ligne.getPosition().getOrdonnee(), EPSILON);
		assertEquals(-5, ligne.getLargeur(), EPSILON);
		assertEquals(20, ligne.getHauteur(), EPSILON);
	}
	
	@Test
	public void testDeplaceVers() {
		Ligne ligne = new Ligne(new Coordonnees(10, 15), -5, 20);
		ligne.deplacerVers(15, 20);

		assertEquals(15, ligne.getPosition().getAbscisse(), EPSILON);
		assertEquals(20, ligne.getPosition().getOrdonnee(), EPSILON);
		assertEquals(-5, ligne.getLargeur(), EPSILON);
		assertEquals(20, ligne.getHauteur(), EPSILON);
	}

	@Test
	public void testToStringFrAnglePos() {
		Ligne ligne = new Ligne(new Coordonnees(10, 10), -5, 20);
		
		Locale.setDefault(Locale.FRENCH);
		
		assertEquals("[Ligne] c1 : (10,0 , 10,0) c2 : (5,0 , 30,0) longueur : 20,62 angle : 104,04°/n couleur = R0,V0,B0 epaisseur = 1px", ligne.toString());
	}
	
	@Test
	public void testToStringFrAngleNeg() {
		Ligne ligne = new Ligne(new Coordonnees(10, 10), 10, -80);
		
		Locale.setDefault(Locale.FRENCH);
		
		assertEquals("[Ligne] c1 : (10,0 , 10,0) c2 : (20,0 , -70,0) longueur : 80,62 angle : 277,13°/n couleur = R0,V0,B0 epaisseur = 1px", ligne.toString());
	}
	
	@Test
	public void testToStringEn() {
		Ligne ligne = new Ligne(new Coordonnees(10, 10), -5, 20);
		
		Locale.setDefault(Locale.ENGLISH);
		
		assertEquals("[Ligne] c1 : (10.0 , 10.0) c2 : (5.0 , 30.0) longueur : 20.62 angle : 104.04°/n couleur = R0,G0,B0 epaisseur = 1px", ligne.toString());
	}

	@Test
	public void testContient() {
		Ligne ligne = new Ligne(new Coordonnees(10, 10), 20, 20);

		assertTrue(ligne.contient(new Coordonnees(20, 20)));
	}
	
	@Test
	public void testContientPas() {
		Ligne ligne = new Ligne(new Coordonnees(10, 10), 20, 20);

		assertFalse(ligne.contient(new Coordonnees(20, -20)));
	}
}

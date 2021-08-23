package fr.eseo.poo.projet.artiste.modele.formes;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class FormeTestCadreParameterized {

	// Parametres
	private double largeur, hauteur, cadreMinX, cadreMinY, cadreMaxX, cadreMaxY;

	public static final double EPSILON = 1e-6;

	// Constructeur
	public FormeTestCadreParameterized(double largeur, double hauteur, double cadreMinX, double cadreMinY, double cadreMaxX, double cadreMaxY) {
		this.largeur = largeur;
		this.hauteur = hauteur;
		this.cadreMinX = cadreMinX;
		this.cadreMinY = cadreMinY;
		this.cadreMaxX = cadreMaxX;
		this.cadreMaxY = cadreMaxY;
	}

	// Jeu de test
	@Parameters(name = "test{index} : {0}, {1}, {2}, {3}, {4}, {5}")
	public static Collection<Object[]> dt() {
		Object[][] data = new Object[][] { 
			{ 10, 10, 0, 0, 10, 10}, 
			{ -10, 10, -10, 0, 0, 10},
			{ -10, -10, -10, -10, 0, 0},
			{ 10, -10, 0, -10, 10, 0}
		};
		return Arrays.asList(data);
	}

	@Test
	public void test() {
		Ligne ligne = new Ligne(new Coordonnees(0, 0), largeur, hauteur);

		assertEquals(cadreMinX, ligne.getCadreMinX(), EPSILON);
		assertEquals(cadreMinY, ligne.getCadreMinY(), EPSILON);
		assertEquals(cadreMaxX, ligne.getCadreMaxX(), EPSILON);
		assertEquals(cadreMaxY, ligne.getCadreMaxY(), EPSILON);
	}
}

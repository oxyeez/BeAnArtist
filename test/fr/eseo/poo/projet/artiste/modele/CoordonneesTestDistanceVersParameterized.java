package fr.eseo.poo.projet.artiste.modele;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class CoordonneesTestDistanceVersParameterized {

	// Parametres
	private double x1, y1, x2, y2, distance;

	public static final double EPSILON = 1e-6;

	// Constructeur
	public CoordonneesTestDistanceVersParameterized(double x1, double y1, double x2, double y2, double distance) {
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
		this.distance = distance;
	}

	// Jeu de test
	@Parameters(name = "test{index} : {0}, {1}, {2}, {3}, {4}")
	public static Collection<Object[]> dt() {
		Object[][] data = new Object[][] { 
			{1, 6, 4, 8, Math.sqrt(9 + 4)}, 
			{1, 6, 4, 3, Math.sqrt(9 + 9)},
			{1, 6, -4, 8, Math.sqrt(25 + 4)}, 
			{1, 6, 4, -2, Math.sqrt(9 + 64)},
			{1, 6, -4, -2, Math.sqrt(25 + 64)}, 
			{4, 8, 1, 6, Math.sqrt(9 + 4)},
			{4, 3, 1, 6, Math.sqrt(9 + 9)}, 
			{-4, 8, 1, 6, Math.sqrt(25 + 4)},
			{4, -2, 1, 6, Math.sqrt(9 + 64)}, 
			{-4, -2, 1, 6, Math.sqrt(25 + 64)}, 
		};
		return Arrays.asList(data);
	}

	// Test
	@Test
	public void testUserId() {
		Coordonnees coord1 = new Coordonnees(x1, y1);
		Coordonnees coord2 = new Coordonnees(x2, y2);
		
		assertEquals(distance, coord1.distanceVers(coord2), EPSILON);
	}

}

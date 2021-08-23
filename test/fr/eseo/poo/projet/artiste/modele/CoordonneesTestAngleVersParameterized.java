package fr.eseo.poo.projet.artiste.modele;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class CoordonneesTestAngleVersParameterized {

	// Parametres
	private double x1, y1, x2, y2, angle;

	public static final double EPSILON = 1e-6;

	// Constructeur
	public CoordonneesTestAngleVersParameterized(double x1, double y1, double x2, double y2, double angle) {
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
		this.angle = angle;
	}

	// Jeu de test
	@Parameters(name = "test{index} : {0}, {1}, {2}, {3}, {4}")
	public static Collection<Object[]> dt() {
		Object[][] data = new Object[][] { 
			{ 0, 0, 0, 0, 0 }, 
			{ 0, 0, 1, 1, Math.PI / 4 }, 
			{ 0, 0, 0, 1, Math.PI / 2 },
			{ 0, 0, 1, -1, -Math.PI / 4 }, 
			{ 0, 0, 0, -1, -Math.PI / 2 }, 
			{ 0, 0, -1, 0, Math.PI },
			{ 0, 0, -1, -1, -(3 * Math.PI) / 4 }
		};
		return Arrays.asList(data);
	}

	@Test
	public void test() {
		Coordonnees coord1 = new Coordonnees(x1, y1);
		Coordonnees coord2 = new Coordonnees(x2, y2);

		assertEquals(angle, coord1.angleVers(coord2), EPSILON);
	}
}

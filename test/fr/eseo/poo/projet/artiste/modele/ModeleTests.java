package fr.eseo.poo.projet.artiste.modele;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import fr.eseo.poo.projet.artiste.modele.formes.LigneTest;
import fr.eseo.poo.projet.artiste.modele.formes.PolygoneTest;
import fr.eseo.poo.projet.artiste.modele.formes.RectangleTest;
import fr.eseo.poo.projet.artiste.modele.formes.TriangleEquilateralTest;
import fr.eseo.poo.projet.artiste.modele.formes.TriangleIsoceleTest;
import fr.eseo.poo.projet.artiste.modele.formes.TriangleRectangleTest;
import fr.eseo.poo.projet.artiste.modele.formes.TriangleTest;
import fr.eseo.poo.projet.artiste.modele.formes.EllipseTest;
import fr.eseo.poo.projet.artiste.modele.formes.EtoileTest;
import fr.eseo.poo.projet.artiste.modele.formes.FormeTestCadreParameterized;
import fr.eseo.poo.projet.artiste.modele.formes.CarreTest;
import fr.eseo.poo.projet.artiste.modele.formes.CercleTest;

@RunWith(Suite.class)
@SuiteClasses({ CoordonneesTest.class, CoordonneesTestAngleVersParameterized.class,
		CoordonneesTestDistanceVersParameterized.class, LigneTest.class, EllipseTest.class, 
		CercleTest.class, EtoileTest.class, FormeTestCadreParameterized.class, RectangleTest.class,
		CarreTest.class, PolygoneTest.class, TriangleTest.class, TriangleIsoceleTest.class, 
		TriangleEquilateralTest.class, TriangleRectangleTest.class})
public class ModeleTests {

}

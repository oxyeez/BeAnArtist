package fr.eseo.poo.projet.artiste.modele.formes;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;
import fr.eseo.poo.projet.artiste.modele.Vecteur;

/**
 * @since extension
 * @author marcelin
 *
 * Représentation abstraite du Triangle Equilateral dérivé de la class Triangle
 */
public class TriangleEquilateral  extends Triangle {
	
	public TriangleEquilateral() {
		this(BASE1_PAR_DEFAUT, BASE2_PAR_DEFAUT);
	}
	
	public TriangleEquilateral(Coordonnees base1) {
		this(base1, new Coordonnees(base1.getAbscisse()+100, base1.getOrdonnee()+100));
	}
	
	public TriangleEquilateral(Coordonnees base1, Coordonnees base2) {
		super(base1, base2, calculSommet(base1, base2));
	}
	
	/**
	 * Methode qui détermine le sommet de façon à ce que le triangle soit equilateral
	 * 
	 * la hauteur d'un triangle équilateral étant égale à la base * sqrt(3)/2
	 * on trouve le point du milieu de la base et on le déplace de la hauteur pour obtenir le sommet
	 * 
	 * @param base1
	 * @param base2
	 * @return	les Coordonnees du sommet
	 */
	private static Coordonnees calculSommet(Coordonnees base1, Coordonnees base2) {
		Vecteur vectBase = new Vecteur(base1, base2);
		Vecteur vectHauteur = vectBase.normal();
		vectHauteur.produitAvecReel(Math.sqrt(3)/2);
		Coordonnees milieu = base1.milieu(base2);
		milieu.deplacerDe(vectHauteur);
		return milieu;
	}
}

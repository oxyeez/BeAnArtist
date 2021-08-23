package fr.eseo.poo.projet.artiste.modele.formes;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;
import fr.eseo.poo.projet.artiste.modele.Droite;
import fr.eseo.poo.projet.artiste.modele.Vecteur;

/**
 * @since extension
 * @author marcelin
 *
 * Représentation abstraite du Triangle Isocele dérivé du Triangle
 */
public class TriangleIsocele extends Triangle {
	
	public TriangleIsocele() {
		this(BASE1_PAR_DEFAUT, BASE2_PAR_DEFAUT, SOMMET_PAR_DEFAUT);
	}
	
	public TriangleIsocele(Coordonnees base1) {
		this(base1, calculBase2Defaut(base1), calculSommetDefaut(base1, calculBase2Defaut(base1), 1.5));
	}
	
	public TriangleIsocele(Coordonnees base1, Coordonnees base2) {
		this(base1, base2, calculSommetDefaut(base1, base2, 1.5));
	}
	
	public TriangleIsocele(Coordonnees base1, Coordonnees base2, Coordonnees sommet) {
		super(base1, base2, calculSommet(base1, base2, sommet));
	}
	
	/**
	 * On calcul la plus courte distance entre le point donné comme sommet et la droite qui passe par la base pour obtenir la hauteur
	 * on trouve le point du milieu de la base et on le déplace de la hauteur pour obtenir le sommet
	 * 
	 * @param base1
	 * @param base2
	 * @param sommet
	 * @return	les Coordonnees du sommet
	 */
	private static Coordonnees calculSommet(Coordonnees base1, Coordonnees base2, Coordonnees sommet) {
		Droite base = new Droite(base1, base2);
		Vecteur vectBaseSommet = new Vecteur(base.projeteOrthogonal(sommet), sommet);
		Coordonnees sommetFinal = base1.milieu(base2);
		sommetFinal.deplacerDe(vectBaseSommet.getAbscisse(), vectBaseSommet.getOrdonnee());
		return sommetFinal;
	}
}
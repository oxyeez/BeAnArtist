package fr.eseo.poo.projet.artiste.modele.formes;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;

/**
 * @since extension
 * @author marcelin
 *
 * Représentation abstraite du carré, inspiré de la classe Cercle
 */
public class Carre extends Rectangle {
	
	public Carre() {
		super(LARGEUR_PAR_DEFAUT, LARGEUR_PAR_DEFAUT);
	}
	
	public Carre(double taille) {
		super(taille, taille);
	}
	
	public Carre(Coordonnees position) {
		super(position, LARGEUR_PAR_DEFAUT, LARGEUR_PAR_DEFAUT);
	}
	
	public Carre(Coordonnees position, double taille) {
		super(position, taille, taille);
	}
	
	@Override
	public void setHauteur(double taille) {
		setLargeur(taille);
	}
	
	@Override
	public void setLargeur(double taille) {
		if(taille < 0)
			throw new IllegalArgumentException("La taille est négative");
		else {
			super.setLargeur(taille);
			super.setHauteur(taille);
		}
	}
}
